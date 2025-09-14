package divas_pop.exercises.criteriaBuilder;

//import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Exercicio1 {
    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
            EntityManager em = emf.createEntityManager()) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery(String.class); // The type that gets returned from the query

            Root<Artista> artista = query.from(Artista.class); // The table/entity we are querying

            // Selecting everyone with 'na' in their names
            query.select(artista.get("nome"))
                    .where(cb.like(artista.get("nome"), "%na%"));

            List<String> results = em.createQuery(query).getResultList();
            results.forEach(System.out::println);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
