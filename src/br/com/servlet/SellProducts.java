package br.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.GroupMaterialDAO;
import br.com.dao.MaterialDAO;
import br.com.dao.SellProductDAO;
import br.com.model.GroupMaterial;
import br.com.model.Material;
import br.com.model.SellProduct;


/**
 * Servlet implementation class PromoteEmployee
 */
@WebServlet("/SellProducts")
public class SellProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<SellProduct> listSellProducts = new ArrayList<SellProduct>();	
	List<Material> materials = new ArrayList<Material>();
	List<GroupMaterial> groupMaterials = new ArrayList<GroupMaterial>();
	Integer inputSel = 0; 
	boolean valid = true;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellProducts() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

		 
		String entrada = request.getParameter("input"); 		// Pega a entrada para venda dos produtos vindo do formulario
		int input = Integer.parseInt(entrada);
		
    	SellProductDAO sellDao = new SellProductDAO(); //cria uma instancia do DAO SellProduct
 
    	MaterialDAO dao = new MaterialDAO(); //cria uma instancia do DAO produtos
    	materials = dao.getMaterials();
    	
    	GroupMaterialDAO groupMaterialDAO = new GroupMaterialDAO();  //cria uma instancia do DAO do grupo de produtos
    	groupMaterials = groupMaterialDAO.getGroupMaterials();
    	
    	//Calcular impostos
    	valid = Calculate(materials, input);

        if (valid) {
    		//Vender produtos
            listSellProducts = sellDao.getSellProducts(input);

        	request.setAttribute("listSellProducts", listSellProducts);
         	request.getRequestDispatcher("SellProduct.jsp").forward(request, response);
    		return;
        }
		else {
/*            List<Material> listMaterials = new ArrayList<Material>();
        	MaterialDAO empDao = new MaterialDAO(); //cria uma instancia do DAO Material
        	listMaterials = empDao.getMaterials();
*/
    		materials = dao.getMaterials();

			request.setAttribute("mensagem", "Saldo de produto insuficiente para venda!");
			request.setAttribute("listMaterials", materials);
        	request.getRequestDispatcher("Material.jsp").forward(request, response);			
			return;
		}
    		
    }
    
    //Calcula os impostos da venda
    private boolean Calculate(List<Material> materials, int input){
    	int inputSel = 0;
    	int qtde = 0;
    	boolean valid = true;
    	for (Material material : materials) {
    		inputSel = material.getInput();
    		
            if (input == inputSel) {
            	qtde = material.getStockQuantity();
            	if (qtde > 0) {
            		SellProductDAO dao = new SellProductDAO();
            		dao.CalcularImposto(material);

            		MaterialDAO matDao = new MaterialDAO();
            		matDao.update(material, qtde);
            		
            	}
            	else {
            		valid = false;
            	}
            	
            }
 		}
    	return valid;
    }

}

