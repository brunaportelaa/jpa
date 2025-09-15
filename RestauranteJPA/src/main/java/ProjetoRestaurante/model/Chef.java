package ProjetoRestaurante.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "chef")
public class Chef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 200)
    private String name;

    @Column(name = "michelin_stars")
    private int michelinStars;

    @Column(length = 100)
    private String speciality;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Dish> dishes = new ArrayList<>();

    public Chef() {
    }

    public Chef(Long id, String name, int michelinStars, String speciality) {
        this.id = id;
        this.name = name;
        this.michelinStars = michelinStars;
        this.speciality = speciality;
    }

    public Chef(String name, int michelinStars, String speciality) {
        this.name = name;
        this.michelinStars = michelinStars;
        this.speciality = speciality;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMichelinStars() {
        return michelinStars;
    }

    public void setMichelinStars(int michelinStars) {
        this.michelinStars = michelinStars;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
        dish.setChef(this);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
        if (dish.getChef() == this) {
            dish.setChef(null);
        }
    }

}
