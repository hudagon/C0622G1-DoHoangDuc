import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { AuthService } from "../../service/security/auth.service";
import { TokenService } from "../../service/security/token.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-login-sign-up",
  templateUrl: "./login-sign-up.component.html",
  styleUrls: ["./login-sign-up.component.css"],
})
export class LoginSignUpComponent implements OnInit {
  rfLogin: FormGroup;

  constructor(
    private formBuiler: FormBuilder,
    private authService: AuthService,
    private tokenService: TokenService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.getLoginForm();
  }

  getLoginForm() {
    this.rfLogin = this.formBuiler.group({
      username: [""],
      password: [""],
    });
  }

  login() {
    this.authService.login(this.rfLogin.value).subscribe((data) => {
      if (data.token !== undefined) {
        this.tokenService.setAccountSession(data.account);
        this.tokenService.setTokenSession(data.token);
        this.tokenService.setUserSession(data.user);
        this.tokenService.setRoleSession(data.roles);

        this.router.navigate([""]).then(() => {
          location.reload();
        });
      }
    });
  }
}
