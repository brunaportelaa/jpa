package ProjetoRestaurante.dao;

import ProjetoRestaurante.model.Chef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public interface GenericDAO<T> {

    public void salvar(T T);

    public List<T> listarTodos();

    public T listarPorId(long id);

    public T listarPorNomeExato(String nome);

    public T pesquisarPorNome(String termoPesquisa);

    public void deletar(T T);

}
