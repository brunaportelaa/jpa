package LearningJPQL;

import Entities.Departamento;
import Entities.Funcionario;
import jakarta.persistence.*;

import java.util.List;

/**
 *  LEARNING TUPLES
 */

public class Exercise6 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Tuple> query = em.createQuery("SELECT f.name AS name, f.cargo AS cargo, d.name AS departamento FROM Funcionario f JOIN f.departamento d", Tuple.class);
            transaction.begin();
            List<Tuple> result = query.getResultList();
            for (Tuple tuple : result) {
                String nome = tuple.get("name", String.class);
                String cargo = tuple.get("cargo", String.class);
                String dpto = tuple.get("departamento", String.class);

                System.out.println(nome + " - " + cargo + " - " + dpto);
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
