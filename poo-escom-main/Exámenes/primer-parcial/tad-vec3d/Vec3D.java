/**
 * Vec3D.java
 *
 * Descripción:
 *    2.-Codificar en Java un tipo de dato abstracto (TAD) para vectores tridimensionales Vec3D
 *
 *        Si v1 = (x1, y1, z1) y v1 = (x2, y2, z2)
 *        entonces
 *
 *        suma v1+v2=(x1+x2, y1+y2, z1+z2)
 *        resta v1-v2=(x1-x2, y1-y2, z1-z2)
 *        producto punto v1.v2= x1*x2 + y1*y2 + z1*z2 resultado escalar
 *
 *        Si v = (x, y, z) entonces modulo(v) = sqrt(x*x + y*y+z*z) = sqrt (productoPunto(v.v))
 *
 *        v1 = v2 si x1 = x2 y y1 = y2 y z1 = z2
 *
 *        Codificar el constructor
 *
 *        Este TAD debe tener las siguientes operaciones: sumar, restar, productoPunto, modulo, esIgual, imprimir
 *
 * Diagrama de modelado UML:
 *
 * |----------------------|
 * |         Vec3D        |
 * |----------------------|
 * | x                    |
 * | y                    |
 * | z                    |
 * |- - - - - - - - - - - |
 * | sumar(Vec3D)         |
 * | restar(Vec3D)        |
 * | productoPunto(Vec3D) |
 * | modulo(Vec3D)        |
 * | esIgual(Vec3D)       |
 * | imprimir()           |
 * |----------------------|
 *
 *  Examen: Primer Parcial
 *  Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 *  Grupo: 2CM1
 *  Profesor: Roberto Tecla
 *  Materia: Programación Orientada a Objetos
 *  Fecha: 28 de Octubre de 2020
 */

public class Vec3D {
  private double x, y, z; // Variables de instancia.

  // Constructor de la clase.
  public Vec3D(double x1, double y1, double z1) {
    this.x = x1;
    this.y = y1;
    this.z = z1;
  }

  // Método que realiza la suma de dos Vec3D.
  public Vec3D sumar(Vec3D vector2) {
    return new Vec3D(this.x + vector2.x, this.y + vector2.y, this.z + vector2.z);
  }

  // Método que realiza la resta entre dos Vec3D.
  public Vec3D restar(Vec3D vector2) {
    return new Vec3D(this.x - vector2.x, this.y - vector2.y, this.z - vector2.z);
  }

  // Método que realiza la operación producto-punto para dos Vec3D.
  public double productoPunto(Vec3D vector2) {
   return (this.x * vector2.x) + (this.y + vector2.y) + (this.z + vector2.z);
  }

  // Método que realiza la oepración producto-punto con dos Vec3D
  public double modulo(Vec3D vector2) {
    return Math.sqrt(this.productoPunto(vector2));
  }

  // Método que verifica si dos Vec3D son iguales.
  public boolean esIgual(Vec3D vector2) {
    return this.x == vector2.x && this.y == vector2.y && this.z == vector2.z;
  }

  // Método que imprime un Vec3D en la salida estándar.
  public void imprimir() {
    System.out.println("(" + this.x + ", " + this.y + ", " + this.z + ")");
  }

  /**
   * Método principal
   * Aquí comprobamos todas las operaciones con Vec3D disponibles.
   */
  public static void main(String[] args) {
    Vec3D v1 = new Vec3D(1.14, 25.87, 14.32); // Primer vector para operaciones.
    Vec3D v2 = new Vec3D(16.7, 14.0, 11.98); // Segundo vector para operaciones.

    // Mostramos los vectores iniciales.
    System.out.println("Nuestros vectores iniciales son:");
    v1.imprimir();
    v2.imprimir();

    // Operación de suma.
    Vec3D resSuma = v1.sumar(v2);
    System.out.println("El resultado de la suma es:");
    resSuma.imprimir();

    // Operación de resta.
    Vec3D resResta = v1.restar(v2);
    System.out.println("El resultado de la resta es:");
    resResta.imprimir();

    // Operación de producto punto
    double resProductoPunto = v1.productoPunto(v2);
    System.out.println("El resultado del producto punto es: " + resProductoPunto);

    // Operación módulo
    double resModulo = v1.modulo(v2);
    System.out.println("El resultado del módulo es: " + resModulo);

    // Operación es igual.
    if (v1.esIgual(v2)) {
      System.out.println("Ambos vectores inciales son iguales.");
    } else {
      System.out.println("Los vectores iniciales son distintos.");
    }
  }
}
