import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import { TokenService } from '../service/token.service';
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  rfLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getFormLogin();
  }

  getFormLogin() {
    this.rfLogin = this.formBuilder.group({
      username: [''],
      password: ['']
    })
  }

  login() {
    this.authService.signIn(this.rfLogin.value).subscribe(data => {
      if (data.token != undefined) {
        console.log(data)
        this.tokenService.setToken(data.token);
        this.tokenService.setName(data.name);
        this.tokenService.setRole(data.roles);

        this.router.navigate(['/home']).then(()=>{
          location.reload();
        })

      }
    }, error => {
      this.toastr.error('Tên đăng nhập hoặc mật khẩu không đúng, xin mời đăng nhập lại')
      this.router.navigateByUrl('/login')
      console.log('Đăng nhập thất bại')
    })
  }
}
