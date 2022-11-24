import { Component, OnInit } from '@angular/core';
import {Todo} from "../../model/todo";
import {FormControl} from "@angular/forms";

let _id = 1;

@Component({
  selector: 'app-todo-app',
  templateUrl: './todo-app.component.html',
  styleUrls: ['./todo-app.component.css']
})
export class TodoAppComponent implements OnInit {

  todos : Todo[] = [{content: 'hard'}, {content: 'work'}];

  content = new FormControl();

  constructor() { }

  ngOnInit(): void {
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

}
