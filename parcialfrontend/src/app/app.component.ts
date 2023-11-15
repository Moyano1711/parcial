import {Component, OnInit} from '@angular/core';
import {EquipoService} from "./services/equipo.service";
import {Equipo} from "./model/equipo.model";
import {Jugador} from "./model/jugador.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'parcialfrontend';
  equipos : Equipo[] = []
  jugadores : Jugador[] = []

  constructor( private equipoService: EquipoService) {

  }

  ngOnInit():void {
    this.equipoService.getEquipos().subscribe((res : Equipo[]) : void =>{
      this.equipos = res
    })
  }
}
