import {Component, OnInit} from '@angular/core';
import {TokenService} from '../../service/security/token.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  checkLogin = false;

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) {
  }

  ngOnInit(): void {

    if (this.tokenService.isLogged()) {
      this.checkLogin = true;
    }

  }

  logOut() {
    this.tokenService.logOut();
    this.router.navigateByUrl('').then(() => {
      location.reload();
    });
  }

}
