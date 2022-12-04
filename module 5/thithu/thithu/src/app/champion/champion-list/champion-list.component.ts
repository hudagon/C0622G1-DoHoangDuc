import {Component, OnInit} from '@angular/core';
import {ChampionService} from '../../service/champion.service';
import {Champion} from '../../model/champion';
import {Router} from '@angular/router';
import {ChampionTypeService} from '../../service/champion-type.service';
import {ChampionType} from '../../model/champion-type';
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-champion-list',
  templateUrl: './champion-list.component.html',
  styleUrls: ['./champion-list.component.css']
})
export class ChampionListComponent implements OnInit {

  championList: Champion[];
  championTypeList: ChampionType[];

  championView: Champion = {
    'id': -1,
    'name': 'dummy',
    'nation': 'dummy',
    'genre': 'dummy',
    'championType': {
      'id': 'dummy',
      'name': 'dummy'
    }
  };

  page: number = 1;

  idDelete: string;
  nameDelete: string;

  championNameSearch: string = '';
  championTypeSearch: string = '';


  constructor(
    private championService: ChampionService,
    private championTypeService: ChampionTypeService,
    private route: Router,
    private toastr: ToastrService
  ) {
  }

  ngOnInit(): void {
    this.getChampionType();
    this.search();
  }

  search() {
    this.page = 1;
    this.championService.search(this.championNameSearch, this.championTypeSearch).subscribe(championListFound => {
      this.championList = championListFound;
      console.log(this.championList);
    });
  }

  getChampionType() {
    this.championTypeService.getAll().subscribe(championTypeList => {
      this.championTypeList = championTypeList;
    });
  }

  getDeleteId(idDelete: string, nameDelete: string) {

    this.idDelete = idDelete;
    this.nameDelete = nameDelete;

  }

  deleteChampion() {
    this.championService.delete(this.idDelete).subscribe(champion => {
      this.toastr.success('Delete champion Successfully!')
      this.ngOnInit();
    });
  }

  viewChampion(id: string) {
    this.championService.findChampionById(id).subscribe(champion => {
      this.championView = champion;
    });
  }
}
