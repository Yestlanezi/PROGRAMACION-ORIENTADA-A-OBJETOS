/**
 * Tarea: 5
 * Tema: TAD cuenta bancaria en Java.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */

public class Cuenta {
  private double saldo;
  private String nombre;

  public Cuenta (double nuevoSaldo, String nuevoNombre) {
    this.saldo = nuevoSaldo;
    this.nombre = nuevoNombre;
  }

  public double consultarSaldo() {
    return this.saldo;
  }

  public String consultarNombre() {
    return this.nombre;
  }

  public void mostrarEstadoDeCuenta() {
    System.out.println("Cuentahabiente: " + this.nombre + ", saldo: $" + this.saldo);
  }

  public void depositar(double cantidadADepositar) {
    this.saldo += cantidadADepositar;
  }

  public void retirar(double cantidadARetirar) {
    // Verificamos que no traten de retirar más dinero del que
    // tienen disponible.
    if ((this.saldo - cantidadARetirar) >= 0) {
      // Realizamos la operación.
      this.saldo -= cantidadARetirar;
    }
  }
}