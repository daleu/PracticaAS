package presentation;

import domain.dataTypes.RecursDisponiblesPerData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by usuario on 13/06/2016.
 */
public class recursNotificacioCreat_Continuar extends  JFrame{
    private JPanel panel1;
    private JButton noButton1;
    private JButton siButton;
    private crearReservaController c;

    public recursNotificacioCreat_Continuar(crearReservaController ctrl){
        this.c = ctrl;
        setContentPane(panel1);
        pack();
        getRootPane().setDefaultButton(siButton);
        getRootPane().setDefaultButton(siButton);
        setResizable(false);
        siButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        noButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onCancel();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);
    }

    private void onCancel() throws Exception {
        c.noAssignarUsuaris();
    }

    private void onOK() throws Exception {
        c.assignarUsuaris();
    }
}
