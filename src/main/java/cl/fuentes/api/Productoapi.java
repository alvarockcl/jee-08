package cl.fuentes.api;

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

@Path("producto")
public class Productoapi {

	@EJB
	private ProductoInterfaceLocal proloc;
	
	@Produces("application/json")
	@GET
	@Path("/insertar/{param1}/{param2}")
	public Estado insertproducto(@PathParam("param1") String nombre,@PathParam("param2") int stock) {
		Producto pro = new Producto(nombre, stock);
		proloc.create(pro);
		return new Estado(200,"Exitoso");
	}
	
	
	
}
