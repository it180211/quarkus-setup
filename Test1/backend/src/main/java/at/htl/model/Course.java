package at.htl.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;

@Entity
public class Course extends PanacheEntityBase {

    @Id
    public String id;

    @Column(nullable = false)
    public String title;

    @Column(length = 2000)
    public String description;

    @ManyToOne
    @JoinColumn(name = "prerequisite")
    public Course prerequisite;

    // TODO Voraussetzungs-Kurs definieren
}
