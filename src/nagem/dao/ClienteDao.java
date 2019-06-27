package nagem.dao;

import java.util.List;

import nagem.domain.Cliente;

public interface ClienteDao {
	public void save(Cliente s);

	public void update(Cliente s);

	public void delete(Long id);

	public Cliente find(Long id);

	public List<Cliente> list();
}
