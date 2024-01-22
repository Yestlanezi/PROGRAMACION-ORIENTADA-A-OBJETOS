#!/bin/bash

# En este archivo se incluyen los comandos para:
#   1) Compilar el archivo Triangulo.java
#   2) Mover el archivo resultante + su .class a la carpeta correspondiente.
#   3) Ejecutar el servidor de winstone

# 1) Compilar el archivo Triangulo.java
javac -cp .:./webapp/WEB-INF/lib/servlet-api.jar Triangulo.java

# 2) Copiar y mover los resultados a la carpeta destino para ejecución con winstone.
cp Triangulo.* ./webapp/WEB-INF/classes/

# 3) Ejecutar el servidor winstone en el puerto 5050.
java -jar winstone-0.9.10.jar --webroot=webapp --httpPort=5050

