package br.com.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.connection.Conexao;

public class Teste {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = Conexao.getConnection();
	}

}
