package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id")
//    private User user;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

//    public Car(String model, int series, User user) {
//        this.model = model;
//        this.series = series;
//        this.user = user;
//    }


    @Override
    public String toString() {
        return "model='" + model + '\'' +
                ", series=" + series;
    }
}
