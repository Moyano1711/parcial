export class Equipo{
  id : number
  nombre : string
  ciudad : string
  copasInternacionales :  number

  constructor(id : number, nombre:string, ciudad:string, copasInternacionales:number) {
    this.id = id
    this.nombre = nombre
    this.ciudad = ciudad
    this.copasInternacionales = copasInternacionales
  }
}
