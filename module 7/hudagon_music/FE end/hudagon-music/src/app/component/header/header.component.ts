import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup } from "@angular/forms";
import { Router } from "@angular/router";
import { UserInformation } from "src/app/payload/response/user-information";
import { AuthServiceService } from "src/app/service/security/auth-service.service";
import { TokenServiceService } from "src/app/service/security/token-service.service";

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {

  checkLogin = false;
  rfLogin: FormGroup;
  userInformation: UserInformation;

  constructor(
    private formBuiler: FormBuilder,
    private authService: AuthServiceService,
    private tokenService: TokenServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if (this.tokenService.isLogged()) {
      this.checkLogin = true;

      this.userInformation = JSON.parse(this.tokenService.getUserInformation());
      
    }
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
        this.tokenService.setTokenSession(data.token);
        this.tokenService.setRoleSession(data.roles);
        this.tokenService.setUserInformationSession(data.userInfomartion);

        this.router.navigate([""]).then(() => {
          location.reload();
        });
      }
    });
  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl("").then(() => {
      location.reload();
    });
  }
}
