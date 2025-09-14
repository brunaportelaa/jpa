package divas_pop.exercises.criteriaBuilder;

//import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.*;

import java.util.List;

public class Exercicio4 {
    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
            EntityManager em = emf.createEntityManager()) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> query = cb.createQuery(Object[].class); // The type that gets returned from the query

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

            List<Object[]> results = em.createQuery(query).getResultList();

            for (Object[] row : results) {
                String nome = (String) row[0];
                Integer albuns = (Integer) row[1];
                System.out.println(nome + " - " + albuns);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
