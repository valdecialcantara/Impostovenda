package br.com.dao;

import br.com.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author VBA
 *
 */
public class UserDAO {

	private Connection conn;
		 
	public boolean validate(String login, String password){
		 
		 String sql = "SELECT login, password FROM user WHERE login = ? AND password = ?";
		 
		 PreparedStatement pstm = null;
		 ResultSet rs = null;
		 
		 try {
			 //Cria uma conexão com o banco
			 conn = ConnectionFactory.getConnection();
			 
	         //Testa sua conexão//  
	         if (conn != null) {
	 
				 //Cria um PreparedStatment, classe usada para executar a query
				 pstm = conn.prepareStatement(sql);
				 
				 //Adiciona o valor do primeiro parâmetro da sql
				 pstm.setString(1, login);
				 //Adicionar o valor do segundo parâmetro da sql
				 pstm.setString(2, password);
				 
				 //Executa a sql para inserção dos dados
				 rs = pstm.executeQuery();
			 
	 			 if (rs.next()) {
					//result found, means valid inputs
					return true;
				 }
	         }
		 
		 } catch (Exception e) {
		 
			 e.printStackTrace();
		 }finally{
		 
		     //Fecha as conexões
			 try{
				 if(pstm != null){
			 
					pstm.close();
					rs.close();
			 }
			 
				 if(conn != null){
					conn.close();
			 }
			 
			 }catch(Exception e){
			 
				 e.printStackTrace();
			 }
		 }
		 return false;
	}
	
}
