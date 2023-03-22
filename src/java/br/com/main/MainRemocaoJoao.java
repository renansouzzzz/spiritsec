package br.com.main;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.connect.Connect;
import br.com.connect.CriaBanco;
import br.com.dao.DaoFuncionarioMetodos;

public class MainRemocaoJoao {

	public static void main(String[] args) throws SQLException, InterruptedException {
		
		Connect con = new Connect();
		Connection connect = con.iniciaConexao();
		new CriaBanco(connect);
		
		DaoFuncionarioMetodos dao = new DaoFuncionarioMetodos(connect);
		
		dao.removerFuncionario(2);
	}

}
