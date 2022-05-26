package p2parking.client.ventanas.funcionalidad;

import javax.swing.JOptionPane;

import p2parking.client.Remote;
import p2parking.client.ventanas.VentanaAdminLogIn;

public class VentanaAdminLogInFuncionalidad {

    public static void botonInicioSesion(VentanaAdminLogIn vent, String password) {
            System.out.println(password);
            if (Remote.getInstance().adminLogin(Remote.constructorRequest(password))) {
                System.out.println("login correcto");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido realizar el inicio de sesion");
            }
        }
}