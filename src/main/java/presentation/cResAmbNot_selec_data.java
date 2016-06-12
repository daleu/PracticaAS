package presentation;

import javax.swing.*;
import java.awt.event.*;

public class cResAmbNot_selec_data extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private crearReservaController c;

    public cResAmbNot_selec_data(crearReservaController ctrl) {
        setContentPane(contentPane);
        pack();
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
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
// add your code here
        dispose();
    }

    public void open(){
        this.setVisible(true);
    }

    public void close(){
        this.setVisible(false);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }


}
