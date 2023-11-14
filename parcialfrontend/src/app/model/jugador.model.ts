export class Jugador{
  id : number
  nombres : string
  apellidos : string
  numero :  number
  id_equipo : number

  constructor(id : number, nombres:string, apellidos:string, numero:number, id_equipo:number) {
    this.id = id
    this.nombres = nombres
    this.apellidos = apellidos
    this.numero = numero
    this.id_equipo = id_equipo
  }
}
