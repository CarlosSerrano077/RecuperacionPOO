package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm {
    private JTextField txtID;
    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JButton btnRegistrar;
    private JButton btnSalir;
    private JButton btnLimpiar;
    JPanel PanelRegistro;

    public RegisterForm() {
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtID.setText("");
                txtUsuario.setText("");
                txtCorreo.setText("");
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainframe = new JFrame("Login");
                mainframe.setContentPane(new LoginForm().Panel1);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setSize(400, 450);
                mainframe.setLocationRelativeTo(null);
                mainframe.setVisible(true);
                SwingUtilities.getWindowAncestor(PanelRegistro).dispose();
            }
        });
    }
}
