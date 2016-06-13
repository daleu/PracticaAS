package presentation;

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
    private JList list1;
    private crearReservaController c;

    public LlistarUsuarisANotificar(List<TupleUsers> usuarisANotificar) {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

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
    }

    private void onOK() throws Exception {
        //Assignar usuaris
        List<String> usernames = new ArrayList<String>();
        c.assignarUsuaris(usernames);
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

}
