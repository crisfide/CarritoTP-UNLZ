package controllers;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ArticulosController")
public class ArticulosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ArticulosController() {
        super();        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(400);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
		
		switch (accion) {
			//http://localhost:8080/Carrito/ArticulosController?accion=bienvenido
			case "bienvenido" -> getBienvenido(request,response);
			case "index" -> getIndex(request,response);
			case "show" -> getShow(request,response);
			case "edit" -> getEdit(request,response);
			case "create" -> getCreate(request,response);		
			
			default -> response.sendError(404);
		}
	}


	private void getBienvenido(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/bienvenido.jsp").forward(request, response);
	}

	private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulo/create.jsp").forward(request, response);
	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulo/edit.jsp").forward(request, response);
	}

	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulo/show.jsp").forward(request, response);

	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulo/index.jsp").forward(request, response);

	}



}



















