package divas_pop.exercises.criteriaBuilder;

//import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class Exercicio2 {
    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
            EntityManager em = emf.createEntityManager()) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery query = cb.createQuery(Tuple.class); // The type that gets returned from the query

            Root<Artista> artista = query.from(Artista.class); // The table/entity we are querying

            // Ordering by quantidade de albuns
            query.multiselect(artista.get("nome"),
                            artista.get("quantidadeAlbuns"))
                    .orderBy(cb.asc(artista.get("quantidadeAlbuns")));
            
            List<Tuple> results = em.createQuery(query).getResultList();
            results.forEach(tuple ->
                    System.out.println(tuple.get(0) + " - " + tuple.get(1)));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
