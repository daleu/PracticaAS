package presentation;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by aleue on 13/6/2016.
 */
public class seleccionarRecurs extends JFrame {
    private JList list1;
    private JButton OKButton;
    private JButton cancelarButton;
    private JPanel contentPane;
    private JScrollPane listScroller;
    private JPanel scrollPanel;
    private JButton testButton;
    private DefaultListModel lmodel = new DefaultListModel();



    public seleccionarRecurs(crearReservaController ctrl, List<RecursDisponiblesPerData> aux){

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
        String	listData[] =
                {
                        "Item 1",
                        "Item 2",
                        "Item 3",
                        "Item 4"
                };

        lmodel.addElement("Item1");
        lmodel.addElement("Item2");

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.anchor = GridBagConstraints.CENTER;
        constraint.fill = GridBagConstraints.NONE;
        constraint.gridx = 0;
        constraint.gridy = GridBagConstraints.RELATIVE;
        constraint.weightx = 1.0f;
        constraint.weighty = 1.0f;

        for (RecursDisponiblesPerData r: aux){
            System.out.println("-----------------------------");
            JButton button = new JButton();
            button.setText(r.nom);
            //scrollPanel.add(button, constraint);
            //scrollPanel.add(button);
        }

        list1 = new JList(lmodel);
        System.out.println(list1.getModel().getElementAt(1));
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list1.setVisibleRowCount(-1);



        JScrollPane listScroller = new JScrollPane(list1);
        listScroller.setPreferredSize(new Dimension(250, 80));

        setVisible(true);
        list1.setVisible(true);
        System.out.println(aux);
        /*list1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

            }
        });*/
    }

    private void onCancel() {
        dispose();
    }

    private void onOK() {

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
