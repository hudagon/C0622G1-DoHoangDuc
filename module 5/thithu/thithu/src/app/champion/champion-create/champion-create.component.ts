import { Component, OnInit } from '@angular/core';
import {ChampionTypeService} from '../../service/champion-type.service';
import {Router} from '@angular/router';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {ChampionType} from '../../model/champion-type';
import { ChampionService } from 'src/app/service/champion.service';
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-champion-create',
  templateUrl: './champion-create.component.html',
  styleUrls: ['./champion-create.component.css']
})
export class ChampionCreateComponent implements OnInit {

  rfChampion: FormGroup;
  championTypeList: ChampionType[];

  constructor(
    private championTypeService: ChampionTypeService,
    private router: Router,
    private formBuilder: FormBuilder,
    private championService: ChampionService,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getChampionTypeList();
    this.getChampionForm();
  }

  getChampionTypeList() {
    this.championTypeService.getAll().subscribe(championTypeList => {
      this.championTypeList = championTypeList;
    })
  }

  getChampionForm() {
    this.rfChampion = this.formBuilder.group({
      id: [''],
      name: ['', [Validators.required]],
      nation: ['', [Validators.required]],
      genre: ['', [Validators.required]],
      championType: ['', [Validators.required]],
    })
  }

  create() {
    const championABTC = this.rfChampion.value;
    this.championService.createChampion(championABTC).subscribe(champion => {
      this.toastr.success('Adding new champion successfully!')
      this.router.navigateByUrl('/champion/list');
    })
  }
}
