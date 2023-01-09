import {Component, OnInit} from '@angular/core';
import {Course} from "../model/course.model";
import {CourseServiceService} from "../service/course-service.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CoursePlan} from "../model/courseplan.model";
import {Person} from "../model/person.model";
import {Register} from "../model/register";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  course!: Course;
  coursePlanList: CoursePlan[] = []
  id = ''
  firstname = '';
  lastname = '';
  cplId = 0;
  registerDTO = {} as Register

  constructor(private cs: CourseServiceService, private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit(): void {
      this.id = this.route.snapshot.params["id"]
      this.getCourseById()
      this.getCoursePlanById()
  }

  getCourseById(){
    this.cs.getCourseByID(this.id).subscribe((c) =>
      this.course = c
    )
  }

  getCoursePlanById(){
    this.cs.getCoursePlansByID(this.id).subscribe((cp) =>{
      this.coursePlanList = cp

    })
  }

  register(){

    this.registerDTO.firstname = this.firstname;
    this.registerDTO.lastname = this.lastname;
    this.registerDTO.planId = this.cplId;
    this.cs.register(this.registerDTO!).subscribe(()=>
      console.log(this.registerDTO)
    )
    this.router.navigate(['registered'])

  }
}
