package br.edu.ifpb.chat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2022, 08:36:36
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
//@Lock(LockType.WRITE)
public class ChatOnline implements Chat{
    private List<String> mensagens = new ArrayList<>();

    @Lock(LockType.WRITE)
    @Override
    public void nova(String mensgem) {
        this.mensagens.add(mensgem);
    }

    @Lock(LockType.READ)
    @Override
    public List<String> historico() {
        return Collections.unmodifiableList(mensagens);
    }

}
