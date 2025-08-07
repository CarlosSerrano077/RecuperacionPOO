package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    JTextField txtCorreo;
    JPasswordField txtPassword;
    JButton btnIngresar;
    JButton btnLimpiar;
    JPanel Panel1;

    public LoginForm() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);
        setContentPane(Panel1);
        setVisible(true);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = String.valueOf(txtPassword.getPassword());
                if (txtCorreo.getText().isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Campos Vacios");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Usuario ingresó correctamente");
                    JFrame frame = new JFrame("Principal");
                    frame.setContentPane(new PanelPrincipal().PanelPrincipal);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(600,400);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    dispose();
                    SwingUtilities.getWindowAncestor(Panel1).dispose();
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
}
