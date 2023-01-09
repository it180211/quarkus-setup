package at.htl.repository;

import at.htl.model.Course;
import at.htl.model.CoursePlan;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CourseRepository implements PanacheRepositoryBase<Course, String> {

    public List<Course> search(String text) {
        Query query = this.getEntityManager().createQuery("select c from Course c where lower(c.id) like lower(:text) or lower(c.title) like lower(:text) ", Course.class)
                .setParameter("text", "%"+text+"%");

        return query.getResultList();
    }
}
