package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car", orphanRemoval = true)
    private User user;

    public Car() { }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() { return id; }

    public void setModel(String model) { this.model = model; }

    public void setSeries(int series) { this.series = series; }

    public String getModel() { return model; }

    public int getSeries() { return series; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}
