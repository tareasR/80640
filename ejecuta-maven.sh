#!/bin/bash
if [ $# -eq 0 ]; then 
  echo "Debes indicar el nombre del paquete y el nombre de la clase a ejecutar"
  echo -e "ejemplo: \033[31m ejecuta-maven \033[32mmx.uv.\033[34mApp \033[0m"
  exit
else
  mvn exec:java -Dexec.mainClass=$1
fi
