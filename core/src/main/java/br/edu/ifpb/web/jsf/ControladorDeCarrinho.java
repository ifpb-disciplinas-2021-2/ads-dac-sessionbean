package br.edu.ifpb.web.jsf;

import br.edu.ifpb.compra.Carrinho;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/12/2021, 08:33:23
 */
@Named
@SessionScoped
public class ControladorDeCarrinho implements Serializable{
    
    private String produto;
    @Inject
    //90c06800a81f-ffffffffb8d31ead-1
    private Carrinho carrinho;// = new Carrinho();
    
    private String nome;
    
    public String adicionar(){
        this.carrinho.adicionar(
            this.produto
        );
        this.nome = "Job";
        this.produto = "";
        return null;
    }
    public String concluir(){
        this.carrinho.finalizar();
        logout();
//        atualizarCarrinho();
        return null;
    }
    
    private void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
            .getExternalContext()
            .getSession(true);
        session.invalidate();
    }
    private void atualizarCarrinho() {
        this.carrinho = CDI.current()
            .select(Carrinho.class)
            .get(); // recuperando uma nova instancia para o carrinho
    }
    public List<String> todosOsProdutos(){
        return this.carrinho.produtos();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    

}
