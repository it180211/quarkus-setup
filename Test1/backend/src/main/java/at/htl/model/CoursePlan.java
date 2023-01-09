package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class CoursePlan extends PanacheEntity {

    @Column(name = "startdate", nullable = false)
    public LocalDate start;

    @Column(name = "enddate")
    public LocalDate end;
    public String location;

    @ManyToOne
    @JoinColumn(name = "teacher")
    public Person person;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonIgnore
    public Course course;

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Person> personList = new LinkedList<>();


    // TODO Beziehungen definieren lt. Angabe
}
