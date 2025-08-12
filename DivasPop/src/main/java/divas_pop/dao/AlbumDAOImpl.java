package divas_pop.dao;

import divas_pop.model.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AlbumDAOImpl implements GenericDAO<Album> {

    private final EntityManager em;

    public AlbumDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Album album) {
        em.getTransaction().begin();
        if (album.getId() == null) {
            em.persist(album);
        } else {
            em.merge(album);
        }
        em.getTransaction().commit();
    }

    @Override
    public Album buscarPorId(Integer id) {
        return em.find(Album.class, id);
    }

    @Override
    public List<Album> listarTodos() {
        TypedQuery<Album> query = em.createQuery("SELECT a FROM Album a", Album.class);
        return query.getResultList();
    }

    @Override
    public void deletar(Integer id) {
        em.getTransaction().begin();
        Album album = em.find(Album.class, id);
        if (album.getId() != null) {
            em.remove(album);
        }
        em.getTransaction().commit();
    }
}
