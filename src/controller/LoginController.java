package controller;

import model.Conexion;
import model.Usuario;
import view.LoginForm;
import view.PanelPrincipal;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    private Conexion conexion;
    private LoginForm login;

    public LoginController(LoginForm login){
        this.login=login;
        this.conexion= new Conexion();
    }

    //Validar credenciales con la base de datos

    public boolean validarCredenciales() {
        String correo = login.getTxtCorreo();
        String contrasena = new String(login.getTxtPassword());

        if (correo.trim().isEmpty() || contrasena.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo y la contraseña no pueden estar vacíos.", "Error de Entrada", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        String query = "SELECT id, nombre FROM usuarios WHERE correo = ? AND contraseña = ?";
        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, correo);
            ps.setString(2, contrasena);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Usuario encontrado
                return true;
            } else {
                // Usuario no encontrado
                JOptionPane.showMessageDialog(null, "Correo o contraseña incorrectos.", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}



