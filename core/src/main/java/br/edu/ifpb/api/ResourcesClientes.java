package br.edu.ifpb.api;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.service.ListaDeClientes;
import br.edu.ifpb.service.NovoCliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

//http://localhost:8080/core/api/clientes
@Stateless
@Path("clientes") // /clientes
public class ResourcesClientes {
    @EJB
    private ListaDeClientes lista;
    @EJB
    private NovoCliente servico;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Cliente> todosOsClientes(){
        return lista.todoOsClientes();
    }
//    MessageBodyWriter not found for media type=application/xml,
//    type=class java.util.ArrayList,
//    genericType=java.util.List<br.edu.ifpb.domain.Cliente>.]]


    @GET
    @Path("{id}") // /clientes/{id}
    public Cliente clientePorId(@PathParam("id") int codigo){
        return lista.clienteComId(codigo);
    }

    @POST
    public Response criarCliente(Cliente cliente, @Context UriInfo uriInfo){
        Cliente novo = servico.novo(cliente);
        String id = String.valueOf(novo.getId());
//        String path = "http://localhost:8080/core/api/clientes/"+id;
        URI location = uriInfo.getAbsolutePathBuilder()
                .path(id)
                .build();
        return Response
                .created(location)
                .build();
    }

}
