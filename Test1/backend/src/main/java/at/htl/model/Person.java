package at.htl.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class Person extends PanacheEntity {


    public String firstname;

    public String lastname;

    @ManyToMany(mappedBy = "personList", fetch = FetchType.EAGER)
    @JsonIgnore
    public List<CoursePlan> coursePlanList = new LinkedList<>();


    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Person() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstname, person.firstname) && Objects.equals(lastname, person.lastname) && Objects.equals(coursePlanList, person.coursePlanList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, coursePlanList);
    }
}
