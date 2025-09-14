package divas_pop.dao;
import divas_pop.model.Album;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ArtistaDAOImpl implements GenericDAO<Artista> {

    private EntityManager em;

    public ArtistaDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void salvar(Artista artista) {
        em.getTransaction().begin();
        if (artista.getId() == null) {
            em.persist(artista);
        } else {
            em.merge(artista);
        }
        em.getTransaction().commit();
    }

    @Override
    public Artista buscarPorId(Integer id) {
        return em.find(Artista.class, id);
    }

    @Override
    public List<Artista> listarTodos() {
        TypedQuery<Artista> query = em.createQuery("SELECT a FROM Artista a", Artista.class);
        return query.getResultList();
    }

    public List<Album> listarAlbuns(int artistaId) {
        TypedQuery<Album> query = em.createQuery(
                "SELECT a FROM Album a WHERE a.artista.id = :artistaId",
                Album.class
        );
        query.setParameter("artistaId", artistaId);
        return query.getResultList();
    }


    @Override
    public void deletar(Integer id) {
        em.getTransaction().begin();
        Artista artista = em.find(Artista.class, id);
        if (artista != null) {
            em.remove(artista);
        }
        em.getTransaction().commit();
    }


}
