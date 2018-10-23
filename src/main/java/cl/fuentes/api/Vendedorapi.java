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


@Path("vendedor")
public class Vendedorapi {

	@EJB
	private VendedorInterfaceLocal venlocal;
	
	@Produces("application/json")
	@GET
	@Path("/obtenervendedor/{param}")
	public Vendedor obtenervendedor(@PathParam("param") int idvendedor) {
		Vendedor ven = new  Vendedor();
		ven = venlocal.buscarPorID(idvendedor);
		return ven;
	}
	
	
	
}
