package ProjetoRestaurante.dao;

import ProjetoRestaurante.model.Dish;
import ProjetoRestaurante.model.Dish;
import ProjetoRestaurante.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class DishDAO implements GenericDAO<Dish>{

    private EntityManager em;

    public DishDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Dish dish) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (dish.getId() == null) {
                em.persist(dish);
            } else {
                em.merge(dish);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Erro ao salvar prato: " + e.getMessage(), e);
        }

    }

    @Override
    public List<Dish> listarTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);

        Root<Dish> dish = query.from(Dish.class);

        query.select(dish);

        return em.createQuery(query).getResultList();
    }

    @Override
    public Dish listarPorId(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);

        Root<Dish> dish = query.from(Dish.class);

        query.select(dish)
                .where(cb.equal(dish.get("id"), id));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public Dish listarPorNomeExato(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);

        Root<Dish> dish = query.from(Dish.class);

        query.select(dish)
                .where(cb.equal(dish.get("name"), nome));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public Dish pesquisarPorNome(String termoPesquisa) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Dish> query = cb.createQuery(Dish.class);

        Root<Dish> dish = query.from(Dish.class);

        query.select(dish)
                .where(cb.like(dish.get("name"), cb.literal("%" + termoPesquisa + "%")));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public void deletar(Dish dish) {
        EntityTransaction transaction = em.getTransaction();
        try {
            if (dish.getId() != null) {
                transaction.begin();
                em.remove(dish);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Erro ao deletar prato: " + e.getMessage(), e);
        }
    }
}
