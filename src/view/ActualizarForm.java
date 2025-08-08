package view;

import controller.UsuarioController;
import model.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarForm extends JFrame{
    JPanel PanelActualizar;
    private JTextField txtId;
    private JTextField txtUsuario;
    private JTextField txtCorreo;
    private JButton btnActualizar;
    private JButton btnSalir;
    private PanelPrincipal panelPrincipal;

    public ActualizarForm() {

        this.panelPrincipal = panelPrincipal;

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String usuario = txtUsuario.getText();
                String correo = txtCorreo.getText();

                Usuario user = new Usuario(id, usuario, correo);
                UsuarioController uc = new UsuarioController();

                if (uc.actualizarUsuario(user)) {
                    JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
                    panelPrincipal.cargarUsuarios();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el usuario.");
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainframe = new JFrame("Principal");
                mainframe.setContentPane(new PanelPrincipal().PanelPrincipal);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setSize(600, 600);
                mainframe.setLocationRelativeTo(null);
                mainframe.setVisible(true);
                dispose();
                SwingUtilities.getWindowAncestor(PanelActualizar).dispose();
            }
        });
    }
}
