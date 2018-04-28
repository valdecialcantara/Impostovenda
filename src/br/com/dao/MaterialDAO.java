package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.factory.ConnectionFactory;
import br.com.model.Material;
/**
 * @author VBA
 *
 */
public class MaterialDAO {
	private Connection conn;

		 
	public void update(Material material, int qtde){
		 
		 String sql = "UPDATE material SET stockQuantity = ? WHERE id = ?";
		 Integer quantidade = 0;
		 PreparedStatement pstm = null;
		 
		 
		 try {
			 //Cria uma conexão com o banco
			 conn = ConnectionFactory.getConnection();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = conn.prepareStatement(sql);

			 if (qtde <= material.getStockQuantity()) {
				 quantidade = material.getStockQuantity() - qtde;
				 pstm.setInt(1, quantidade);
				 pstm.setInt(2, material.getId());
				 
				 //Executa a sql para inserção dos dados
				 pstm.execute();
			 }
			 } catch (Exception e) {
			 
				 e.printStackTrace();
			 }finally{
			 
				 //Fecha as conexões
			 
				 try{
				 if(pstm != null){
				 
					 pstm.close();
				 }
				 
				 if(conn != null){
					 conn.close();
				 }
				 
				 }catch(Exception e){
				 
					 e.printStackTrace();
				 }
		 }
	}

	public List<Material> getMaterials(){
		 
		 String sql = "SELECT * FROM material";
		 List<Material> materials = new ArrayList<Material>();
		 
		 PreparedStatement pstm = null;
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
		 conn = ConnectionFactory.getConnection();
		 
		 pstm = conn.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 //Enquanto existir dados no banco de dados, faça
		 while(rset.next()){
		 
			 Material material = new Material();
			 
			 material.setId(rset.getInt("id"));
             material.setInput(rset.getInt("input"));
             material.setName(rset.getString("name"));
             material.setPrice(rset.getFloat("price"));
             material.setStockQuantity(rset.getInt("stockQuantity"));
             material.setIdGroup(rset.getInt("idGroup"));
             material.setImported(rset.getBoolean("imported"));
                          
             //Adiciono o produto recuperado, à lista de materials
			 materials.add(material);
		 }
		 
    	// Sorting by inputs
		 Collections.sort(materials);
		 
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally{
		 
		 try{
		 
		 if(rset != null){
		 
		 rset.close();
		 }
		 
		 if(pstm != null){
		 
		 pstm.close();
		 }
		 
		 if(conn != null){
		 conn.close();
		 }
		 
		 }catch(Exception e){
		 
		 e.printStackTrace();
		 }
		 }
		 
		 return materials;
	}
	
}
