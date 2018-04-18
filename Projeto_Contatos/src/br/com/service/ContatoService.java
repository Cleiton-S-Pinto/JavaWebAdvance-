package br.com.service;

import java.sql.SQLException;
import java.util.List;

import br.com.model.Contato;
import br.com.repository.ContatoRepository;

public class ContatoService {

	private ContatoRepository repository;
	
	public ContatoService() throws ClassNotFoundException, SQLException{
		
		this.repository = new ContatoRepository();
	}

	public void salvar(Contato contato) throws ClassNotFoundException, SQLException{
		this.repository.salvar(contato);
	}
	
	public List<Contato> listar() throws ClassNotFoundException, SQLException{
		return this.repository.listar();
	}
	
	public void deletar(Long idContato) throws ClassNotFoundException, SQLException{
		this.repository.deletar(idContato);	
	}
	
	public Contato buscar(Long idContato) throws ClassNotFoundException, SQLException{
		return this.repository.buscar(idContato);
	}
	
	public void alterar(Contato contato) throws SQLException, ClassNotFoundException{
		this.repository.alterar(contato);
	}
	
	public ContatoRepository getRepository() {
		return repository;
	}

	public void setRepository(ContatoRepository repository) {
		this.repository = repository;
	}
	
	
	
}
