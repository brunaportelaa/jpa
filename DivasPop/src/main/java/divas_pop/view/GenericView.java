package divas_pop.view;

import java.util.List;

public interface GenericView<T> {
    int menu();
    T ler();
    void exibir(T entidade);
    void exibirLista(List<T> lista);
    void exibirMensagem(String msg);
    void exibirErro(String err);
}
