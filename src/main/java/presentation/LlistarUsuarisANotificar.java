package presentation;

import domain.dataTypes.RecursDisponiblesPerData;
import domain.dataTypes.TupleUsers;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class LlistarUsuarisANotificar extends JFrame{
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel labelAux;
    private JTextArea textArea1;
    private crearReservaController c;

    public LlistarUsuarisANotificar(List<TupleUsers> usuarisANotificar, crearReservaController ctrl) {
        this.c = ctrl;
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        String results = new String("<html>");

        for(TupleUsers r: usuarisANotificar){

            results = results + "<br>" + r.getUsername();
            System.out.println(r.getUsername());

        }
        results = results + "</html>";
        labelAux.setText(results);

        pack();
        setResizable(false);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });



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

        setVisible(true);
    }

    private void onOK() throws Exception {
        String aux = (textArea1.getText());
        c.assignarUsuarisAReserva(aux);
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

}
