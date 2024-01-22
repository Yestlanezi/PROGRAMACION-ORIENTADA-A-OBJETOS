/**
 * Cuenta.java
 *
 * Primer Guía de POO - Problemas de Modelado
 *
 * Problema: 2
 * Planteamiento: Defina el TAD para una cuenta bancaria sencilla en java.
 *                Aqui esta la "especificación":
 *                Cuando se abre la cuenta el cuentahabiente hace su 1er deposito (es decir deposita una cantidad de dinero
 *                inicial).
 *                Podemos:
 *                  -Retirar dinero de esta cuenta.
 *                  -Depositar dinero de esta cuenta.
 *                  -Consultar el saldo (es decir el cuentahabiente puede preguntar cuánto dinero hay en su cuenta.
 *
 * Modelado:
 *
 * |--------------------------|
 * |         Cuenta           |
 * |--------------------------|
 * | saldo                    |
 * | nombre                   |
 * |- - - - - - - - - - - - - |
 * | consultarSaldo()         |
 * | consultarNombre()        |
 * | mostrarEstadoDeCuenta()  |
 * | depositar(double)        |
 * | retirar(double)          |
 * |--------------------------|
 *
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: Miércoles 11 de Noviembre de 2020.
 */

// Clase Cuenta.
public class Cuenta {
  private double saldo; // Variable de instancia para almacenar el saldo en la cuenta.
  private String nombre; // Variable de instancia para alamcenar el nombre del cuentahabiente.

  // Constructor de la clase.
  public Cuenta (double nuevoSaldo, String nuevoNombre) {
    this.saldo = nuevoSaldo;
    this.nombre = nuevoNombre;
  }

  // Método para consultar el saldo de la cuenta.
  public double consultarSaldo() {
    return this.saldo;
  }

  // Método para consultar el nombre del cuentahabiente.
  public String consultarNombre() {
    return this.nombre;
  }

  // Método para imprimir en la terminal la información de la cuenta.
  public void mostrarEstadoDeCuenta() {
    System.out.println("Cuentahabiente: " + this.nombre + ", saldo: $" + this.saldo);
  }

  // Método para depositar dinero en la cuenta.
  public void depositar(double cantidadADepositar) {
    this.saldo += cantidadADepositar;
  }

  // Método para retirar dinero en la cuenta.
  public void retirar(double cantidadARetirar) {
    // Verificamos que no traten de retirar más dinero del que
    // tienen disponible.
    if ((this.saldo - cantidadARetirar) >= 0) {
      // Realizamos la operación.
      this.saldo -= cantidadARetirar;
    }
  }

  /**
   * Método principal
   * Simula la creación de 3 cuentas y transacciones entre sí. Este método
   * se incluye únicamente para probar de forma fácil y eficiente el código
   * de la clase.
   */
  public static void main(String[] args) {
    // Cuentahabientes.
    Cuenta cuentaHumberto = new Cuenta(100.00, "Humberto Alcocer");
    Cuenta cuentaGerardo = new Cuenta(0.00, "Gerardo Alcocer");
    Cuenta cuentaBatman = new Cuenta(1000000.00, "Bruno Díaz");


    // Mostramos la información inicial.
    System.out.println("Saldos iniciales:");
    cuentaHumberto.mostrarEstadoDeCuenta();
    cuentaGerardo.mostrarEstadoDeCuenta();
    cuentaBatman.mostrarEstadoDeCuenta();

    // Realizamos algunas *voluntarias* transacciones.
    cuentaBatman.retirar(5000);
    cuentaHumberto.depositar(2500); // Cortesía de Batman.
    cuentaGerardo.depositar(2500); // ¡Gracias Batman!

    // Veamos si le ~robamos~ mucho dinero a Batman.
    System.out.println("Saldo de Batman post-transacciones: " + cuentaBatman.consultarSaldo());

    // Bueno pero para nosotros si es bastante bueno.
    System.out.println("Saldo de Humberto post-transacciones: " + cuentaHumberto.consultarSaldo());
    System.out.println("Saldo de Gerardo post-transacciones: " + cuentaGerardo.consultarSaldo());

    // Bueno, sacaremos todo en efectivo antes de que Batman denuncie el fraude.
    cuentaHumberto.retirar(2600);
    cuentaGerardo.retirar(2500);

    // Batman es un buen tipo, nos regaló otros $5000.00 a cada uno por ser creativos.
    cuentaBatman.retirar(10000);
    cuentaHumberto.depositar(5000);
    cuentaGerardo.depositar(5000);

    // Mostramos los saldos finales.
    System.out.println("Saldos finales:");
    cuentaHumberto.mostrarEstadoDeCuenta();
    cuentaGerardo.mostrarEstadoDeCuenta();
    cuentaBatman.mostrarEstadoDeCuenta();
  }
}