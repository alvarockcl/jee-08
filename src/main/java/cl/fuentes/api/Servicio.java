package cl.fuentes.api;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import cl.fuentes.model.*;
import cl.fuentes.ejb.*;

@ApplicationPath("/rest")
@Path("servicio")
public class Servicio extends Application{

	@EJB
	private ProductoInterfaceLocal prolocal;
	
	// Poblar la base
	//http://localhost:8080/jee-08/Poblar
	
	//http://localhost:8080/jee-08/rest/servicio/saludo/alvaro
	@Produces("application/json")
	@GET
	@Path("/saludo/{param}")
	public Response saludo(@PathParam("param") String msg) {
 
		String output = "Prueba API : " + msg;
		return Response.status(200).entity(output).build();
 
	}
	
	//http://localhost:8080/jee-08/rest/servicio/obtenerproducto/1
	@Produces("application/json")
	@GET
	@Path("/obtenerproducto/{param}")
    public Producto obtenerProducto(@PathParam("param") int idproducto) {

		Producto pro = new Producto();
		pro = prolocal.buscarPorID(idproducto);
		return pro;
		
	}

	//http://localhost:8080/jee-08/rest/servicio/todosproductos/
	@Produces("application/json")
	@GET
	@Path("/todosproductos/")
    public List<Producto> todosproductos() {

		List<Producto> listaprod = new ArrayList<>();
		listaprod = prolocal.buscarTodos();
		return listaprod;
		
	}
	
	
}

