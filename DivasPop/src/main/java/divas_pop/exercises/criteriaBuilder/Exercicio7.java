package divas_pop.exercises.criteriaBuilder;

//import divas_pop.model.Album;
import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;

import java.util.List;

/**
 * Building and delivering entities as results from queries
 */

public class Exercicio7 {
    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
            EntityManager em = emf.createEntityManager()) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class); // The type that gets returned from the query

            Root<Artista> artista = query.from(Artista.class); // The table/entity we are querying
            Join<Artista, Album> album = artista.join("albuns");

            query.multiselect(artista.get("nome"), album.get("nome"));

            List<Tuple> results = em.createQuery(query).getResultList();

            results.forEach(tuple ->
                    System.out.println(tuple.get(0) + " - " + tuple.get(1)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
