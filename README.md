EXECUTION OF RMIREGISTRY, SERVER AND CLIENT AS 3 PROCESSES
----------------------------------------------------------

First, compile the whole code:
1. mvn compile

Then, in three separate cmd windows, run:

1. mvn jetty:run 
2. mvn datanucleus:schema-create
3. mvn exec:java
4. mvn datanucleus:schema-delete

5. mvn exec:java -PinsertarEjemplos
6. mvn exec:java -Pmanager
7. mvn exec:java -Pclient




