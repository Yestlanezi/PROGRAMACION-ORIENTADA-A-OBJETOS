/**
 * Tarea: 5
 * Tema: TAD cuenta bancaria en Java.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */

public class Main {
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