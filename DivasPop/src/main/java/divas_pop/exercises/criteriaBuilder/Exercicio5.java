package divas_pop.exercises.criteriaBuilder;

//import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.*;

import java.util.List;

/**
 * Returning tuples
 */
public class Exercicio5 {
    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
            EntityManager em = emf.createEntityManager()) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class); // The type that gets returned from the query

            Root<Artista> artista = query.from(Artista.class); // The table/entity we are querying

            //Predicates de igualdade
            Predicate equalToTate = cb.equal(artista.get("nome"), "Tate McRae");
            Predicate notEqualToTate = cb.notEqual(artista.get("nome"), "Tate McRae");

            //Predicates de comparação numérica
            Predicate greaterThan5 = cb.greaterThan(artista.get("quantidadeAlbuns"), 5);
            Predicate lessThan5 = cb.lessThan(artista.get("quantidadeAlbuns"), 5);
            Predicate between5and10 = cb.between(artista.get("quantidadeAlbuns"), 5, 10);

            // Predicates de Like/Not like (strings)
            Predicate likeNa = cb.like(artista.get("nome"), "%na%");
            Predicate notLikeNa = cb.notLike(artista.get("nome"), "%na%");

            Order orderByQtdAlbuns = cb.asc(artista.get("quantidadeAlbuns"));


            query.multiselect(artista.get("nome"), artista.get("quantidadeAlbuns"))
                    .where(cb.and(likeNa, between5and10)) // Choose your predicate
                    .orderBy(orderByQtdAlbuns);

            List<Tuple> results = em.createQuery(query).getResultList();

            for (Tuple tuple : results) {
                System.out.println(tuple.get(0) + " - " + tuple.get(1));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
