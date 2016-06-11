package presentation;

import javax.swing.*;
import java.awt.event.*;



public class menuPrincipal extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JComboBox comboBox1;
    private JButton buttonCancel;
    private crearReservaController c;

    public menuPrincipal(crearReservaController ctrl) {
        this.c = ctrl;
        setContentPane(contentPane);
        //setModal(true);
        pack();
        setResizable(false);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        setVisible(true);


// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        String selection = String.valueOf(comboBox1.getSelectedItem());
        if (selection == "Crear reserva amb notificació"){
            c.iniciarFuncionalitat();
        }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void close() {
// add your code here if necessary
        this.setVisible(false);
    }

    public void open() {
// add your code here if necessary
        this.setVisible(true);
    }



}
