import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {SignInForm} from "../model/sign-in-form";
import {JwtRespone} from "../model/jwt-respone";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private URL_API = environment.URL_API;

  constructor(
    private httpClient: HttpClient,
  ) { }

  signIn(signInForm: SignInForm): Observable<JwtRespone> {
    return this.httpClient.post<JwtRespone>(this.URL_API + '/api/auth/signin', signInForm);
  }
}
