package uasprakpbo;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class LihatData {
    public ArrayList<CategoryUser> getCategoryList() {
        ArrayList<CategoryUser> temp = new ArrayList<>();
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from categoryuser");
            while (result.next()) {
                int tempID = result.getInt("id");
                String tempUsername= result.getString("username");
                CategoryUser category = new CategoryUser(tempID, tempUsername);
                temp.add(category);
            }
        } catch (SQLException e) {

        }
        conn.disconnect();
        return temp;
    }
    
    public LihatData(){

        Font font = new Font("Serif", Font.PLAIN, 16);

   
        JFrame frame = new JFrame("Data Pengguna");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        
  
        ArrayList<CategoryUser> listCategory = getCategoryList();
        String[] listCat = new String[listCategory.size()];
        for (int i = 0; i < listCat.length; i++) {
            listCat[i] = listCategory.get(i).getCategoryName();
        }
        JComboBox category = new JComboBox(listCat);
        category.setBounds(25, 100, 150, 30);
        category.setFont(font);
        
        JButton tampilkan = new JButton("Tampilkan");
        tampilkan.setBounds(175, 100, 100, 30);
        tampilkan.setFont(font);
        tampilkan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Tabel();
            }
        });
        JButton backBtn = new JButton("Back");
        backBtn.setBounds(0, 0, 80, 30);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
                new MenuUtama();
            }
        });
        frame.add(category);
        frame.add(tampilkan);
        frame.add(backBtn);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}