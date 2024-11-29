package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelos.Usuario;

@WebServlet("/")
public class RootController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RootController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");

		if( u ==null ) {
			response.sendRedirect("auth");
			return;
		}
		response.sendRedirect("articulo");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
