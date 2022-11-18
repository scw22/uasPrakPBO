package uasprakpbo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuUtama {

    public MenuUtama() { 
        JFrame frame = new JFrame("Menu Utama");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 350);

        JButton logBtn = new JButton("Login");
        logBtn.setBounds(150, 50, 200, 50);
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                try {
                    new Login();
                } catch (IOException ex) {
                    Logger.getLogger(MenuUtama.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton regBtn = new JButton("Registrasi Pengguna Baru");
        regBtn.setBounds(150, 120, 200, 50);
        regBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new Registrasi();
            }
        });
        JButton lihatBtn = new JButton("Lihat Data Pengguna Baru Berdasarkan Kategori");
        lihatBtn.setBounds(50, 195, 400, 50);
        lihatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new LihatData();
            }
        });
        frame.add(logBtn);
        frame.add(regBtn);
        frame.add(lihatBtn);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}