package LearningJPQL;

import Entities.Departamento;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
            transaction.begin();
            List<Departamento> departamentos = query.getResultList();
            for (Departamento departamento : departamentos) {
                System.out.println(departamento.getName());
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
