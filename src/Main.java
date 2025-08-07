import model.Conexion;
import view.LoginForm;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        new LoginForm().setVisible(true);
        new Conexion();
    }
}