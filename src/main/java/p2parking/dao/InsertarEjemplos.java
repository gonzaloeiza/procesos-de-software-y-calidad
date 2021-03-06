package p2parking.dao;

import java.util.Date;
import java.util.ArrayList;

import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

public abstract class InsertarEjemplos {

	/**
	 * Metodo main de la clase
	 * 
	 * @param args la matriz de cadenas que recibe
	 */
	public static void main(String args[]) {
		insertar();
	}

	/**
	 * Metodo para insertar ejemplos
	 */
	public static void insertar() {

		System.out.println("Starting ....");
		// Create a PersistenceManagerFactory for this datastore

		System.out.println("DataNucleus AccessPlatform with JDO");
		System.out.println("===================================");

		Usuario u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		Usuario u2 = new Usuario("javier", "javier@opendeusto.es", "1234", "ss");
		Usuario u3 = new Usuario("endika", "endika@opendeusto.es", "1234", "ss");
		Usuario u4 = new Usuario("oier", "oier@opendeusto.es", "1234", "ss");
		Usuario u5 = new Usuario("imanol", "imanol.gutierrez@opendeusto.es", "1234", "ss");
		Usuario u6 = new Usuario("a", "a", "1", "ss");

		Plaza p1 = new Plaza(12.2f, "43°15'53.7\"N 2°56'37.1\"W", new ArrayList<String>(),
				new Date(2000, 03, 15).getTime());
		Plaza p2 = new Plaza(12.2f, "43°15'51.9\"N 2°55'47.1\"W", new ArrayList<String>(),
				new Date(2000, 03, 15).getTime());
		Plaza p3 = new Plaza(12.2f, "43°15'20.2\"N 2°55'53.3\"W", new ArrayList<String>(),
				new Date(2000, 03, 15).getTime());
		Plaza p4 = new Plaza(13.2f, "43°15'42.8\"N 2°54'16.2\"W", new ArrayList<String>(),
				new Date(2000, 03, 15).getTime());

		p1.setTitulo("Plaza en Bilbao");
		p1.setDescripcion("Plaza amplia en el centro de bilbao");
		p2.setTitulo("Plaza en Moyua");
		p2.setDescripcion("Plaza en el parking de Moyua");
		p3.setTitulo("Plaza en el parking de San Mamés");
		p3.setDescripcion("Plaza en el parking en el estadio San Mamés");
		p4.setTitulo("Plaza en Torres isosaki");
		p4.setDescripcion("Plaza en el debajop de las torres");

		u1.getPlazas().add(p1);
		u1.getPlazas().add(p2);
		u2.getPlazas().add(p3);
		u6.getPlazas().add(p4);

		Incidencia i1 = new Incidencia("No hay luz",
				"En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
		Incidencia i2 = new Incidencia("La puerta no funciona",
				"La puerta de entrada al garaje no funciona y no puedo sacar el coche");
		Incidencia i3 = new Incidencia("La aplicación se ha caido",
				"No consigo conectarme a la aplicación. Me da un error del sistema");
		Incidencia i4 = new Incidencia("El cliente no ha pagado",
				"El cliente se ha marchado y no ha pagado el alquiler. Quiero sus datos para hacer una denuncua");

		u1.createIncidencia(i1);
		u4.createIncidencia(i2);
		u5.createIncidencia(i3);
		u5.createIncidencia(i4);

		Plaza miCasa = new Plaza(87, "tebfdvs", new ArrayList<>(), (new Date()).getTime());

		UsuariosDAO.getInstance().save(u1);
		UsuariosDAO.getInstance().save(u2);
		UsuariosDAO.getInstance().save(u3);
		UsuariosDAO.getInstance().save(u4);
		UsuariosDAO.getInstance().save(u5);
		UsuariosDAO.getInstance().save(u6);
//	    //añadir favoritos
		Usuario u = UsuariosDAO.getInstance().find("gonzaloeizaguirre@opendeusto.es");
		Usuario uu = UsuariosDAO.getInstance().find("javier@opendeusto.es");

		u.addPlaza(miCasa);

		// uu.getPlazas().get(0).getUsuariosFavoritos().add(u);
		UsuariosDAO.getInstance().save(u);

	}
}
