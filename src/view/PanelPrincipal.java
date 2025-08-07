package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JFrame{
    JPanel PanelPrincipal;
    private JTable table1;
    private JButton btnRegistrar;
    private JButton btnSalir;
    private JButton btnEliminar;
    private JButton btnActualizar;

    public PanelPrincipal(){
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setContentPane(PanelPrincipal);
        setVisible(true);

        btnRegistrar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame1 = new JFrame("Registrar");
                frame1.setContentPane(new RegisterForm().PanelRegistro);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(400, 400);
                frame1.setLocationRelativeTo(null);
                frame1.setVisible(true);
                SwingUtilities.getWindowAncestor(PanelPrincipal).dispose();
            }
        });
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                SwingUtilities.getWindowAncestor(PanelPrincipal).dispose();
            }
        });
    }
}
