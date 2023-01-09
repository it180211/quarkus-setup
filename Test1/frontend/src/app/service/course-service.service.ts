import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../model/course.model";
import {Observable} from "rxjs";
import {CoursePlan} from "../model/courseplan.model";
import {Person} from "../model/person.model";
import {Register} from "../model/register";

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

  constructor(private http: HttpClient) { }

  URL = "http://localhost:8080/api/course/"


  search(text: string): Observable<Course[]>{
    return this.http.get<Course[]>(this.URL + "search/" + text)
  }

  getCourseByID(id: string): Observable<Course>{
    return this.http.get<Course>(this.URL + id)
  }

  getCoursePlansByID(id: string): Observable<CoursePlan[]>{
    return this.http.get<CoursePlan[]>(this.URL + "plan/" + id)
  }
  register(register: Register): Observable<Register>{

    return this.http.post<Register>(this.URL + "plan", register)
  }


}
