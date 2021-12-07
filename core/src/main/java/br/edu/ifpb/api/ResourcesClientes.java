package br.edu.ifpb.api;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.service.ListaDeClientes;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path(("clientes"))
public class ResourcesClientes {
    @EJB
    private ListaDeClientes clientes;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> clientes(){
        return this.clientes.todoOsClientes();
    }
}
