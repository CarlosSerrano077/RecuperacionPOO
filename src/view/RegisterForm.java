package view;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterForm extends JFrame{
    private JTextField txtID;
    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JButton btnRegistrar;
    private JButton btnSalir;
    private JButton btnLimpiar;
    JPanel PanelRegistro;
    private PanelPrincipal panelPrincipal;

    public RegisterForm() {

        this.panelPrincipal = panelPrincipal;

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id =  Integer.parseInt(txtID.getText());
                String nombre = txtUsuario.getText();
                String correo = txtCorreo.getText();

                Usuario usuario = new Usuario(id, nombre, correo);
                UsuarioController uc = new UsuarioController();

                if(nombre.isEmpty() || correo.isEmpty() ){
                    JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.");
                }
                else if (uc.insertarUsuario(usuario)) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente.");
                    panelPrincipal.cargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar usuario.");
                }
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
                JFrame mainframe2 = new JFrame("Principal");
                mainframe2.setContentPane(new PanelPrincipal().PanelPrincipal);
                mainframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe2.setSize(600, 600);
                mainframe2.setLocationRelativeTo(null);
                mainframe2.setVisible(true);
                dispose();
                SwingUtilities.getWindowAncestor(PanelRegistro).dispose();
            }
        });
    }
}
