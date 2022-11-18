package uasprakpbo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registrasi {
    User user;
    CategoryUser catUser;
    String pathFoto;
    JLabel labelFoto;

    public ArrayList<CategoryUser> getCategoryList() {
        ArrayList<CategoryUser> tempUser = new ArrayList();
        DatabaseHandler con = new DatabaseHandler();
        con.connect();
        try {
            java.sql.Statement stat = con.con.createStatement();
            ResultSet result = stat.executeQuery("select * from categoryuser");
            while (result.next()) {
                int ID_1 = result.getInt("id");
                String tempUsername = result.getString("Username");
                CategoryUser category = new CategoryUser(ID_1, tempUsername);
                tempUser.add(category);
            }
        } catch (SQLException e) {

        }
        con.disconnect();
        return tempUser;
    }

    public void insertData(String userName, String userEmail, String userPassword, String userGender, String userCategory, int userFollowers) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            PreparedStatement stat = conn.con.prepareStatement("INSERT INTO user(userName,userEmail,userPassword,userGender,userCategory, userFollowers) VALUES(?,?,?,?,?,?)");
            stat.setString(1, userName);
            stat.setString(2, userEmail);
            stat.setString(3, userPassword);
            int tempUser = 0;
            if (catUser.equals("Private Account")) {
                tempUser = 1;
            } else if (catUser.equals("Creator Account")) {
                tempUser = 2;
            } else {
                tempUser = 3;
            }
            stat.setInt(4, tempUser);
            stat.setString(5, pathFoto);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil melakukan registrasi");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error!! Gagal melakukan registrasi");
        }
        conn.disconnect();
    }

    public Registrasi() {

        Font font = new Font("Serif", Font.PLAIN, 16);

        JFrame frame = new JFrame("Registrasi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JLabel registrasi = new JLabel("Registrasi");
        registrasi.setBounds(175, 50, 150, 30);
        registrasi.setFont(new Font("Serif", Font.BOLD, 24));

        JLabel lblNama = new JLabel("Email :");
        lblNama.setBounds(50, 100, 100, 40);
        lblNama.setFont(font);

        JTextField nama = new JTextField();
        nama.setBounds(150, 100, 300, 30);
        nama.setFont(font);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(50, 150, 100, 40);
        lblEmail.setFont(font);

        JTextField email = new JTextField();
        email.setBounds(150, 150, 300, 30);
        email.setFont(font);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setBounds(50, 200, 100, 30);
        lblPassword.setFont(font);

        JPasswordField password = new JPasswordField();
        password.setBounds(150, 200, 300, 30);
        password.setFont(font);
        
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin");
        labelJenisKelamin.setBounds(50, 150, 150, 30);
        labelJenisKelamin.setFont(font);
        
        JLabel lblCategory = new JLabel("Category :");
        lblCategory.setBounds(50, 300, 100, 30);
        lblCategory.setFont(font);

        ArrayList<CategoryUser> listCategory = getCategoryList();
        String[] listCat = new String[listCategory.size()];
        for (int i = 0; i < listCat.length; i++) {
            listCat[i] = listCategory.get(i).getCategoryName();
        }
        JComboBox category = new JComboBox(listCat);
        category.setBounds(150, 300, 300, 30);
        category.setFont(font);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(0, 0, 80, 30);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuUtama();
            }
        });

        JButton regisBtn = new JButton("Registrasi");
        regisBtn.setBounds(200, 350, 100, 50);
        regisBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertData(user.getUserName(), user.getUserEmail(), user.getUserPassword(), user.getUserGender(), (String) category.getSelectedItem(), user.getUserFollowers());
                frame.dispose();
                new MenuUtama();
            }
        });

        frame.add(registrasi);
        frame.add(lblNama);
        frame.add(nama);
        frame.add(lblEmail);
        frame.add(email);
        frame.add(lblPassword);
        frame.add(password);
        frame.add(lblCategory);
        frame.add(category);
        frame.add(backBtn);
        frame.add(regisBtn);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}


