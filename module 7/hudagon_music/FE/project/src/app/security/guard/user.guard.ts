import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {TokenService} from '../../service/security/token.service';

@Injectable({
  providedIn: 'root'
})
export class UserGuard implements CanActivate {
  roles: string[];

  constructor(
    private tokenService: TokenService,
    private router: Router
  ) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    if (this.tokenService.isLogged()) {
      this.roles = this.tokenService.getRole();

      for (const x of this.roles) {
        if (x === 'ROLE_USER') {
          return true;
        }
      }

      this.router.navigateByUrl('');

    } else {
      this.router.navigateByUrl('');
    }
  }

}
