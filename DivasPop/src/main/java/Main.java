import divas_pop.controller.ArtistaController;
import divas_pop.dao.ArtistaDAOImpl;
import divas_pop.model.Album;
import divas_pop.model.Artista;
import divas_pop.model.Musica;
import divas_pop.service.AlbumService;
import divas_pop.service.ArtistaService;
import divas_pop.view.ArtistaView;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.divas_pop");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        ArtistaService artistaService = new ArtistaService(em);
        ArtistaView artistaView = new ArtistaView();

        AlbumService albumService = new AlbumService();


        try {

//            ArtistaController controller = new ArtistaController(artistaService, artistaView);
//            controller.iniciar();

            Artista artista = artistaService.buscarPorId(6);
            Album album = new Album(artista, "Mahem", 8, 2025, 14);
            System.out.println(albumService.salvar(album));


        } catch (Exception e){
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
