package p2parking.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.google.gson.Gson;
import p2parking.dao.iAccesoObjeto;
import p2parking.jdo.Incidencia;
import p2parking.jdo.Plaza;
import p2parking.jdo.Usuario;

public class MainServerTest {
	
	@Mock
	iAccesoObjeto<Usuario> usuariosDAO;

	MainServer server = new MainServer();
	Usuario u1;
	Plaza p1;
    Plaza p2;
    Plaza p3;
    
	@Before
	public void setUp() {		
		server = new MainServer();
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
		p1 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		p2 = new Plaza(12.2f, "", new ArrayList<String>(),  new Date(2000, 03, 15).getTime());
		p3 = new Plaza(12.2f, "", new ArrayList<String>(), new Date(2000, 03, 15).getTime());
		
		u1.getPlazas().add(p1);
	    u1.getPlazas().add(p2);
	    u1.getPlazas().add(p3);
	    
	    Incidencia i1 = new Incidencia("No hay luz", "En la plaza que he reservado no hay electricidad y no puedo ver correctamente");
	    Incidencia i2 = new Incidencia("La puerta no funciona", "La puerta de entrada al garaje no funciona y no puedo sacar el coche");
	    Incidencia i3 = new Incidencia("La aplicación se ha caido", "No consigo conectarme a la aplicación. Me da un error del sistema");
	    Incidencia i4 = new Incidencia("El cliente no ha pagado", "El cliente se ha marchado y no ha pagado el alquiler. Quiero sus datos para hacer una denuncua");
	    
	    u1.createIncidencia(i1);
	    u1.createIncidencia(i2);
	    u1.createIncidencia(i3);
	    u1.createIncidencia(i4);
	}
	
	@Test
	public void testLogin() {
//		System.out.println(usuariosDAO);
//		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);

		
//		String correo = "gonzaloeizaguirre@opendeusto.es";
//		String contrasena = "1234";
//		Gson gson = new Gson();
//		List<String> requestBody = new ArrayList<String>();
//		requestBody.add(gson.toJson(correo));
//		requestBody.add(gson.toJson(contrasena));
//		System.out.println(server.login(requestBody));
	}
}