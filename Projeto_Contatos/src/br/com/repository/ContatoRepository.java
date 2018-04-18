package br.com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connection.Conexao;
import br.com.model.Contato;

public class ContatoRepository {
	
	private Connection con; 

	public ContatoRepository() throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
	}
	
	public boolean salvar(Contato contato) throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
		String insert = "INSERT INTO contato (nome, telefone , email) VALUES (?,?,?) "; 
		PreparedStatement state = this.con.prepareStatement(insert);
		
		state.setString(1, contato.getNome());
		state.setString(2, contato.getTelefone());
		state.setString(3, contato.getEmail());
		
		boolean salvo = state.executeUpdate() > 0;
		state.close();
		Conexao.close();
		return salvo;
	}
	
	public List<Contato> listar() throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
		List<Contato> contatos = new ArrayList();
		String list = "SELECT * FROM contato ";
		PreparedStatement state = this.con.prepareStatement(list);
		
		ResultSet res = state.executeQuery();
		
		while (res.next()){
			
			Contato contato = new Contato();
			contato.setId(res.getLong("id"));
			contato.setNome(res.getString("nome"));
			contato.setTelefone(res.getString("telefone"));
			contato.setEmail(res.getString("email"));
			
			contatos.add(contato);
		}
		
		return contatos;
	}
	
	public boolean deletar(Long idContato) throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
		String delete = "DELETE FROM contato WHERE id = ? ";
		PreparedStatement states = this.con.prepareStatement(delete);
		states.setLong(1, idContato);
		
		boolean deletado = states.executeUpdate() > 0;
		
		states.close();
		Conexao.close();
		
		return deletado;
	}
	
	public Contato buscar(Long idContato) throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
		String buscar = "SELECT * FROM contato WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(buscar);
		
		state.setLong(1, idContato);
		
		ResultSet res = state.executeQuery();
		Contato contato = new Contato();
		
		while(res.next()){
			
			
			contato.setId(res.getLong("id"));
			contato.setNome(res.getString("nome"));
			contato.setTelefone(res.getString("telefone"));
			contato.setEmail(res.getString("email"));
			
		}
		
		return contato;
	}
	
	public boolean alterar(Contato contato) throws SQLException, ClassNotFoundException{
		
		this.con = Conexao.getConnection();
		
		String update = "UPDATE contato set nome = ?, telefone = ?, email = ? WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(update);
		
		state.setString(1, contato.getNome());
		state.setString(2,contato.getTelefone());
		state.setString(3, contato.getEmail());
		state.setLong(4, contato.getId());
		
		boolean alterado = state.executeUpdate() > 0;
		
		state.close();
		
		return alterado;
	}
	
	public Connection getCon(){
		return this.con;
	}
	
	public void setCon(Connection con){
		this.con = con;
	}
	
	

}
