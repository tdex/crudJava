package nagem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nagem.connection.DbConnection;
import nagem.dao.ClienteDao;
import nagem.domain.Cliente;

public class ClientesService implements ClienteDao {

	Connection conn = new DbConnection().getConnections();

	@Override
	public void save(Cliente s) {
		try {
			if (s.getCpf() != null && s.getNome() != null) {
				PreparedStatement pst = conn
						.prepareStatement("insert into clientes(cpf, nome, idade) values (?, ?, ?)");

				pst.setLong(1, s.getCpf());
				pst.setString(2, s.getNome());
				pst.setString(3, s.getIdade().toString());

				pst.execute();
				pst.close();
				System.out.println("SUCESSO --- cliente inserido!");
			}
		} catch (Exception e) {
			System.err.println("não foi possível inserir o cliente. Tente novamente mais tarde!");
		}
	}

	@Override
	public void update(Cliente s) {
		try {
			if (s.getCpf() != null) {
				PreparedStatement pst = conn.prepareStatement("update clientes set nome=?, idade=? where cpf=?");

				pst.setString(1, s.getNome());
				pst.setString(2, s.getIdade().toString());
				pst.setLong(3, s.getCpf());

				pst.execute();
				pst.close();
				System.out.println("SUCESSO --- cliente atualizado!");
			}
		} catch (Exception e) {
			System.err.println("não foi possível atualizar o cliente. Tente novamente mais tarde!");
		}

	}

	@Override
	public void delete(Long id) {
		try {
			if (id != null) {
				PreparedStatement pst = conn.prepareStatement("delete from clientes where cpf=?");

				pst.setLong(1, id);
				pst.execute();
				pst.close();
				System.out.println("SUCESSO --- cliente deletado!");
			}
		} catch (Exception e) {
			System.err.println("Não foi possível deletar o cliente. Tente novamente mais tarde!");
		}
	}

	@Override
	public Cliente find(Long cpf) {
		Cliente c = null;

		try {
			if (cpf != null) {
				PreparedStatement pst = conn.prepareStatement("select nome, idade from clientes where cpf=?");
				pst.setLong(1, cpf);

				ResultSet rs = pst.executeQuery();

				if (!rs.isBeforeFirst()) {
					System.err.println("CPF não cadastrado!!");
				} else {
					while (rs.next()) {
						c = new Cliente(cpf, rs.getString("nome"), rs.getInt("idade"));
					}
				}

				pst.close();
			}
		} catch (Exception e) {
			System.err.println("Não foi possível realizar a busca!");
		}

		return c;
	}

	@Override
	public List<Cliente> list() {
		List<Cliente> lista = null;

		try {
			PreparedStatement pst = conn.prepareStatement("select * from clientes");
			ResultSet rs = pst.executeQuery();

			if (!rs.isBeforeFirst()) {
				System.err.println("Não existem clientes cadastrados!");
			} else {
				lista = new ArrayList<>();

				while (rs.next()) {
					lista.add(new Cliente(rs.getLong("cpf"), rs.getString("nome"), rs.getInt("idade")));
				}
			}

			pst.close();
		} catch (SQLException e) {
			System.err.println("Não foi possível realizar a consulta!");
			e.printStackTrace();
		}

		return lista;
	}

}
