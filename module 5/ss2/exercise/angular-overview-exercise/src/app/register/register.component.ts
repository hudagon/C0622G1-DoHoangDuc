import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";

export const checkPassword: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const password = control.get('password');
  const confirmPassword = control.get('confirmPassword');
  if (password.valid &&
    password.value != confirmPassword.value) {
    return {"checkPassword": true}
  } else {
    return null;
  }
}

function checkAge(control: AbstractControl) {
  const age = control.get('age');
  if (age.value < 18) {
    return {"checkAge": true}
  } else {
    return null;
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  rfRegister: FormGroup;

  constructor(private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.rfRegister = this._formBuilder.group({
      emailAddress: ['', [Validators.required,
        Validators.minLength(5),
        Validators.pattern('^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,63})$')]],

      country: ['0', [Validators.pattern('^[^0]$')]],

      gender: ['1'],
      age: [4, [Validators.required, Validators.min(18)]],
      phoneNumber: ['', [Validators.required,
        Validators.pattern('^\\+84\\d{9,10}$')]],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    }, {validators: checkPassword})
  }


  onSubmit() {
    if(this.rfRegister.valid){
      console.log(this.rfRegister.value)
    }
  }

}
