package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import factory.RepoFactory;
import modelos.Usuario;
import repositories.interfaces.UsuarioRepo;


@WebServlet("/saldo")
public class SaldoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioRepo usuariosRepo;
    
    public SaldoController() {
    	
    	RepoFactory factory = new RepoFactory();
    	this.usuariosRepo =factory.getUsuarioRepo();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");	
		if( u ==null ) {
			response.sendError(401,"No autorizado");
			return;
		}
		
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
				switch (accion) {
			
			case "index" -> getIndex(request,response);
			case "agregar" -> getAgregar(request,response);
			case "transferir" -> getTransferir(request,response);
			
			
			default -> response.sendError(404);
			
		}
	}
		
		
	
	private void getTransferir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Usuario> usuarios = usuariosRepo.getAll();
		
		request.setAttribute("usuarios",usuarios);
		
		request.getRequestDispatcher("/views/saldo/transferencia.jsp").forward(request, response);
		
	}


	private void getAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		request.getRequestDispatcher("/views/saldo/agregar.jsp").forward(request, response);
			
		
	}



	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/views/saldo/index.jsp").forward(request, response);
	}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

				HttpSession session = request.getSession();
				Usuario u = (Usuario) session.getAttribute("usuario");
				
		
				if( u ==null ) {
					response.sendError(401,"No autorizado");
					return;
				}
				
				String accion = request.getParameter("accion");
				//accion = Optional.ofNullable(accion).orElse("insert");
				
				if(accion == null) {
					response.sendError(400,"No se brindo una accion");
					return;
				}
				
				switch (accion) {
				
				case "agregar" -> postAgregar(request,response); //confirmar la compra
				case "transferir" -> postTransferir(request,response); //confirmar la compra
				default -> response.sendError(404,"No existe la accion: "+ accion);
			
		}
		
	
		
		
		
		
	}


	private void postTransferir(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String usuarioId = request.getParameter("id");
		int id = Integer.parseInt(usuarioId);
		
		String sCantidad = request.getParameter("cantidad");
		double cantidad = Double.parseDouble(sCantidad);
			
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		
		u.setSaldo(u.getSaldo()-cantidad);
		
		Usuario usuTrans = usuariosRepo.findById(id);
		
		usuTrans.setSaldo(usuTrans.getSaldo()+cantidad);
			
		response.sendRedirect("carrito");
		
					
	}


	private void postAgregar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
	
		String sCantidad = request.getParameter("cantidad");
		double cantidad = Double.parseDouble(sCantidad);
			
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		
		u.setSaldo(u.getSaldo()+cantidad);
					
		response.sendRedirect("carrito");
		
		
		
	}
				

}
