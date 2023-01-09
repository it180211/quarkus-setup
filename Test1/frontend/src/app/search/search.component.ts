import {Component, OnInit} from '@angular/core';
import {CourseServiceService} from "../service/course-service.service";
import {Course} from "../model/course.model";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  constructor(private cs: CourseServiceService) { }

  text = ''
  courseList: Course[] = []


  ngOnInit(): void {
  }

  search(){
    this.cs.search(this.text).subscribe((cl) => {
      this.courseList = cl;
    })
  }

}
