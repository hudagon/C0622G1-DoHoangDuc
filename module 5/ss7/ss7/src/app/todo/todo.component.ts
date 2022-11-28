import { Component, OnInit } from '@angular/core';
import {Todo} from "../model/todo";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {TodoService} from "../service/todo.service";
import { Router } from '@angular/router';

let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  todoList: Todo[] = [];

  rfTodo: FormGroup;

  constructor(
    private todoService: TodoService,
    private _formBuilder: FormBuilder,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.getAll();
    this.rfTodo = this._formBuilder.group({
      id: [''],
      content: ['1'],
      complete: [false],
    })
  }

  toggleTodo(i: number) {
    this.todoList[i].complete = !this.todoList[i].complete;
  }

  getAll() {
    this.todoService.getAll().subscribe(todoList => {
      this.todoList = todoList;
    })
  }


  create() {
    this.todoService.create(this.rfTodo.value).subscribe(todo => {
      this.router.navigateByUrl('todo');
    })
  }

  delete(id: number) {
    this.todoService.delete(id).subscribe(todo => {
      this.router.navigateByUrl('todo');
    })
  }
}
