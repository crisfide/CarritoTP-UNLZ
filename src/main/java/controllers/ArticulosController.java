package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import com.oracle.wls.shaded.org.apache.regexp.RE;

import factory.RepoFactory;
import modelos.Articulo;
import repositories.ArticuloRepoSingleton;
import repositories.interfaces.ArticuloRepo;

@WebServlet("/articulo")
public class ArticulosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArticuloRepo articulosRepo;
       
    public ArticulosController() {       
    	   
       RepoFactory factory = new RepoFactory();
       this.articulosRepo = factory.getArticuloRepo();
    }
    
    //DO-GET

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
		
		//response.sendRedirect("views/bienvenido.jsp");
		
		
		request.getRequestDispatcher("/views/bienvenido.jsp").forward(request, response);
	}

	private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/articulo/create.jsp").forward(request, response);
	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);
		
		
		Articulo art = this.articulosRepo.findById(codigo);
		
		request.setAttribute("articulo",art);
		
		request.getRequestDispatcher("/views/articulo/edit.jsp").forward(request, response);
		
		
	}

	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String sCodigo = request.getParameter("codigo");
		int codigo = Integer.parseInt(sCodigo);
		
		Articulo art = articulosRepo.findById(codigo);
		
		request.setAttribute("articulo",art);
			
		
		request.getRequestDispatcher("/views/articulo/show.jsp").forward(request, response);

	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<Articulo> listArt = this.articulosRepo.getAll();
		
		request.setAttribute("listin", listArt);
		
		
		
		request.getRequestDispatcher("/views/articulo/index.jsp").forward(request, response);

	}
	
	
	//DO-POST
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String accion = request.getParameter("accion");
		//accion = Optional.ofNullable(accion).orElse("insert");
		
		if(accion == null) {
			response.sendError(400,"No se brindo una accion");
			return;
		}
		
		switch (accion) {
		case "insert" -> postInsert(request,response);
		case "update" -> postUpdate(request,response);
		case "delete" -> postDelete(request,response);
		default -> response.sendError(404,"No existe la accion: "+ accion);
			
		}
		
	
		
		
	}
	
	private void postDelete(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		String sCodigo = request.getParameter("codigo");
		int codigo= Integer.parseInt(sCodigo);
		
		articulosRepo.delete(codigo);
		
		response.sendRedirect("articulo");
		
		
	}
		
	private void postUpdate(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		String sCodigo = request.getParameter("codigo");
		int codigo= Integer.parseInt(sCodigo);
		
		
		String descripcion = request.getParameter("descripcion");
		
		String sPrecio = request.getParameter("precio");
		double precio = Double.parseDouble(sPrecio);
		
		String sStock = request.getParameter("stock");
		int stock = Integer.parseInt(sStock);
		
		Articulo art = articulosRepo.findById(codigo);
		
		art.setDescripcion(descripcion);
		art.setPrecio(precio);
		art.setStock(stock);
		
		articulosRepo.update(art);
		
		response.sendRedirect("articulo");
		
		
		
		
	}
		
	private void postInsert(HttpServletRequest request, HttpServletResponse response)  throws IOException {
		
		
		String descripcion = request.getParameter("descripcion");
		
		String sPrecio = request.getParameter("precio");
		double precio = Double.parseDouble(sPrecio);
		
		String sStock = request.getParameter("stock");
		int stock = Integer.parseInt(sStock);
		
		Articulo articulo = new Articulo(descripcion, precio, stock);
		
		
		this.articulosRepo.insert(articulo);
		
		
		response.sendRedirect("articulo");
		
		
		
	}



}



















