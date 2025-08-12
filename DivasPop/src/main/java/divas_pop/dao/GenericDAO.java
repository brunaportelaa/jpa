package divas_pop.dao;

import java.util.List;

public interface GenericDAO<T> {
    void salvar(T entidade);
    T buscarPorId(Integer id);
    List<T> listarTodos();
    void deletar(Integer id);
//    void atualizarPorId(Integer id);
}
