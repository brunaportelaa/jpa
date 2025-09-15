package ProjetoRestaurante.dao;

import ProjetoRestaurante.model.Chef;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ChefDAO implements GenericDAO<Chef>{

    EntityManager em;

    public ChefDAO(EntityManager em) {
        this. em = em;
    }

    public void salvar(Chef chef) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (chef.getId() == null) {
                em.persist(chef);
            } else {
                em.merge(chef);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao salvar chef: " + e.getMessage(), e);
        }
    }

    public List<Chef> listarTodos(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Chef> query = cb.createQuery(Chef.class);

        Root<Chef> chef = query.from(Chef.class);

        query.select(chef);

        return em.createQuery(query).getResultList();
    }

    public void deletar(Chef chef) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (em.find(Chef.class, chef.getId()) != null) {
                em.remove(chef);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Erro ao deletar chef: " + e.getMessage(), e);
        }
    }
}
