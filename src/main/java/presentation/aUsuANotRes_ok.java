package presentation;

import javax.swing.*;
import java.awt.event.*;

/**
 * Created by Usuario on 13/06/2016.
 */
public class aUsuANotRes_ok extends JFrame{
    private JButton OKButton;
    private JButton cancelLarButton;
    private JLabel nomRecurs;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel contentPane;
    private crearReservaController c;

    public aUsuANotRes_ok(crearReservaController ctrl, String nom) {
        this.c = ctrl;
        setContentPane(contentPane);
        nomRecurs.setText(nom);
        //setModal(true);
        pack();
        setResizable(false);
        getRootPane().setDefaultButton(OKButton);
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        setVisible(true);

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() throws Exception {
        String nomrecurs = String.valueOf(nomRecurs.getText());
        String username = String.valueOf(textField1.getText());
        String comentari = String.valueOf(textField2.getText());
        c.crearReserva(nomrecurs,username,comentari);
    }

    private void onCancel() {
        dispose();
    }
}
