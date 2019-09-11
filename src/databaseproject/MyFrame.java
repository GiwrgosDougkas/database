/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author George
*/

public class MyFrame extends JFrame{
    private JPanel panel;
    public JTextField id,name,lastname;
    private JLabel id1,name1,lastname1;
    private JButton button;
    private Connection con=null;
   
    public MyFrame(){
         
         con= Connector.start();
        panel=new JPanel();
        
        id=new JTextField(20);        
        id1=new JLabel("Id");
        
        name=new JTextField(20);        
        name1=new JLabel("First Name");
        
        lastname=new JTextField(20);        
        lastname1=new JLabel("Last Name");
        
        button=new JButton("Insert");
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        panel.add(id1);
        panel.add(id);
        panel.add(name1);
        panel.add(name);
        panel.add(lastname1);
        panel.add(lastname);
        panel.add(button);
        
       
        
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(300, 200);
        
        this.setTitle("Inset to database");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel);
         ButtonListener listenr=new ButtonListener();
        button.addActionListener(listenr);
    } 
    
    
    
    
  class ButtonListener implements ActionListener {
    
    
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
     try {
     
        
        String aem=id.getText();
        String first=name.getText();
        String last=lastname.getText();
        String sql = "INSERT INTO Students " +
                   "VALUES ('"+aem+"', '"+first+"', '"+last+"')";
        
            Statement stm=con.createStatement();
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}  
    
    
    
    public JTextField getId(){
        return this.id;
    }
    public JTextField getFirst(){
        return this.name;
    }
    
    public JTextField getLast(){
        return this.lastname;
    }
        
}
