package LearningJPQL;

import Entities.Funcionario;
import jakarta.persistence.*;

import java.util.List;

public class Exercise5 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {

            TypedQuery<Funcionario> query = em.createQuery("SELECT new Funcionario(f.name, f.cargo, d) FROM Departamento d JOIN d.funcionarios f", Funcionario.class);
            transaction.begin();
            List<Funcionario> result = query.getResultList();
            for (Funcionario func : result) {
                System.out.println(func.getName() + " - " + func.getCargo() + " - " + func.getDepartamento().getName());
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
