package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.models.Funcionario;

// Aqui se encontra os métodos criados tendo uma implementacao de um DAO, para fins organizacionais, famoso the dao patter

public class DaoFuncionarioMetodos implements DaoFuncionario {
	
	
	private Connection connection;
	
	public DaoFuncionarioMetodos(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public void mostrarFuncionarios() throws SQLException {
		
		String sql = "SELECT * FROM funcionarios";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "\t" +
								rs.getString("nome") + "\t" +
								rs.getString("data_nascimento") + "\t" +
								rs.getBigDecimal("salario") + "\t" +
								rs.getString("funcao") + "\t");
		}
	}

	@Override
	public void inserirFuncionario(Funcionario funcionario) throws SQLException  {

		String sql = "INSERT INTO funcionarios(nome, data_nascimento,"
					+ "salario, funcao) VALUES (?, ?, ?, ?)";
		
		 PreparedStatement stm = connection.prepareStatement(sql);
		 
		 stm.setString(1, funcionario.getNome());
		 stm.setString(2, funcionario.getDataNascimento().toString());
		 stm.setBigDecimal(3, funcionario.getSalario());
		 stm.setString(4, funcionario.getFuncao());
		 stm.executeUpdate();
		 
	}

	@Override
	public void removerFuncionario(Integer id) throws SQLException {
		
		String sql = "DELETE FROM funcionarios where id = ?";
		
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.setInt(1, id);
		stm.executeUpdate();
		
		System.out.println("Remoção feita com sucesso!");
	}

	@Override
	public void mostrarFuncionario(Integer id) throws SQLException {
	}

	@Override
	public void mostrarFuncionarioDistinto() throws SQLException, ParseException {
		
		String sql = "SELECT * FROM funcionarios";
		PreparedStatement stm = connection.prepareStatement(sql);
		
		stm.execute();
		
		ResultSet rs = stm.getResultSet();
		
		while (rs.next()) {
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String dateDefault = rs.getString("data_nascimento");
			
			Date parsedDate = format.parse(dateDefault);
			SimpleDateFormat print = new SimpleDateFormat("yyyy/MM/dd");
			
			System.out.println(rs.getInt("id") + "\t" +
								rs.getString("nome") + "\t" +
								print.format(parsedDate) + "\t" +
								rs.getBigDecimal("salario") + "\t" +
								rs.getString("funcao") + "\t");
		}
	}
}