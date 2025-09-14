package LearningJPQL;

import Entities.Funcionario;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

/**
 *  LEARNING CRITERIA BUILDER
 */

public class Exercise7 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Funcionario> query = cb.createQuery(Funcionario.class);

            Root<Funcionario> funcionario = query.from(Funcionario.class); // FROM funcionario f
            query.select(funcionario)
                    .where(cb.like(funcionario.get("name"), "%Ri%"));

            transaction.begin();
            List<Funcionario> results = em.createQuery(query).getResultList();
            results.forEach(System.out::println);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
