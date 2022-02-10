package br.edu.ifpb.compra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 14/12/2021, 08:24:32
 */
@Stateful
public class Carrinho {

    private final List<String> produtos = new ArrayList<>();
    
    public void adicionar(String produto){
        this.produtos.add(produto);
        System.out.println("Adicionando em: "+ toString());
    }
    public List<String> produtos(){
        return Collections.unmodifiableList(
            produtos
        );
    }  
    @Remove
    public void finalizar(){
        System.out.println("----- Lista de Produtos ---");
        this.produtos.forEach(System.out::println);
    }
}
