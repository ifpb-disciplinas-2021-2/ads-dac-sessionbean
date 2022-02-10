package br.edu.ifpb.web.jsf;

import br.edu.ifpb.chat.Chat;
import br.edu.ifpb.chat.SalaDeBatepapo;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2022, 08:40:27
 */
@Named
@RequestScoped
public class ControladorDeChat { //web
    
    @EJB
    private SalaDeBatepapo chat;
    private String mensagem;
    
    public String enviar(){
        this.chat.nova(mensagem);
        this.mensagem = "";
        return null; //própria página
    }
    public List<String> todasAsMensagens(){
        return this.chat.historico();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    

}
