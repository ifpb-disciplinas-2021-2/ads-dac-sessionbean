package br.edu.ifpb.service;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

//Regra de Negócio
@Stateless
public class ListaDeClientes {
    @EJB
    private Clientes repositorio;

    public List<Cliente> todoOsClientes(){
        return repositorio.todos();
    }

    public Cliente clienteComId(int id) {
        return new Cliente(2, "123", "Chaves");
    }
}
