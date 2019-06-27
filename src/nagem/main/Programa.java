package nagem.main;

import java.util.Scanner;

public class Programa {
	static int operacao;

	public static void operacoes(Scanner s) {
		System.out.println("\nQual operação você deseja fazer?");
		System.out.println("1 - Inserir");
		System.out.println("2 - Alterar");
		System.out.println("3 - Excluir");
		System.out.println("4 - Buscar");
		System.out.println("5 - Listar Todos");

		operacao = s.nextInt();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Operacoes op = new Operacoes();

		while (true) {
			operacoes(s);

			switch (operacao) {
			case 1:
				op.inserir(s);
				break;
			case 2:
				op.atualizar(s);
				break;
			case 3:
				op.deletar(s);
				break;
			case 4:
				op.buscar(s);
				break;
			case 5:
				op.listar();
				break;
			default:
				break;
			}
		}
	}

}
