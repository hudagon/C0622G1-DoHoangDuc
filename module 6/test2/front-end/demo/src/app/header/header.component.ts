import {Component, OnInit} from '@angular/core';
import {TokenService} from "../service/token.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  nameAccount: string;
  checkLogin = false;
  accountRole: string;


  constructor(
    private tokenService: TokenService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    if (this.tokenService.getToken()) {
      this.checkLogin = true;
      this.nameAccount = this.tokenService.getName();
    }

    for (let i = 0; i < this.tokenService.getRole().length; i++) {
      console.log(this.tokenService.getRole()[i])
      if (this.tokenService.getRole()[i] === "ROLE_ADMIN") {
        this.accountRole = "ROLE_ADMIN"
      }
    }

  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl('/home').then(() => {
      location.reload();
    })
  }

}
