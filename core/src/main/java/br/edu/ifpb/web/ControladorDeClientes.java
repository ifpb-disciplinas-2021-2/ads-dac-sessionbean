package br.edu.ifpb.web;

import br.edu.ifpb.domain.Cliente;
import br.edu.ifpb.domain.Clientes;
import br.edu.ifpb.service.ListaDeClientes;
import br.edu.ifpb.service.NovoCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Job
 */
@WebServlet(name = "ControladorDeClientes",urlPatterns = {"/clientes"})
public class ControladorDeClientes extends HttpServlet {

//    private Clientes service = new ClientesEmMemoria();
//    @EJB
//    @Inject
//    private Clientes service;// = new ClientesEmJDBC();
    @Inject
    private ListaDeClientes clientes;
    @Inject
    private NovoCliente novoCliente;

    // Listar todos os clientes
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDeClientes</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Listagem com Stateless</h1>");
            listarClientes(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

// Criar um novo Cliente
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        Cliente cliente = new Cliente(cpf,nome);
        this.novoCliente.novo(cliente);
        response.sendRedirect("clientes");
    }

    private void listarClientes(final PrintWriter out) {
        this.clientes
            .todoOsClientes()
            .forEach(c-> 
                out.println("<p>" + c.getNome() + "</p>")
            );
    }

}
