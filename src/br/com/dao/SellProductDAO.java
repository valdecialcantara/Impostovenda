package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import br.com.factory.ConnectionFactory;
import br.com.model.GroupMaterial;
import br.com.model.Material;
import br.com.model.SellProduct;
/**
 * @author VBA
 *
 */
public class SellProductDAO {
	private Connection conn;

	public void update(SellProduct sellProduct){
		 
		 String sql = "UPDATE sellProduct SET quantity = ? WHERE id = ?";
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 //Cria uma conexão com o banco
			 conn = ConnectionFactory.getConnection();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = conn.prepareStatement(sql);

			 pstm.setInt(1, sellProduct.getQuantity());
			 pstm.setInt(2, sellProduct.getId());
			 
			 //Executa a sql para inserção dos dados
			 pstm.execute();
			 
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

	public void insert(SellProduct sellProduct){
		 
		 String sql = "INSERT INTO sellProduct (input, name, price, duty, quantity, idMaterial) VALUES (?,?,?,?,?,?,?)";
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 //Cria uma conexão com o banco
			 conn = ConnectionFactory.getConnection();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = conn.prepareStatement(sql);

			 pstm.setInt(1, sellProduct.getInput());
			 pstm.setString(2, sellProduct.getName());
			 pstm.setFloat(3, sellProduct.getPrice());
			 pstm.setFloat(4, sellProduct.getDuty());
			 pstm.setInt(5, sellProduct.getQuantity());
			 pstm.setInt(6, sellProduct.getIdMaterial());
			 
			 //Executa a sql para inserção dos dados
			 pstm.execute();
			 
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

	public List<SellProduct> getSellProducts(){
		 
		 String sql = "SELECT * FROM sellProduct";
		 List<SellProduct> sellProducts = new ArrayList<SellProduct>();
		 
		 PreparedStatement pstm = null;
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
		 conn = ConnectionFactory.getConnection();
		 
		 pstm = conn.prepareStatement(sql);
		 
		 rset = pstm.executeQuery();
		 
		 //Enquanto existir dados no banco de dados, faça
		 while(rset.next()){
		 
			 SellProduct sellProduct = new SellProduct();
			 
			 sellProduct.setId(rset.getInt("id"));
             sellProduct.setInput(rset.getInt("input"));
             sellProduct.setName(rset.getString("name"));
             sellProduct.setPrice(rset.getFloat("price"));
             sellProduct.setDuty(rset.getFloat("duty"));
             sellProduct.setQuantity(rset.getInt("quantity"));
             sellProduct.setIdMaterial(rset.getInt("idMaterial"));
                          
             //Adiciono o produto recuperado, à lista de sellProducts
			 sellProducts.add(sellProduct);
		 }
		 
    	// Sorting by inputs
		 Collections.sort(sellProducts);
		 
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
		 
		 return sellProducts;
	}
	
	public void CalcularImposto(Material material) {
		SellProduct sellProduct = new SellProduct();
		float imposto10 = 0;
		float imposto5 = 0;
		float valor = 0;
		
		sellProduct.setIdMaterial(material.getId());
		sellProduct.setInput(material.getInput());
		sellProduct.setName(material.getName());
		sellProduct.setPrice(material.getPrice());
		sellProduct.setQuantity(material.getStockQuantity());
		
		Boolean imp = material.getImported();
		GroupMaterial groupMaterial = new GroupMaterial();
		Boolean duty = groupMaterial.getDutyFree();
		
		if (imp) {
			imposto10 =  material.getPrice() * 10 / 100;
		}
		if (!duty) {
			imposto5 =  material.getPrice() * 5 / 100;
		}
		valor = imposto10 + imposto5;
		sellProduct.setDuty(valor);

		insert(sellProduct);
	}
	
}
