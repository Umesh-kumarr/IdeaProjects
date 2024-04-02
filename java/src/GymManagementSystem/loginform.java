package GymManagementSystem;

import StudentManagementSystem.StudentDBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginform extends JFrame implements ActionListener {

    JTextField usernameTextField , pinTextField;
    JButton login;
    public void loginfo() {
        JFrame frame = new JFrame();

        setLayout(null);
        setSize(780,580);
       setLocation(350, 120);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

//        getContentPane().setBackground(Color.getHSBColor(242,2432,2442));



        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\login background.PNG"));
        Image i5 = i4.getImage().getScaledInstance(780,540, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label1 = new JLabel(i6);
        label1.setBounds(0,0,780,540);

        JLabel name = new JLabel("Login");
        name.setBounds(480, 100,600,90);
        name.setFont(new Font("RALEWAY" , Font.BOLD , 50));
        add(name);
        usernameTextField = new JTextField();
        usernameTextField.setBounds(400,215,300,30);
        usernameTextField.setFont(new Font("RALEWAY",Font.BOLD , 20));
        add(usernameTextField);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(400,285,300,30);
        pinTextField.setFont(new Font("RALEWAY",Font.BOLD , 20));
        add(pinTextField);

        JLabel warning = new JLabel();
        warning.setForeground(Color.RED);
        warning.setBounds(625, 450, 250, 20);
        warning.setHorizontalAlignment(warning.CENTER);
        frame.add(warning);

        login = new JButton("Login");
        login.setBounds(450, 350,100,30);
        login.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        login.addActionListener(this);
        add(login);
        setVisible(true);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = 0;
                try {
                    res = dbCheck(usernameTextField.getText(), pinTextField.getText());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(res == 0) {
                    warning.setText("NO USER FOUND!!!");
                    usernameTextField.setText("");
                    pinTextField.setText("");
                }
                else if(res == -1) {
                    warning.setText("WRONG PASSWORD!!!");
                    usernameTextField.setText("");
                    pinTextField.setText("");
                }
                else {
                    setVisible(false);
                    new loginform().setVisible(true);
                }
            }

            private int dbCheck(String username, String password) throws SQLException {
                GymDBConnection ss = new GymDBConnection();

                PreparedStatement ps = ss.conn.prepareStatement("select * from GymLogin where username = ? AND password = ?");
                ps.setString(1 ,username);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    new Welcome().setVisible(true);
                    return 1;
                }
                else{
                    return 0;
                }
            }
        });





        add(label1);


}


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}






