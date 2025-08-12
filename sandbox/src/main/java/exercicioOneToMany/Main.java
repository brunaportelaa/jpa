package exercicioOneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sandbox");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            Departamento deptFinanceiro = new Departamento("Financeiro");
            Departamento deptTecnologia = new Departamento("Tecnologia");
            Departamento deptComercial = new Departamento("Comercial");
            Departamento deptOperacional = new Departamento("Operacional");

            List<Funcionario> funcionarios = Arrays.asList(
                    new Funcionario("Bruna", "Analista de Qualidade", deptTecnologia),
                    new Funcionario("Carlos", "Contador", deptFinanceiro),
                    new Funcionario("Mariana", "Desenvolvedora Java", deptTecnologia),
                    new Funcionario("Pedro", "Vendedor", deptComercial),
                    new Funcionario("Ana", "Gerente Financeiro", deptFinanceiro),
                    new Funcionario("Lucas", "Operador de Máquinas", deptOperacional),
                    new Funcionario("Fernanda", "Analista de Sistemas", deptTecnologia),
                    new Funcionario("Roberto", "Supervisor de Vendas", deptComercial),
                    new Funcionario("Juliana", "Assistente Administrativo", deptOperacional),
                    new Funcionario("Ricardo", "Analista Fiscal", deptFinanceiro)
            );

            for (Funcionario funcionario : funcionarios) {
                em.persist(funcionario);
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
