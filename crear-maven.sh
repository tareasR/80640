#!/bin/bash
#!/bin/bash
if [ $# -eq 0 ]; then 
  echo "Debes indicar el nombre para el paquete y el nombre del proyecto a crear"
  echo -e "ejemplo: \033[31m crear-maven \033[32mmx.uv \033[34mpracticaXX \033[0m"
  exit
else
  mvn archetype:generate \
	-DgroupId=$1 \
	-DartifactId=$2 \
	-DarchetypeArtifactId=maven-archetype-quickstart \
	-DarchetypeVersion=1.4 \
	-DinteractiveMode=false
fi
