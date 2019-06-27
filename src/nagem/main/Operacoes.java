package nagem.main;

import java.util.List;
import java.util.Scanner;

import nagem.domain.Cliente;
import nagem.service.ClientesService;

public class Operacoes {
	ClientesService server = new ClientesService();

	public void inserir(Scanner s) {
		Cliente c = new Cliente();

		System.out.print("inserir novo cliente: \nCPF: ");
		c.setCpf(s.nextLong());

		System.out.print("Nome: ");
		c.setNome(s.next());

		System.out.print("Idade: ");
		c.setIdade((Integer) s.nextInt());

		server.save(c);
	}

	public void atualizar(Scanner s) {
		Cliente c = null;
		Long cpf = null;

		System.out.println("Qual o CPF do cliente a ser atualizado?");
		cpf = s.nextLong();
		c = server.find(cpf);

		if (c == null) {
			return;
		}

		System.out.println("Novo nome:");
		c.setNome(s.next());

		System.out.println("qual a idade?");
		c.setIdade(s.nextInt());

		server.update(c);
	}

	public void deletar(Scanner s) {
		Cliente c = null;
		Long cpf = null;
		
		System.out.print("Qual o CPF do cliente a ser deletado? ");
		
		cpf = s.nextLong();
		c = server.find(cpf);

		if (c == null) {
			return;
		}

		server.delete(cpf);
	}

	public void buscar(Scanner s) {
		Cliente c = null;
		
		System.out.print("Buscar cliente por cpf: ");
		c = server.find(s.nextLong());

		if (c != null) {
			System.out.println("CPF: " + c.getCpf() + "  || Nome: " + c.getNome() + "  || Idade: " + c.getIdade());
		}
	}

	public void listar() {
		List<Cliente> lista = server.list();

		if (lista == null) {
			return;
		}

		lista.forEach((c) -> {
			System.out.println("CPF: " + c.getCpf() + "  || Nome: " + c.getNome() + "  || Idade: " + c.getIdade());
		});
	}

}
