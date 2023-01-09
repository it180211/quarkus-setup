import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {SearchComponent} from './search/search.component';
import {CourseComponent} from './course/course.component';
import {RegisteredComponent} from './registered/registered.component';
import {Router, RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";

const routes: Routes = [
    { path: 'search', component: SearchComponent },
    { path: 'course/:id', component: CourseComponent},
    { path: 'registered', component: RegisteredComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    CourseComponent,
    RegisteredComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
