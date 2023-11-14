export class Equipo{
  id : number
  nombre : string
  copasInternacionales :  number

  constructor(id : number, nombre:string, copasInternacionales:number) {
    this.id = id
    this.nombre = nombre
    this.copasInternacionales = copasInternacionales
  }
}
