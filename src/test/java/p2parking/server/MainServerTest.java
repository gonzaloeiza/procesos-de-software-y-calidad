package p2parking.server;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.Before;
import org.junit.Test;
import p2parking.dao.UsuariosDAO;
import p2parking.jdo.Usuario;


public class MainServerTest {

	MainServer server = new MainServer();

	UsuariosDAO usuariosDAO;
	
	MainServer mainServer;

	Usuario u1;
	
	@Before
	public void setUp() {
		usuariosDAO = org.mockito.Mockito.mock(UsuariosDAO.class);
		
		mainServer = new MainServer();
		mainServer.setUsuarioDAO(usuariosDAO);
		
		u1 = new Usuario("gonzalo", "gonzaloeizaguirre@opendeusto.es", "1234", "ss");
	}

	
	@Test
	public void testLogin() {
		when(usuariosDAO.find("gonzaloeizaguirre@opendeusto.es")).thenReturn(u1);
		List<String> requestBody = new ArrayList<String>();
		requestBody.add("gonzaloeizaguirre@opendeusto.es");
		requestBody.add("1234");
		
		Response response = mainServer.login(requestBody);
		System.out.println(response);	
	}

}