package LearningJPQL;

import Entities.Departamento;
import Entities.Funcionario;
import jakarta.persistence.*;

import java.util.List;

public class Exercise4 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Object[]> query = em.createQuery("SELECT d.name, f.name, f.cargo FROM Departamento d JOIN d.funcionarios f", Object[].class);
            transaction.begin();
            List<Object[]> result = query.getResultList();
            for (Object[] row : result) {
                String dptoName = (String) row[0];
                String funcName = (String) row[1];
                String funcCargo = (String) row[2];
                System.out.println(dptoName + " - " + funcName + " - " + funcCargo);
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
