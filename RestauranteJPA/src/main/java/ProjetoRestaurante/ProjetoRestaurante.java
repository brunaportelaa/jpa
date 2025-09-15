package ProjetoRestaurante;

import ProjetoRestaurante.dao.ChefDAO;
import ProjetoRestaurante.dao.DishDAO;
import ProjetoRestaurante.model.Chef;
import ProjetoRestaurante.model.Dish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProjetoRestaurante {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        ChefDAO chefDAO = new ChefDAO(em);
        DishDAO dishDAO = new DishDAO(em);

        try {

            System.out.println(chefDAO.listarPorId(3));

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }


    }
}
