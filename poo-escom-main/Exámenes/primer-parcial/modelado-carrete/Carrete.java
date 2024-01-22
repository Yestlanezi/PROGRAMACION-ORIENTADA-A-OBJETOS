/**
 * Carrete.java
 *
 * Descripción:
 *   1.- Modelar un Carrete (o rollo) de cable
 *       -suponga que cada carrete viene con 100 m de cable
 *       -el cable solo se vende al menudeo por metro (o sea no por carrete)
 *       -Si hay suficiente cable entonces se debe cortar del carrete la cantidad de cable que pida el cliente
 *
 * Diagrama de modelado UML:
 *
 * |-----------------------------|
 * |           Carrete           |
 * |-----------------------------|
 * |  metros                     |
 * | - - - - - - - - - - - - - - |
 * | obtenerMetrosDisponibles()  |
 * | cortarMetros(int)           |
 * |-----------------------------|
 *
 *
 * Examen: Primer Parcial
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Profesor: Roberto Tecla
 * Materia: Programación Orientada a Objetos
 * Fecha: 28 de Octubre de 2020.
 *
 */


// Clase Carrete
public class Carrete {
  private int metros; // Variable de instancia

  // Constructor de la clase.
  public Carrete() {
    this.metros = 100; // Todos los carretes inician con 100 metros.
  }

  // Método para "cortar" y despachar un cierto número de metros a un cliente si
  // se cuentan con suficientes metros diponibles o 0 si no se pudo realizar el
  // corte.
  public int cortarMetros(int metrosACortar) {
    if (this.obtenerMetrosDisponibles() >= metrosACortar) {
      this.metros -= metrosACortar; // Restamos la cantidad a cortar.
      return metrosACortar;
    } else {
      return 0;
    }
  }

  // Método para obtener el número de metros disponibles en el carrete.
  public int obtenerMetrosDisponibles() {
    return this.metros;
  }

  /**
   * Método principal
   * Realiza la ejecución del código simulando 3 clientes que llegan a pedir distintas medidas de cable
   * de un carrete y al final imprime las cantidades resultantes.
   */
  public static void main(String[] args) {
    // Creamos un carrete de cable UTP categoría 5e para vender en nuestra tiendita de equipo de redes.
    Carrete utpCat5e = new Carrete();

    // Llega nuestro primer cliente y nos pide 200 metros.
    int metrosVendidosCliente1 = utpCat5e.cortarMetros(200);

    // Verificamos si fue posible despachar la cantidad de metros que pidió el cliente 1.
    if (metrosVendidosCliente1 > 0) {
      System.out.println("Se vendieron 200 metros al cliente 1");
    } else {
      System.out.println("No se pudieron vender 200 metros al cliente 1 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros.");
    }

    // Llega un cliente 2 y pide 50 metros.
    int metrosVendidosCliente2 = utpCat5e.cortarMetros(50);

    // Verificamos si fue posible despachar la cantidad de metros de cable del cliente 2.
    if (metrosVendidosCliente2 > 0) {
      System.out.println("Se vendieron 50 metros al cliente 2");
    } else {
      System.out.println("No se pudieron vender 50 metros al cliente 2 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros");
    }

    // Llega un cliente 3 y pide 51 metros.
    int metrosVendidosCliente3  = utpCat5e.cortarMetros(51);

    // Verificamos si fue posible despachar la cantidad de metros de cable del cliente 3.
    if (metrosVendidosCliente3 > 0) {
      System.out.println("Se vendieron 51 metros al cliente 3");
    } else {
      System.out.println("No se pudieron vender 51 metros al cliente 3 porque únicamente tenemos: " + utpCat5e.obtenerMetrosDisponibles() + " metros");
    }

    // Al final hacemos cuentas de cuántos metros vendimos y mostramos los resultados.
    System.out.println("Se vendió un total de: " + (100 - utpCat5e.obtenerMetrosDisponibles()) + " metros.");
    System.out.println("El cliente 1 se llevó: " + metrosVendidosCliente1 + " metros");
    System.out.println("El cliente 2 se llevó: " + metrosVendidosCliente2 + " metros");
    System.out.println("El cliente 3 se llevó: " + metrosVendidosCliente3 + " metros");
  }
}
