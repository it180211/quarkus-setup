package at.htl.repository;

import at.htl.model.Person;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

    public Person findByName(String firstname, String lastname) {
        Query query = this.getEntityManager().createQuery("select p from Person p where p.firstname = :firstname and p.lastname = :lastname", Person.class)
                .setParameter("firstname", firstname)
                .setParameter("lastname", lastname);

        if (query.getResultStream().count() == 1){
            return (Person) query.getSingleResult();
        }else{
            return null;
        }
    }
    
    /*
     public void update(Person person) {
        getEntityManager().merge(person);
    }
    */
    
}
