package br.edu.ifpb.infra;

import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.domain.Cliente;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientesEmMemoria implements Clientes {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente novo(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.setId(clientes.size());
        return cliente;
    }

    @Override
    public List<Cliente> todos() {
        return Collections
            .unmodifiableList(
                this.clientes
            );
    }
}
