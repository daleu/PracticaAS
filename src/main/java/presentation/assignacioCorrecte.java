package presentation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class assignacioCorrecte extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private crearReservaController c;

    public assignacioCorrecte(crearReservaController ctrl){
        this.c = ctrl;
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
    }

    private void onOK() {
        c.goinici();
        dispose();
    }

}
