import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Todo} from "../model/todo";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todoList: Todo[] = [];

  constructor(
    private httpClient: HttpClient,
  ) { }

  getAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(environment.apiUrlTodo)
  }

  create(todo: Todo): Observable<Todo> {
    return this.httpClient.post<Todo>(environment.apiUrlTodo, todo)
  }

  delete(id: number): Observable<void> {
    return this.httpClient.delete<void>(environment.apiUrlTodo + '/' + id);
  }
}
