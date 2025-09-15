package ProjetoRestaurante.dao;

import ProjetoRestaurante.model.Restaurant;
import ProjetoRestaurante.model.Restaurant;
import ProjetoRestaurante.model.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class RestaurantDAO implements GenericDAO<Restaurant> {

    private EntityManager em;

    public RestaurantDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Restaurant restaurant) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            if (restaurant.getId() == null) {
                em.persist(restaurant);
            } else {
                em.merge(restaurant);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Erro ao salvar prato: " + e.getMessage(), e);
        }

    }

    @Override
    public List<Restaurant> listarTodos() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);

        Root<Restaurant> restaurant = query.from(Restaurant.class);

        query.select(restaurant);

        return em.createQuery(query).getResultList();
    }

    @Override
    public Restaurant listarPorId(long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);

        Root<Restaurant> restaurant = query.from(Restaurant.class);

        query.select(restaurant)
                .where(cb.equal(restaurant.get("id"), id));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public Restaurant listarPorNomeExato(String nome) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);

        Root<Restaurant> restaurant = query.from(Restaurant.class);

        query.select(restaurant)
                .where(cb.equal(restaurant.get("name"), nome));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public Restaurant pesquisarPorNome(String termoPesquisa) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Restaurant> query = cb.createQuery(Restaurant.class);

        Root<Restaurant> restaurant = query.from(Restaurant.class);

        query.select(restaurant)
                .where(cb.like(restaurant.get("name"), cb.literal("%" + termoPesquisa + "%")));

        return em.createQuery(query).getSingleResult();
    }

    @Override
    public void deletar(Restaurant restaurant) {
        EntityTransaction transaction = em.getTransaction();
        try {
            if (restaurant.getId() != null) {
                transaction.begin();
                em.remove(restaurant);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            throw new RuntimeException("Erro ao deletar prato: " + e.getMessage(), e);
        }
    }
}
