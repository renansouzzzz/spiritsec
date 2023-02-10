package br.com.main;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import br.com.connect.Connect;
import br.com.connect.CriaBanco;
import br.com.dao.DaoFuncionarioMetodos;
import br.com.models.Funcionario;

public class MainInserirFuncionarios {

	public static void main(String[] args) throws SQLException, InterruptedException, IOException {
			
		// Neste código eu foquei na inserção de todos os funcionarios
		
		Connect con = new Connect();
		Connection connect = con.iniciaConexao();
		new CriaBanco(connect);
		
		DaoFuncionarioMetodos dao = new DaoFuncionarioMetodos(connect);
		
		Funcionario maria = new Funcionario("Maria", LocalDate.of(2000, 10, 18));
		maria.setSalario(new BigDecimal(2009.44));
		maria.setFuncao("Operador");
		
		Funcionario joao = new Funcionario("João", LocalDate.of(1990, 05, 12));
		joao.setSalario(new BigDecimal(2284.38));
		joao.setFuncao("Operador");
		
		Funcionario caio = new Funcionario("Caio", LocalDate.of(1961, 05, 2));
		caio.setSalario(new BigDecimal(9836.14));
		caio.setFuncao("Coordenador");
		
		Funcionario miguel = new Funcionario("Miguel", LocalDate.of(1988, 10, 14));
		miguel.setSalario(new BigDecimal(19119.88));
		miguel.setFuncao("Diretor");
		
		Funcionario alice = new Funcionario("Alice", LocalDate.of(1995, 01, 5));
		alice.setSalario(new BigDecimal(2234.68));
		alice.setFuncao("Recepcionista");
		
		Funcionario heitor = new Funcionario("Heitor", LocalDate.of(1999, 11, 19));
		heitor.setSalario(new BigDecimal(1582.72));
		heitor.setFuncao("Operador");
		
		Funcionario arthur = new Funcionario("Arthur", LocalDate.of(1993, 03, 31));
		arthur.setSalario(new BigDecimal(4071.84));
		arthur.setFuncao("Contador");
		
		Funcionario laura = new Funcionario("Laura", LocalDate.of(1994, 07, 8));
		laura.setSalario(new BigDecimal(3017.45));
		laura.setFuncao("Gerente");
		
		Funcionario heloisa = new Funcionario("Heloísa", LocalDate.of(2003, 05, 24));
		heloisa.setSalario(new BigDecimal(1606.85));
		heloisa.setFuncao("Eletricista");
		
		Funcionario helena = new Funcionario("Helena", LocalDate.of(1996, 9, 2));
		helena.setSalario(new BigDecimal(2799.93));
		helena.setFuncao("Gerente");
		
		dao.inserirFuncionario(maria);
		dao.inserirFuncionario(joao);
		dao.inserirFuncionario(caio);
		dao.inserirFuncionario(miguel);
		dao.inserirFuncionario(alice);
		dao.inserirFuncionario(heitor);
		dao.inserirFuncionario(arthur);
		dao.inserirFuncionario(laura);
		dao.inserirFuncionario(heloisa);
		dao.inserirFuncionario(helena);
		dao.mostrarFuncionarios();
	}
}
