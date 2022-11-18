package uasprakpbo;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {

    User user;
    boolean loginStat = false;

    public void tryLogin(String userName, String userPassword) {
        DatabaseHandler con = new DatabaseHandler();
        con.connect();
        try {
            java.sql.Statement stat = con.con.createStatement();
            ResultSet result = stat.executeQuery("select * from user where userName='" + userName + "'");
            if (result.next()) {
                if (userPassword.equals(result.getString("userPassword"))) {
                    loginStat = true;
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                } else {
                    JOptionPane.showMessageDialog(null, "Password yang anda masukkan salah!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "username tidak terdaftar!!");
            }
        } catch (SQLException ae) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan, Login Gagal!!");
        }
    }

    public Login() {
        try {
            Font txt = new Font("Serif", Font.PLAIN, 18);

            JFrame frame = new JFrame("Log In");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 350);

            BufferedImage foto = ImageIO.read(new File("D:\\FOTO\\paaaa.jpg"));
            Image fixedFoto = foto.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            JLabel photos = new JLabel(new ImageIcon(fixedFoto));
            photos.setBounds(200, 50, 100, 100);

            JLabel usernameLabel = new JLabel("Username :");
            usernameLabel.setBounds(50, 150, 100, 30);
            usernameLabel.setFont(txt);

            JTextField username = new JTextField();
            username.setBounds(150, 150, 300, 30);
            username.setFont(txt);

            JLabel passLabel = new JLabel("Password :");
            passLabel.setBounds(50, 200, 100, 30);
            passLabel.setFont(txt);

            JPasswordField password = new JPasswordField();
            password.setBounds(150, 200, 300, 30);
            password.setFont(txt);

            JButton backBtn = new JButton("Back");
            backBtn.setBounds(0, 0, 80, 30);
            backBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    new MenuUtama();
                }
            });
            JButton logBtn = new JButton("Login");
            logBtn.setBounds(200, 300, 100, 50);
            logBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tryLogin(user.getUserName(), user.getUserPassword());
                    if (loginStat) {
                        frame.dispose();
                        new LihatData();
                    }
                }
            });

            frame.add(photos);
            frame.add(usernameLabel);
            frame.add(username);
            frame.add(passLabel);
            frame.add(password);
            frame.add(logBtn);
            frame.add(backBtn);
            frame.setLayout(null);
            frame.setVisible(true);

        } catch (IOException ae) {
            JOptionPane.showMessageDialog(null, "Eror!");
        }

    }
}
