package ProjetoRestaurante.model;

import jakarta.persistence.*;

@Entity
@Table
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column
    private boolean vegetarian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chef_id")
    private Chef chef;

    @Column(length = 50)
    private String category;

    public Dish() {
    }

    public Dish(Long id, String name, double price, boolean vegetarian, Chef chef, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.chef = chef;
        this.category = category;
    }

    public Dish(String name, double price, boolean vegetarian, Chef chef, String category) {
        this.name = name;
        this.price = price;
        this.vegetarian = vegetarian;
        this.chef = chef;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Chef getChef() {
        return chef;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", chef=" + chef +
                ", category='" + category + '\'' +
                "}\n\n -------------------- \n\n";
    }
}
