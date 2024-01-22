/**
 * Tarea: 2
 * Tema: Suma y Resta de dos números racionales en C.
 * Materia: Programación Orientada a Objetos.
 * Profesor: Roberto Tecla
 * Alumno: Humberto Alejandro Ortega Alcocer (2016630495) <hortegaa1500@alumno.ipn.mx>
 * Grupo: 2CM1
 * Fecha: 22 de Octubre del 2020
 */
#include <stdio.h>  // Operaciones de E/S
#include <stdlib.h> // Para usar malloc a partir de C99.

// Typedef + struct para ahorrar pasos.
typedef struct racional
{
  int num, den;
} Racional;

/*Pre-condición: den  <> 0 */
Racional *crearRacional(int num, int den)
{
  Racional *nvo;

  // No puede ser el denominador 0.
  if (den == 0)
    return (Racional *)NULL;

  // Asignamos la memoria para el nuevo elemeto.
  nvo = (Racional *)malloc(sizeof(Racional));

  // Si no hay espacio en memoria, imprimimos mensaje y salimos.
  if (!nvo)
  {
    printf("No hay memoria para crear Racional.\n");
    return (Racional *)NULL;
  }

  // Realizamos la asignación de los datos.
  nvo->num = num;
  nvo->den = den;

  // Regresamos el apuntador con el número racional recién creado.
  return nvo;
}

/* Pre-condición: r ha sido creado. */
void asignar(Racional *r, int num, int den);

/* Pre-condición: r ha sido creado. */
int numerador(Racional *r)
{
  return r->num;
}

/* Pre-condición: r ha sido creado. */
int denominador(Racional *r)
{
  return r->den;
}

/* Pre-condición:  r1 y r2 han sido creados. */
Racional *multiplicar(Racional *r1, Racional *r2)
{
  return crearRacional(r1->num * r2->num, r1->den * r2->den);
}

/* Comprueba si dos números racionales son iguales */
int igual(Racional *r1, Racional *r2)
{
  return r1->num * r2->den == r1->den * r2->num;
}

/* Imprime un número racional */
void imprimir(void *q)
{
  Racional *r = (Racional *)q;
  printf("[%d / %d]", r->num, r->den);
}

/* Suma de dos números racionales */
Racional *sumar(Racional *r1, Racional *r2)
{
  return crearRacional(r1->num + r2->num, r1->den * r2->den);
}

/* Resta de dos números racionales */
Racional *restar(Racional *r1, Racional *r2)
{
  return crearRacional(r1->num - r2->num, r1->den * r2->den);
}

/* Función principal */
int main()
{
  // Variables locales.
  Racional *r1, *r2, *res_mult, *res_suma, *res_resta;

  // Creamos el primer número racional y lo imprimimos.
  r1 = crearRacional(2, 3);
  imprimir(r1);

  // Creamos el segundo número racional y lo imprimimos.
  r2 = crearRacional(3, 2);
  imprimir(r2);

  // Realizamos la multiplicación y mostramos el resultado.
  res_mult = multiplicar(r1, r2);
  imprimir(res_mult);

  // Resta de dos números racionales.
  res_resta = restar(r1, r2);
  imprimir(res_resta);

  // Suma de dos números racionales.
  res_suma = sumar(r1, r2);
  imprimir(res_suma);

  // Salida Final:
  // 2 / 3][3 / 2][6 / 6][-1 / 6][5 / 6]

  // Ejecución correcta, exit status 0.
  return 0;
}

/* Tarea 1, Programación Orientada a Objetos, ESCOM, Humberto Alejandro Ortega Alcocer, 2CM1 */
