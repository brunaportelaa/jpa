package LearningJPQL;

import Entities.Departamento;
import jakarta.persistence.*;

import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE d.name = :name", Departamento.class);
            query.setParameter("name", "Tecnologia");
            transaction.begin();
            Departamento departamento = query.getSingleResult();
            System.out.println(departamento.getName());
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
