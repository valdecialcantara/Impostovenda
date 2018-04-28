package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.factory.ConnectionFactory;
import br.com.model.GroupMaterial;

/**
 * @author VBA
 *
 */
public class GroupMaterialDAO {

	private Connection conn;

	 
	public void update(GroupMaterial groupMaterial){
		 
		 String sql = "UPDATE GroupMaterial SET dutyFree = ? WHERE id = ?";
		 
		 PreparedStatement pstm = null;
		 
		 try {
			 //Cria uma conexão com o banco
			 conn = ConnectionFactory.getConnection();
			 
			 //Cria um PreparedStatment, classe usada para executar a query
			 pstm = conn.prepareStatement(sql);

			 pstm.setBoolean(1, groupMaterial.getDutyFree());
			 pstm.setInt(2, groupMaterial.getId());
			 
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

	public List<GroupMaterial> getGroupMaterials(){
		 
		 String sql = "SELECT * FROM GroupMaterial";
		 List<GroupMaterial> groupMaterials = new ArrayList<GroupMaterial>();
		 
		 PreparedStatement pstm = null;
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
			 conn = ConnectionFactory.getConnection();
			 
			 pstm = conn.prepareStatement(sql);
			 
			 rset = pstm.executeQuery();
			 
			 //Enquanto existir dados no banco de dados, faça
			 while(rset.next()){
			 
				 GroupMaterial groupMaterial = new GroupMaterial();
				 
				 groupMaterial.setId(rset.getInt("id"));
				 groupMaterial.setName(rset.getString("name"));
	             groupMaterial.setDutyFree(rset.getBoolean("dutyFree"));
	                          
	             //Adiciono o grupo de produtos recuperado, à lista groupMaterials
				 groupMaterials.add(groupMaterial);
			 }
			 
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
		 
		 return groupMaterials;
	}
	
	public GroupMaterial getGroupMaterial(int id){
		 
		 String sql = "SELECT * FROM groupMaterial WHERE ID = ?";
		 
		 PreparedStatement pstm = null;
		 //Classe que vai recuperar os dados do banco de dados
		 ResultSet rset = null;
		 
		 try {
			 conn = ConnectionFactory.getConnection();
			 
			 pstm = conn.prepareStatement(sql);
			//Adiciona o valor do primeiro parâmetro da sql
			 pstm.setInt(1, id);
			 
			 rset = pstm.executeQuery();
			 
			 //Enquanto existir dados no banco de dados, faça
			 if (rset.next()){
			 
				 GroupMaterial groupMaterial = new GroupMaterial();
				 
				 groupMaterial.setId(rset.getInt("id"));
				 groupMaterial.setName(rset.getString("name"));
				 groupMaterial.setDutyFree(rset.getBoolean("dutyFree"));
	          
				 return groupMaterial;
			 }
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
		 
		 return null;
	}
}
