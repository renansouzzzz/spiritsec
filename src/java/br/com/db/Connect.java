package br.com.connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	// conexao para ser instanciada em cada código "main" ou seja, para cada código, um novo connection
	public static Connection iniciaConexao() throws InterruptedException {
		
		try {
			
			Connection connection = DriverManager.getConnection("jdbc:sqlite:banco.db");
			System.out.println("Conexão estabelecida com sucesso!");
			
			return connection;
		}
		
		catch (Exception e) {
			
			System.err.println("Conexão não estabelecida!");
		}
		
		return null;
	}
}
