import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ChampionType} from '../../model/champion-type';
import { ChampionTypeService } from 'src/app/service/champion-type.service';
import {ActivatedRoute, Router} from '@angular/router';
import { ChampionService } from 'src/app/service/champion.service';
import {Champion} from '../../model/champion';
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-champion-edit',
  templateUrl: './champion-edit.component.html',
  styleUrls: ['./champion-edit.component.css']
})
export class ChampionEditComponent implements OnInit {

  rfChampionEdit: FormGroup;
  championTypeList: ChampionType[];
  championId: string;
  championATBE: Champion;

  constructor(
    private formBuilder: FormBuilder,
    private championTypeService: ChampionTypeService,
    private router: Router,
    private championService: ChampionService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.championId = params.id;
    })

    this.getChampionTypeList();
    this.getEditChampion(this.championId)
  }

  getChampionTypeList() {
    this.championTypeService.getAll().subscribe(championTypeList => {
      this.championTypeList = championTypeList;
    })
  }

  getEditChampion(championId: string) {
    this.championService.findChampionById(championId).subscribe(championFound => {
      console.log(championFound);
      this.championATBE = championFound;
      this.rfChampionEdit = this.formBuilder.group({
        id: [championFound.id],
        name: [championFound.name, [Validators.required]],
        nation: [championFound.nation, [Validators.required]],
        genre: [championFound.genre, [Validators.required]],
        championType: [championFound.championType, [Validators.required]]
      })
    })
  }

  edit() {
    this.championService.edit(this.rfChampionEdit.value).subscribe(data => {
      this.toastr.success('Edit champion successfully!')
      this.router.navigateByUrl('/champion/list')
    });
  }
}
