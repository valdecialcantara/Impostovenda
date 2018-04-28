package br.com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author VBA
 *
 */
public class ConnectionFactory {

	//Nome do usuário do mysql
	private static final String USERNAME = "root";

	//Senha do mysql
	private static final String PASSWORD = "Admin";

	//Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/impostovenda";
	/**
	* Cria uma conexão com o banco de dados MySQL
	* @throws SQLException
	*/
	public static Connection getConnection()throws SQLException {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			return connection;
			}
		catch(ClassNotFoundException ex){
			System.err.print( "ClassNotFoundException: " );  
            System.err.println( ex.getMessage () );  
		}
		catch(Exception e){
			throw new SQLException (e.getMessage());
		}
		return null;
	}
	
}
