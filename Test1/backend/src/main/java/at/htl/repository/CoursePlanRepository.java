package at.htl.repository;

import at.htl.model.CoursePlan;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.List;

@ApplicationScoped
public class CoursePlanRepository implements PanacheRepository<CoursePlan> {

    public List<CoursePlan> findByCourseId(String id) {

        Query query = this.getEntityManager().createQuery("select cp from CoursePlan cp where cp.course.id = :id", CoursePlan.class)
                .setParameter("id", id);

        return query.getResultList();

    }
}
