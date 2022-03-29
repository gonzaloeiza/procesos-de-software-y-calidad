/**********************************************************************
Copyright (c) 2003 Andy Jefferson and others. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

Contributors:
    ...
**********************************************************************/
package p2parking.jdo;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class Main {
	
	public static void aniadirUsuario(Usuario u) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try {
            tx.begin();
            System.out.println("Persisting products");
//            Product product = new Product("Sony Discman","A standard discman from Sony",200.00);
//            Book book = new Book("Lord of the Rings by Tolkien","The classic story",49.99,"JRR Tolkien", "12345678", "MyBooks Factory");
            pm.makePersistent(u);
 
            tx.commit();
            System.out.println("Usuario has been persisted");
        }
        finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public static void aniadirPlaza(Plaza p) {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try {
            tx.begin();
            System.out.println("Persisting products");
//            Product product = new Product("Sony Discman","A standard discman from Sony",200.00);
//            Book book = new Book("Lord of the Rings by Tolkien","The classic story",49.99,"JRR Tolkien", "12345678", "MyBooks Factory");
            pm.makePersistent(p);
 
            tx.commit();
            System.out.println("Usuario has been persisted");
        }
        finally {
            if (tx.isActive()) {
                tx.rollback();
            }
            pm.close();
        }
	}
	
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
    	System.out.println("Starting ....");
        // Create a PersistenceManagerFactory for this datastore
        

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistence of a user
        Usuario u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
        Usuario u2 = new Usuario("javier", "javier@opendeusto.es", "1234", "ss");
        Usuario u3 = new Usuario("endika", "endika@opendeusto.es", "1234", "ss");
        Usuario u4 = new Usuario("oier", "oier@opendeusto.es", "1234", "ss");

        aniadirUsuario(u1);
        aniadirUsuario(u2);
        aniadirUsuario(u3);

        Plaza p1 = new Plaza(12.2f, "", new ArrayList<String>(), u1);
        Plaza p2 = new Plaza(12.2f, "", new ArrayList<String>(), u2);
        
                
        ArrayList<Plaza> favs = new ArrayList<Plaza>();
        favs.add(p1);
        favs.add(p2);
        
        u4.addFav(p1);
        aniadirUsuario(u4);

        
        System.out.println("");
    }
}
