/**
 * Tarea: 4
 * Tema: TAD número complejo en Java.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */

class Complejo {
  double pReal, pImaginaria;

  // Constructor de la clase.
  public Complejo(double valorReal, double valorImaginario){
    this.pReal = valorReal;
    this.pImaginaria = valorImaginario;
  }

  // Operación suma.
  Complejo sumar(Complejo numeroComplejo2){
    return new Complejo(pReal + numeroComplejo2.pReal, pImaginaria + numeroComplejo2.pImaginaria);
  }

  Complejo restar(Complejo numeroComplejo2){
    return new Complejo(pReal - numeroComplejo2.pReal, pImaginaria - numeroComplejo2.pImaginaria);
  }

  Complejo multiplicar(Complejo numeroComplejo2){
    return new Complejo((pReal * numeroComplejo2.pReal) - (pImaginaria * numeroComplejo2.pImaginaria), (pReal * numeroComplejo2.pImaginaria) + (pImaginaria * numeroComplejo2.pReal));
  }

  Complejo dividir(Complejo numeroComplejo2){
    return new Complejo(((pReal*numeroComplejo2.pReal+pImaginaria*numeroComplejo2.pImaginaria)/(numeroComplejo2.pReal*numeroComplejo2.pReal+numeroComplejo2.pImaginaria*numeroComplejo2.pImaginaria)),((pReal*numeroComplejo2.pReal+pImaginaria*numeroComplejo2.pImaginaria)/numeroComplejo2.pReal*numeroComplejo2.pReal+numeroComplejo2.pImaginaria*numeroComplejo2.pImaginaria));
  }

  double modulo()
  {
    // Módulo de un número complejo: sqrt(pReal^2 + pImaginaria^2)
    return Math.sqrt((pReal*pReal) + (pImaginaria*pImaginaria));
  }

  boolean esIgual(Complejo numeroComplejo2){
    return (pReal * numeroComplejo2.pReal) == (pImaginaria * numeroComplejo2.pImaginaria);
  }

  void imprimir(){
    System.out.println(this.pReal+" + "+ this.pImaginaria +"i \n");
  }
}
