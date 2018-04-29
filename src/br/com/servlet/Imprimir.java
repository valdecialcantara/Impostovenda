package br.com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dao.MaterialDAO;
import br.com.model.Material;

@WebServlet("/Imprimir")
public class Imprimir extends HttpServlet {

	private static final long serialVersionUID = -7134783150035639683L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

            List<Material> listMaterials = new ArrayList<Material>();
        	
        	MaterialDAO empDao = new MaterialDAO(); //cria uma instancia do DAO Material
        	listMaterials = empDao.getMaterials(0);
        	
			request.setAttribute("listMaterials", listMaterials);
        	request.getRequestDispatcher("Material.jsp").forward(request, response);
        	
    		return;
    		
    }
}
