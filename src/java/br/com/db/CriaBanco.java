package br.com.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CriaBanco {

	public CriaBanco(Connection connection) throws SQLException {
		
		String dbCreate = "CREATE TABLE IF NOT EXISTS funcionarios\r\n" +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\r\n" +
                " nome VARCHAR NOT NULL,\r\n " + 
                " data_nascimento DATE,\r\n " + 
                " salario DECIMAL(6,2),\r\n"
                + "funcao VARCHAR\r\n " + 
                ");";
		
		PreparedStatement pst = connection.prepareStatement(dbCreate);
		pst.execute();
	}
}
