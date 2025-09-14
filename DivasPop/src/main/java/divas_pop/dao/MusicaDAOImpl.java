package divas_pop.dao;

import divas_pop.model.Artista;
import divas_pop.model.Musica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MusicaDAOImpl implements GenericDAO<Musica> {


    private EntityManager em;

    public MusicaDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Musica musica) {
        em.getTransaction().begin();
        if (musica.getId() == null) {
            em.persist(musica);
        } else {
            em.merge(musica);
        }
    }

    @Override
    public Musica buscarPorId(Integer id) {
        return em.find(Musica.class, id);
    }

    @Override
    public List listarTodos() {
        TypedQuery<Musica> query = em.createQuery("SELECT m FROM Musica m", Musica.class);
        return query.getResultList();
    }

    @Override
    public void deletar(Integer id) {
        em.getTransaction().begin();
        Musica musica = em.find(Musica.class, id);
        if (musica != null ) {
            em.remove(musica);
        }
        em.getTransaction().commit();

    }
}
