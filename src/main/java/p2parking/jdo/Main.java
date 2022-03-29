package p2parking.jdo;

import p2parking.dao.InsertarEjemplos; 


public class Main {
	
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
    	
    	// insertar ejemplos desde la clase InsertarEjemplos del DAO
    	InsertarEjemplos.insertar();
    }
}
