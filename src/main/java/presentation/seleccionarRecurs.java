package presentation;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by aleue on 13/6/2016.
 */
public class seleccionarRecurs extends JFrame {
    //private JList list1;
    private JButton OKButton;
    private JButton cancelarButton;
    private JPanel contentPane;
    private JScrollPane listScroller;
    private JLabel labelAux;
    private JTextField textField1;
    private JPanel scrollPanel;
    private JButton testButton;
    private DefaultListModel lmodel = new DefaultListModel();
    private crearReservaController c;



    public seleccionarRecurs(crearReservaController ctrl, List<RecursDisponiblesPerData> aux){
        this.c = ctrl;
        String results = new String("<html>");
        String newline = System.getProperty("line.separator");
        for(RecursDisponiblesPerData r: aux){

            lmodel.addElement(r.nom);
            results = results + "<br>" + r.nom;
            System.out.println(r.nom);

        }
        results = results + "</html>";
        labelAux.setText(results);
        //list1.setModel(lmodel);



        //list1 = new JList(lmodel);
        //System.out.println(list1.getModel().getElementAt(1));
        //list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        //list1.setVisibleRowCount(-1);


        //listScroller = new JScrollPane(list1);
        //listScroller.setPreferredSize(new Dimension(250, 80));
        //listScroller.setViewportView(list1);

        setVisible(true);
        //list1.setVisible(true);
        listScroller.setVisible(true);
        /*list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

            }
        });*/

        setContentPane(contentPane);
        pack();
        getRootPane().setDefaultButton(OKButton);
        getRootPane().setDefaultButton(OKButton);
        setResizable(false);
        OKButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });


        this.invalidate();
        this.validate();
        this.repaint();
    }

    private void onCancel() {
        dispose();
    }

    private void onOK() {

       String nom_intro = textField1.getText();
        c.introNomUsuari(nom_intro);
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

//            if (list1.getSelectedIndex() == -1) {
//                //No selection, disable fire button.
//                fireButton.setEnabled(false);
//
//            } else {
//                //Selection, enable the fire button.
//                fireButton.setEnabled(true);
//            }
        }
    }
}
