
/**
 * Perro.java
 *
 * En este archivo se encuentra la definición e implementación de la clase Perro.
 *
 * Diagrama UML:
 *
 * |---------------|
 * |     Perro     |
 * |---------------|
 * | String nombre |
 * | String raza   |
 * | int edad      |
 * | String genero |
 * |- - - - - - - -|
 * | getNombre()   |
 * | getRaza()     |
 * | getEdad()     |
 * | getGenero()   |
 * |---------------|
 *
 * Datos:
 * ~ Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * ~ Grupo: 2CM1
 * ~ Práctica Número: 7
 * ~ Tema: JDBC.
 * ~ Opción: 1 "Insertar Perros en una Base de Datos"
 * ~ Fecha: 14 de Enero de 2020.
 * ~ Materia: Programación Orientada a Objetos.
 */

// Clase Perro.
public class Perro {
  private String nombre;
  private String raza;
  private int edad;
  private String genero;

  // Constructor de la clase.
  public Perro(String nom, String raz, int ed, String gen) {
    this.nombre = nom;
    this.raza = raz;
    this.edad = ed;
    this.genero = gen;
  }

  // Método para obtener el nombre.
  public String getNombre() {
    return this.nombre;
  }

  // Método para obtener la raza.
  public String getRaza() {
    return this.raza;
  }

  // Método para obtener la edad.
  public int getEdad() {
    return this.edad;
  }

  // Método para obtener el género.
  public String getGenero() {
    return this.genero;
  }
}
