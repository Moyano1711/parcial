import {Injectable} from '@angular/core';
import {from, map} from "rxjs";
import axios, {AxiosResponse} from "axios";
import {Equipo} from "../model/equipo.model";

@Injectable({
  providedIn: 'root'
})

export class EquipoService{
  private apiUrl: string = 'http://localhost:8081/parcialWeb/api/equipo/';

  public getEquipos (){
    return from (axios.get(this.apiUrl))
      .pipe(map((response : AxiosResponse<Equipo[]>) => response.data))
  }

  public createEquipos(){

  }
}

