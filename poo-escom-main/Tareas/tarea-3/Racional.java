/**
 * Tarea: 3
 * Tema: Suma y Resta de dos números racionales en Java.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */

class Racional {
  int den, num;

  public Racional(int num, int den){
    this.den=den;
    this.num=num;
  }

  Racional mult(Racional r){
    return new Racional(num * r.num, den * r.den);
  }

  Racional division(Racional r){
    return new Racional(num * r.den, den * r.num);
  }

  Racional suma(Racional r){
    return new Racional(num + r.num, den * r.den);
  }

  Racional resta(Racional r){
    return new Racional(num - r.num, den * r.den);
  }

  boolean esIgual(Racional r){
    return num * r.den == den * r.num;
  }

  void imprime(){
    System.out.println(this.num+" / "+ this.den);
  }
}