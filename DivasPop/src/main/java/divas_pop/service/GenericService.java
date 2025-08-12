package divas_pop.service;

import java.util.List;

public interface GenericService<T> {
    void salvar(T entidade);
    T buscarPorId(Integer id);
    List<T> listarTodos();
    void deletar(Integer id);
}
