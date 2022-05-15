![java ci workflow](https://github.com/gonzaloeiza/procesos-de-software-y-calidad/actions/workflows/java-ci.yml/badge.svg)

COMANDOS
----------------------------------------------------------

1. mvn compile
2. mvn javadoc:javadoc
3. mvn test
4. mvn datanucleus:enhance
5. mvn datanucleus:schema-create
6. mvn jetty:run
7. mvn exec:java -PinsertarEjemplos
8. mvn exec:java -Pclient
9. mvn datanucleus:schema-delete


Creación del usuario y el esquema en el servidor MYSQL

```
DROP SCHEMA IF EXISTS p2parkingDB;
DROP USER IF EXISTS 'spq'@'localhost';
CREATE SCHEMA p2parkingDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON p2parkingDB.* TO 'spq'@'localhost';
```





