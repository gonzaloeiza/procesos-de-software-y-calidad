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

import java.util.ArrayList;

import p2parking.dao.PlazasDAO;
import p2parking.dao.UsuariosDAO;


public class Main {
	
    @SuppressWarnings("unchecked")
	public static void main(String args[]) {
    	System.out.println("Starting ....");
        // Create a PersistenceManagerFactory for this datastore
        

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        
        Plaza p1 = new Plaza(12.2f, "", new ArrayList<String>());
        Plaza p2 = new Plaza(12.2f, "", new ArrayList<String>());
        Plaza p3 = new Plaza(12.2f, "", new ArrayList<String>());  
        
        
        Usuario u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
        Usuario u2 = new Usuario("javier", "javier@opendeusto.es", "1234", "ss");
        Usuario u3 = new Usuario("endika", "endika@opendeusto.es", "1234", "ss");
        Usuario u4 = new Usuario("oier", "oier@opendeusto.es", "1234", "ss");

        u1.getPlazas().add(p1);
        u1.getPlazas().add(p2);
        u2.getPlazas().add(p3);
       
        
        UsuariosDAO.getInstance().save(u1);
        UsuariosDAO.getInstance().save(u2);
        UsuariosDAO.getInstance().save(u3);
        UsuariosDAO.getInstance().save(u4);
        
        
//        ArrayList<Plaza> listaPlazas1 = new ArrayList<Plaza>();
//        listaPlazas1.add(p1);
//        listaPlazas1.add(p2);
//
//        ArrayList<Plaza> listaPlazas2 = new ArrayList<Plaza>();
//        listaPlazas1.add(p3);
        
        
       
//        
//        

        
        
        
        System.out.println("");
    }
}
