package br.edu.ifpb.service;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/12/2021, 09:54:32
 */
@Stateless
public class NovoCliente {

    @EJB
    private Clientes clientes;
    
    public Cliente novo(Cliente cliente){
        // validações...
        Objects.requireNonNull(cliente,"O cliente não pode ser nulo");
        return clientes.novo(cliente);
    }
        
}
