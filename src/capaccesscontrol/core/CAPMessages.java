/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Edwin Carmona
 */
public class CAPMessages extends Thread {
    
    private static final int TIME_VISIBLE = 1000;
    
    @Override
    public void run() {
        JOptionPane pane = new JOptionPane("Message", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "Title");
        dialog.setModal(false);
        dialog.setVisible(true);

        new Timer(TIME_VISIBLE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
            }
        }).start();
    }
}
