package br.edu.ifpb.chat;

import java.util.List;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 01/02/2022, 08:34:17
 */
public interface Chat {
    public void nova(String mensgem);
    public List<String> historico();

}
