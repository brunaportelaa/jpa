package exercicio1;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            transaction.begin();
            Pessoa pessoaExistente = em.find(Pessoa.class, 1);
            Documento documento = new Documento("Passaporte", pessoaExistente);
            em.persist(documento);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
            em.close();
        }
    }
}
