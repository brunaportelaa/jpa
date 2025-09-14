package LearningJPQL;

import Entities.Departamento;
import Entities.Funcionario;
import jakarta.persistence.*;

import java.util.List;

public class Exercise3 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Object[]> query = em.createQuery("SELECT d, f FROM Departamento d JOIN d.funcionarios f", Object[].class);
            transaction.begin();
            List<Object[]> result = query.getResultList();
            for (Object[] row : result) {
                Departamento dpto = (Departamento) row[0];
                Funcionario func = (Funcionario) row[1];
                System.out.println(dpto.getName() + " - " + func.getName());
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
