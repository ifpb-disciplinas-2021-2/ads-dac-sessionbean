package br.edu.ifpb.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2022, 09:05:03
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SalaDeBatepapo implements Chat{

    private List<String> mensagens = new ArrayList<String>();
    private Object lock = new Object();
    
    @Override
    public void nova(String mensgem) {
        // temos um processamento longo aqui
        synchronized(lock){ //instância que será bloqueada
            this.mensagens.add(mensgem);
        }
        // temos um processamento longo aqui
    }
//    @Override
//    public void nova(String mensgem) {
//        // temos um processamento longo aqui
//        synchronized(mensagens){ //instância que será bloqueada
//            this.mensagens.add(mensgem);
//        }
//        // temos um processamento longo aqui
//    }
    
//    @Override
//    public void nova(String mensgem) {
//        // temos um processamento longo aqui
//        synchronized(this){ //instância que será bloqueada
//            this.mensagens.add(mensgem);
//        }
//        // temos um processamento longo aqui
//    }
    
//    @Override
//    public synchronized void nova(String mensgem) {
//        // temos um processamento longo aqui
//        this.mensagens.add(mensgem);
//        // temos um processamento longo aqui
//    }

    @Override
    public List<String> historico() {
        return Collections.unmodifiableList(mensagens);
    }

}
