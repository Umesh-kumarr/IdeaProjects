package GymManagementSystem;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class UpdateDeleteMember extends JFrame implements ActionListener {

    JTextField nameTextField , mnoTextField , fnameTextField , mnameTextField,emTextField ,adhaarTextField,
            ageTextField ,amountTextField , memberidTextField , gtimeTextField , genderTextField;

    JComboBox amt , amt1;
    JButton update  , delete , reset , search;

    UpdateDeleteMember(){
        setLayout(null);
        JFrame jf = new JFrame();
        jf.setSize(1650,1080);
        setSize(1650,1080);
//        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.getHSBColor(242,3532,1442));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\close.png"));
        Image i2 = i1.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10,10,70,30);
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new Welcome().setVisible(true);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\update & delete member.png"));
        Image i5 = i4.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label1 = new JLabel(i6);
        label1.setBounds(820,10,90,90);

        JLabel nm = new JLabel("Update & Delete Member");
        nm.setBounds(900, 30,700,70);
        nm.setFont(new Font("RALEWAY" , Font.BOLD , 50));
        add(nm);

        JLabel Mid = new JLabel("Member Id :");
        Mid.setBounds(100, 120,600,90);
        Mid.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(Mid);

        memberidTextField = new JTextField();
        memberidTextField.setBounds(250,155,70,23);
        memberidTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(memberidTextField);

        search = new JButton("Search");
        search.setBounds(355, 150,100,30);
        search.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        add(search);
        setVisible(true);
        search.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int checkid = 0 ;
                String id = memberidTextField.getText();
                GymDBConnection cb = new GymDBConnection();
                String query = ("select * from member where id = '"+ id +"'");


                try{

                    PreparedStatement ps = cb.conn.prepareStatement(query);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()){
                        checkid = 1;
                        memberidTextField.setEditable(false);
                        nameTextField.setText(rs.getString(2));
                        mnoTextField.setText(rs.getString(3));
                        emTextField.setText(rs.getString(4));
                        genderTextField.setText(rs.getString(5));
                        genderTextField.setEditable(false);
                        fnameTextField.setText(rs.getString(6));
                        mnameTextField.setText(rs.getString(7));
                        gtimeTextField.setText(rs.getString(8));
                        gtimeTextField.setEditable(false);
                        adhaarTextField.setText(rs.getString(9));
                        ageTextField.setText(rs.getString(10));
                        amountTextField.setText(rs.getString(11));
                    }
                    if(checkid==0){
                        JOptionPane.showMessageDialog(null , "Message Id Doesnt Exist", "Select" , YES_NO_OPTION);
                    }


                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });

//
        JLabel name = new JLabel("Name");
        name.setBounds(100, 200,600,90);
        name.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(name);
        nameTextField = new JTextField();
        nameTextField.setBounds(100,270,300,23);
        nameTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(nameTextField);

        JLabel mno = new JLabel("Mobile No");
        mno.setBounds(100, 290,600,90);
        mno.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(mno);
        mnoTextField = new JTextField();
        mnoTextField.setBounds(100,360,300,23);
        mnoTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(mnoTextField);

        JLabel email = new JLabel("E-Mail");
        email.setBounds(100, 380,600,90);
        email.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(email);
        emTextField = new JTextField();
        emTextField.setBounds(100,450,300,23);
        emTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(emTextField);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(100, 470,600,90);
        gender.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(gender);

        genderTextField = new JTextField();
        genderTextField.setBounds(100,540,300,23);
        genderTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(genderTextField);

        JLabel fname = new JLabel("Father Name");
        fname.setBounds(100, 560,600,90);
        fname.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(fname);
        fnameTextField = new JTextField();
        fnameTextField.setBounds(100,630,300,23);
        fnameTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(fnameTextField);

        JLabel mname = new JLabel("Mother Name");
        mname.setBounds(900, 200,600,90);
        mname.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(mname);
        mnameTextField = new JTextField();
        mnameTextField.setBounds(900,270,300,23);
        mnameTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(mnameTextField);

        JLabel gymtime = new JLabel("Gym Time");
        gymtime.setBounds(900, 290,600,90);
        gymtime.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(gymtime);
        gtimeTextField = new JTextField();
        gtimeTextField.setBounds(900,360,300,23);
        gtimeTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(gtimeTextField);



        JLabel adhaar = new JLabel("Addhaar No Unique Id");
        adhaar.setBounds(900, 380,600,90);
        adhaar.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(adhaar);
        adhaarTextField = new JTextField();
        adhaarTextField.setBounds(900,450,300,23);
        adhaarTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(adhaarTextField);

        JLabel age = new JLabel("Age");
        age.setBounds(900, 470,600,90);
        age.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(age);
        ageTextField = new JTextField();
        ageTextField.setBounds(900,540,300,23);
        ageTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(ageTextField);

        JLabel amount = new JLabel("Amount To Pay/Months");
        amount.setBounds(900, 560,600,95);
        amount.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(amount);
        amountTextField = new JTextField();
        amountTextField.setBounds(900,630,300,23);
        amountTextField.setFont(new Font("RALEWAY",Font.BOLD , 17));
        add(amountTextField);


        update = new JButton("Update");
        update.setBounds(350, 700,100,30);
        update.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        add(update);
        setVisible(true);


        delete= new JButton("Delete");
        delete.setBounds(550, 700,100,30);
        delete.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        add(delete);
        setVisible(true);

        reset = new JButton("Reset");
        reset.setBounds(750, 700,100,30);
        reset.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        add(reset);
        setVisible(true);
        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new UpdateDeleteMember().setVisible(true);
            }
        });



        add(label);
        add(label1);
    }

    public static void main(String[] args) {
        new UpdateDeleteMember();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
