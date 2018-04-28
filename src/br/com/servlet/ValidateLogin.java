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
import br.com.dao.UserDAO;
import br.com.model.Material;

@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet {

	private static final long serialVersionUID = -7134783150035639683L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

    	boolean valid = false;
    	String login_form = request.getParameter("login"); 		// Pega o Login vindo do formulario
    	String senha_form = request.getParameter("password"); 	// Pega a senha vinda do formulario

    	try {
    		UserDAO dao = new UserDAO(); //cria uma instancia do DAO usuario
    		valid = dao.validate(login_form, senha_form);
    	}
    	catch ( Exception e ){

    	}

    	//se nao encontrou usuario no banco, redireciona para a pagina de erro!
    	if (valid) {
    		
            List<Material> listMaterials = new ArrayList<Material>();
        	
        	MaterialDAO empDao = new MaterialDAO(); //cria uma instancia do DAO Material
        	listMaterials = empDao.getMaterials();
        	
			request.setAttribute("listMaterials", listMaterials);
        	request.getRequestDispatcher("Material.jsp").forward(request, response);
        	
    		return;
    		
    	}
    	else{
    		request.setAttribute("mensagem", "Invalid login or password.");
    		request.getRequestDispatcher("Index.jsp").forward(request, response);
			return;
    	}

    }
}
