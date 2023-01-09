package at.htl.boundary;


import at.htl.model.Course;
import at.htl.model.CoursePlan;
import at.htl.model.Person;
import at.htl.model.dto.RegistrationDTO;
import at.htl.repository.CoursePlanRepository;
import at.htl.repository.CourseRepository;
import at.htl.repository.PersonRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/course")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    @Inject
    CourseRepository courseRepository;
    @Inject
    CoursePlanRepository coursePlanRepository;

    @Inject
    PersonRepository personRepository;

    @GET
    @Path("/search/{text}")
    public List<Course> searchCourse(@PathParam("text") String text){
        return this.courseRepository.search(text);
    }

    @GET
    @Path("{id}")
    public Course getCoursePlanById(@PathParam("id") String id){
        return this.courseRepository.findById(id);
    }

    @GET
    @Path("/plan/{id}")
    public List<CoursePlan> getCoursesById(@PathParam("id") String id){
        return this.coursePlanRepository.findByCourseId(id);
    }

    @POST
    @Transactional
    @Path("/plan")
    public Response register(RegistrationDTO registrationDTO){
        Person p = this.personRepository.findByName(registrationDTO.firstname, registrationDTO.lastname);
        if (p == null){
            p = new Person(registrationDTO.firstname, registrationDTO.lastname);
            personRepository.persist(p);
        }
        CoursePlan coursePlan = this.coursePlanRepository.findById(registrationDTO.planId);
        coursePlan.personList.add(p);
        return Response.ok(p).build();
    }
}
