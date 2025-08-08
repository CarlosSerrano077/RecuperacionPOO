package view;

import controller.UsuarioController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarForm extends JFrame{
    JPanel PanelEliminar;
    private JTextField txtId;
    private JButton btnEliminar;
    private JButton btnSalir;
    private PanelPrincipal panelPrincipal;

    public EliminarForm() {

        this.panelPrincipal =  panelPrincipal;

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                UsuarioController uc = new UsuarioController();

                int confirm = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    if (uc.eliminarUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado.");
                        panelPrincipal.cargarUsuarios();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar usuario.");
                    }
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainframe4 = new JFrame("Principal");
                mainframe4.setContentPane(new PanelPrincipal().PanelPrincipal);
                mainframe4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe4.setSize(600, 600);
                mainframe4.setLocationRelativeTo(null);
                mainframe4.setVisible(true);
                dispose();
                SwingUtilities.getWindowAncestor(PanelEliminar).dispose();
            }
        });
    }
}
