/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author user
 */
public class MainMenu {
    public static void main(String[] args) {
        new MainMenu();
    }
    
    public MainMenu(){
        Font font1 = new Font("Serif", Font.BOLD, 20);
        
        JFrame frame = new JFrame("Login");
        frame.setSize(600, 310);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel judul = new JLabel("Login");
        judul.setBounds(230, 10, 400, 60);
        judul.setFont(new Font("Serif", Font.BOLD, 45));
        
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30, 100, 200, 30);
        usernameLabel.setFont(font1);
        
        JTextField user = new JTextField();
        user.setBounds(150, 100, 300, 30);
        user.setFont(font1);
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(30, 150, 200, 30);
        passwordLabel.setFont(font1);
        
        JTextField password = new JTextField();
        password.setBounds(150, 150, 300, 30);
        password.setFont(font1);
        
        JButton login = new JButton("LOGIN");
        login.setBounds(235, 210, 100, 30);
        login.setFont(new Font("Serif", Font.PLAIN, 20));
                
        frame.add(judul);
        frame.add(usernameLabel);
        frame.add(user);
        frame.add(passwordLabel);
        frame.add(password);
        frame.add(login);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
