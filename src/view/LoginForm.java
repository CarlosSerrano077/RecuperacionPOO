package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    JTextField txtCorreo;
    JPasswordField txtPassword;
    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel Panel1;

    private LoginController loginController;

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setContentPane(Panel1);
        setVisible(true);

        loginController = new LoginController(this);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Botón presionado");
                if (loginController.validarCredenciales()) {
                    JOptionPane.showMessageDialog(null, "Usuario ingresó correctamente");
                    new PanelPrincipal();  // mostrar ventana principal
                    dispose();
                }
            }

        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCorreo.setText("");
                txtPassword.setText("");
            }
        });
    }

    //Getter
    public String getTxtCorreo() {
        return txtCorreo.getText();
    }

    public char[] getTxtPassword() {
        return txtPassword.getPassword();
    }
}
