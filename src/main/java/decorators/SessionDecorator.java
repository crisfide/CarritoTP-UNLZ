package decorators;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import exeptions.ArticuloDeslogueadoException;
import modelos.Articulo;
import repositories.interfaces.ArticuloRepo;
import utils.ProyectoBuilder;

public class SessionDecorator {

	
	public static final String ARTICULO = "articulo";
	public static final String PROYECTO = "proyecto";
	
	
	private HttpSession session;

	public SessionDecorator(HttpSession session) {
		super();
		this.session = session;
	}

	public HttpSession getSession() {
		return session;
	}
	
	
	public ProyectoBuilder getProyecto() throws ArticuloDeslogueadoException {
		
		Articulo artLog = this.getArticuloLogueado();
		
		ProyectoBuilder proyecto = (ProyectoBuilder) session.getAttribute(PROYECTO);
		
		try {
			proyecto = Optional.ofNullable(proyecto).orElseThrow();

		}catch (NoSuchElementException e) {
			ProyectoBuilder pro = new ProyectoBuilder(artLog);
			session.setAttribute("articulo", pro);
		}
		
										
	return proyecto;
		
		
	}
	
	
	
	public Articulo getArticuloLogueadoActu(ArticuloRepo repo) throws ArticuloDeslogueadoException {
		Articulo articuloLog = this.getArticuloLogueado();
		
		articuloLog = repo.findById(articuloLog.getCodigo());
		
		session.setAttribute(ARTICULO, articuloLog);
		
		return articuloLog;
		
		
		
		
		
	}

	public  Articulo getArticuloLogueado() throws ArticuloDeslogueadoException {
		
		Articulo articuloLogNullable = (Articulo) session.getAttribute(ARTICULO);
		
		Articulo articuloLog = Optional.ofNullable(articuloLogNullable)
				.orElseThrow( ()->new ArticuloDeslogueadoException());
		
		
		return articuloLog; 
		
	}
	
	
	public void setArticuloLogueado(Articulo articulo) {
		session.setAttribute(ARTICULO, articulo);
		
	}
	
	
	
}
