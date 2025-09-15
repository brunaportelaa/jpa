package ProjetoRestaurante.model;

import jakarta.persistence.*;

@Entity
@Table
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column(length = 100)
    private String cuisine;

    @Column(length = 400)
    private String address;

    @OneToOne
    @JoinColumn(name = "chef_id", unique = true)
    private Chef chef;

    public Restaurant() {
    }

    public Restaurant(Long id, String name, String cuisine, String address, Chef chef) {
        this.id = id;
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.chef = chef;
    }

    public Restaurant(String name, String cuisine, String address, Chef chef) {
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.chef = chef;
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

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuisine='" + cuisine + '\'' +
                ", address='" + address + '\'' +
                ", chef=" + chef +
                "}\n\n -------------------- \n\n";
    }
}
