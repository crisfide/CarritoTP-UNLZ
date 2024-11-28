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
import javax.sql.rowset.serial.SerialException;
import javax.websocket.Session;

import com.oracle.wls.shaded.org.apache.regexp.RE;

import factory.RepoFactory;
import modelos.Articulo;
import modelos.ElementoCarrito;
import modelos.Usuario;
import repositories.ArticuloRepoSingleton;
import repositories.interfaces.ArticuloRepo;
import repositories.interfaces.CarritoRepo;

@WebServlet("/carrito")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CarritoRepo carrito;
	private ArticuloRepo articulosRepo;
       
    public CarritoController() {       
    	   
       RepoFactory factory = new RepoFactory();
       this.carrito = factory.getCarrito();
       this.articulosRepo = factory.getArticuloRepo();
    }
    
    
    //DO-GET
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
			case "show" -> getShow(request,response);
			case "agregar" -> getAgregar(request,response); //cambiar la cantidad en el carrito
			case "quitar" -> getQuitar(request,response); //cambiar la cantidad en el carrito
			case "confirm" -> getConfirm(request,response); //confirmar la compra

			default -> response.sendError(404);
		}
	}

	private void getAgregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);		
		
		Articulo art = this.articulosRepo.findById(codigo);

		request.setAttribute("articulo",art);
		
		request.getRequestDispatcher("/views/carrito/agregar.jsp").forward(request, response);
		
	}
	private void getQuitar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);		
		
		Articulo art = this.articulosRepo.findById(codigo);

		request.setAttribute("articulo",art);
		
		request.getRequestDispatcher("/views/carrito/quitar.jsp").forward(request, response);
		
	}
	private void getConfirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ElementoCarrito> lista = this.carrito.getAll();
		
		request.setAttribute("listaCarrito", lista);	
		
		
		request.getRequestDispatcher("/views/carrito/index.jsp").forward(request, response);

	}
	
	
	//DO-POST	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario u = (Usuario) session.getAttribute("usuario");
		

		if( u ==null || !u.getRol().equals("Cliente")) {
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
		case "agregar" -> postAgregar(request,response); //cambiar la cantidad en el carrito
		case "quitar" -> postQuitar(request,response); //cambiar la cantidad en el carrito
		case "confirm" -> postConfirm(request,response); //confirmar la compra
		default -> response.sendError(404,"No existe la accion: "+ accion);
			
		}
		
	
		
		
	}
	
	private void postAgregar(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);
		
		String sCantidad = request.getParameter("cantidad");
		int cantidad = Integer.parseInt(sCantidad);
		
		Articulo art = articulosRepo.findById(codigo);
		try {
			this.carrito.agregar(art, cantidad);
		} catch (Exception e) {
			response.sendError(404,e.getMessage());
			return;
		}
		
		
		response.sendRedirect("carrito");
	
	}	
	private void postQuitar(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);
		
		String sCantidad = request.getParameter("cantidad");
		int cantidad = Integer.parseInt(sCantidad);
		
		Articulo art = articulosRepo.findById(codigo);
		try {
			this.carrito.quitar(art, cantidad);
		} catch (Exception e) {
			response.sendError(404,e.getMessage());
			return;
		}
		
		
		response.sendRedirect("carrito");
	
	}
	
	private void postConfirm(HttpServletRequest request, HttpServletResponse response)  throws IOException {
	
	}



}



















