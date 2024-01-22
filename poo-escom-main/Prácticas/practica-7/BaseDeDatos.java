/**
 * BaseDeDatos.java
 *
 * En este archivo se encuentra la definición e implementación de la clase
 * Base de Datos con la que se realiza la operación de inserción de forma
 * encapsulada.
 *
 * Diagrama UML:
 *
 * |----------------------|
 * |      BaseDeDatos     |
 * |----------------------|
 * | String url           |
 * | Connection conexion  |
 * |- - - - - - - - - - - |
 * | insertarPerro(Perro) |
 * |----------------------|
 *
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
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDeDatos {
  private String url = "jdbc:postgresql:poo";
  private Connection conexion;

  // Constructor de la clase.
  public BaseDeDatos() {
    // Realizamos el intento de conexión dentro de un bloque try/catch.
    try {
      // Class.forName("org.postgresql.Driver");
      conexion = DriverManager.getConnection(this.url);
    } catch (Exception e) {
      System.out.println("Ha ocurrido un problema conectando con la base de datos:");
      e.printStackTrace();
    }
  }

  // Método para realizar la inserción de un nuevo Perro en la base de datos.
  public boolean insertarPerro(Perro nuevoPerro) {
    String consulta = "INSERT INTO perro VALUES (?,?,?,?)";

    // Ejecutamos la consulta dentro de un bloque try/catch.
    try {
      CallableStatement statement = conexion.prepareCall(consulta);

      // Ajustamos los parámetros de la consulta.
      statement.setString(1, nuevoPerro.getNombre());
      statement.setString(2, nuevoPerro.getRaza());
      statement.setInt(3, nuevoPerro.getEdad());
      statement.setString(4, nuevoPerro.getGenero());

      // Realizamos la consulta en la base de datos.
      statement.executeUpdate();

      // Si no se arrojó una excepción, asumimos que la operación fue exitosa.
      return true;
    } catch (Exception e) {
      // Mostramos información del error.
      System.out.println("Ocurrió un error al tratar de insertar el nuevo Perro:");
      e.printStackTrace();

      // La ejecución no fue exitosa.
      return false;
    }
  }
}
