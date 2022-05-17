![java ci workflow](https://github.com/gonzaloeiza/procesos-de-software-y-calidad/actions/workflows/java-ci.yml/badge.svg)

COMANDOS
----------------------------------------------------------
Para compilar el proyecto:
```
mvn compile
```

Para generar la documentación:
```
mvn javadoc:javadoc
```

Para ejecutar los tests que no requieren que la base de datos esté corriendo:
```
mvn test
```

Para hacer persistentes las clases:
```
mvn datanucleus:enhance
```

Para la creación del usuario y el esquema en el servidor MYSQL:
```
DROP SCHEMA IF EXISTS p2parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';
CREATE SCHEMA p2parkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON p2parkingDB.* TO 'spq'@'localhost';
```

Para crear las tablas de la base de datos:
```
mvn datanucleus:schema-create
```

Para insertar ejemplos en la base de datos:
```
mvn exec:java -PinsertarEjemplos
```

Para ejecutar los tests que requieren que la base de datos este corriendo:
```
mvn test -Dgroups="p2parking.testCategories.IntegrationTest"
```

Para correr la API REST:
```
mvn jetty:run
```

Para ejecutar la aplicacion del cliente:
```
mvn exec:java -Pclient
```

Para borrar las tablas de la base de datos:
```
mvn datanucleus:schema-delete
```
