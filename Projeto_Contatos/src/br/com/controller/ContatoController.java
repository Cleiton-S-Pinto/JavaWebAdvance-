package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Contato;
import br.com.service.ContatoService;

@WebServlet("/ContatoController")
public class ContatoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Contato contato;
	private ContatoService service;
	
    public ContatoController() throws ClassNotFoundException, SQLException {

    	this.service = new ContatoService();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		try{
		switch(action){
		
		case "editar":
			alterar(request, response);
			break;
		case "deletar":
			deletar(request, response);
			break;
		case "buscar":
			buscar(request, response);
			break;
		case "listar":
			listar(request, response);
		default:
			listar(request, response);
			break;
		}
		}catch(SQLException | ClassNotFoundException e){
			
			throw new ServletException(e);
		}
		
		
	}
    
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	List<Contato> contatos = this.service.listar();
    	request.setAttribute("contatos", contatos);
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_contato.jsp");
    	rd.forward(request, response);
    }

    public void deletar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	long id = Long.parseLong(request.getParameter("id"));
    	this.service.deletar(id);
    	listar(request, response);
    }

	public void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		long id = Long.parseLong(request.getParameter("id"));
		Contato contatoBuscar = this.service.buscar(id);
		request.setAttribute("contato", contatoBuscar);
		RequestDispatcher rd = request.getRequestDispatcher("atualizar_contato.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		
		this.contato = new Contato();
		
		this.contato.setNome(nome);
		this.contato.setTelefone(telefone);
		this.contato.setEmail(email);
		
		try {
			this.service.salvar(this.contato);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		try {
			listar(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterar (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		System.out.println("CHEGOU NO ALTERAR");
		long id = Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		String nome = request.getParameter("nome");
		System.out.println(nome);
		String telefone = request.getParameter("telefone");
		System.out.println(telefone);
		String email = request.getParameter("email");
		System.out.println(email);
		
		Contato contatoAlterar = new Contato();
		contatoAlterar.setNome(nome);
		contatoAlterar.setTelefone(telefone);
		contatoAlterar.setEmail(email);
		contatoAlterar.setId(id);
		
		this.service.alterar(contatoAlterar);
		
		listar(request, response);
	}
    	

}
