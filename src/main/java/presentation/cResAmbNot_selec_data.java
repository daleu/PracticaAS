package presentation;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;



public class cResAmbNot_selec_data extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel label1;
    private JTextField textField1;
    private JLabel errorMessageLabel;
    private JSpinner HoraInici;

    private JSpinner HoraFi;

    private JButton buttonCancel;

    private int hi;

    private int hf;

    private String data;

    private crearReservaController c;

    public cResAmbNot_selec_data(crearReservaController ctrl) {
        HoraInici.setValue(-1);

        HoraFi.setValue(-1);

        this.c = ctrl;
        setContentPane(contentPane);
        pack();
        getRootPane().setDefaultButton(buttonOK);
        setResizable(false);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    onOK();
                } catch (ParseException e1) {
                    e1.printStackTrace();
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



        HoraFi.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                hf = (Integer)HoraFi.getValue();
            }
        });
        HoraInici.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                hi = (Integer)HoraInici.getValue();
            }
        });
        textField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                data = textField1.getText();
                label1.setText( textField1.getText());
            }
        });
    }

    private void onOK() throws Exception {
// add your code here

        hi = (Integer)HoraInici.getValue();
        hf = (Integer)HoraFi.getValue();

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date;
        if((data != null) && (hi != -1)  && (hf != -1) ) {
            try {

                date = df.parse(data);
                //get current date time with Date()
                Date dateActual = new Date();
                if (date.compareTo(dateActual) < 0) {
                    errorMessageLabel.setText("data incorrecta");
                } else {
                    if((hi == hf ) || hi < hf ){
                        //llamada a dominio
                        //hi = hi*100 + mi;
                        //hf = hf*100 + mf;
                        java.sql.Date aux = new java.sql.Date(date.getTime());
                        c.OkDate(aux, hi, hf);

                    }
                    else {errorMessageLabel.setText("hores incorrectes");}
                }
            } catch (Exception e) {
               errorMessageLabel.setText(e.getMessage());

            }
        }
        else errorMessageLabel.setText("dades insuficients");




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

    private void onSetHoraInici(){

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
