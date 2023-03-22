package br.com.dao;

import java.sql.SQLException;
import java.text.ParseException;

import br.com.models.Funcionario;

public interface DaoFuncionario {
	
	void mostrarFuncionarios() throws SQLException;
	
	void mostrarFuncionario(Integer id) throws SQLException;
	
	void mostrarFuncionarioDistinto() throws SQLException, ParseException;
	
	void inserirFuncionario(Funcionario funcionario) throws SQLException;
	
	void removerFuncionario(Integer id) throws SQLException;
}
