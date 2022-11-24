import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  rfLogin: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.rfLogin = this._formBuilder.group({
      emailAddress: ['', [Validators.required,
        Validators.minLength(5),
        Validators.pattern('^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,63})$')]],

      password: ['', [Validators.minLength(6), Validators.required]]
    })
  }

  onSubmit() {
    console.log(this.rfLogin.value)
  }
}
