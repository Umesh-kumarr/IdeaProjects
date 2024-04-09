package GymManagementSystem;

import AWT.ExampleApplicationForm.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.util.Random;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class NewMember extends JFrame implements ActionListener {

    JTextField nameTextField , mnoTextField , fnameTextField , mnameTextField,emTextField ,adhaarTextField,
    ageTextField ,amountTextField ;

    int random;

    JComboBox amt , amt1;

    JRadioButton male , female , other , a ,b ,c;

    JButton save , reset;

    NewMember(){

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

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\new member.png"));
        Image i5 = i4.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label1 = new JLabel(i6);
        label1.setBounds(1000,10,90,80);

        JLabel nm = new JLabel("New Member");
        nm.setBounds(1090, 30,500,40);
        nm.setFont(new Font("RALEWAY" , Font.BOLD , 50));
        add(nm);

        Random ran = new Random();
        random = Math.abs(ran.nextInt() % 900 + 1);

        JLabel Mid = new JLabel("Member Id :" + random);
        Mid.setBounds(100, 120,600,90);
        Mid.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(Mid);


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


        JLabel gender1 = new JLabel("Gender:");
        gender1.setBounds(100, 470,600,90);
        gender1.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(gender1);

        male = new JRadioButton("Male");
        male.setBounds(100 , 540 ,100 , 30);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(200 , 540 ,100 , 30);
        add(female);

        other = new JRadioButton("Other");
        other.setBounds(300 , 540 ,100 , 30);
        add(other);

        ButtonGroup gender = new ButtonGroup();
        gender.add(male);
        gender.add(female);
        gender.add(other);

//        String[] str = {"Male" , "Female" ,  "Other"};
//        amt = new JComboBox<>(str);
//        amt.getAlignmentX();
//        amt.setBounds(100 , 540 , 300 , 30);
//        amt.setFont(new Font("RALEWAY" , Font.BOLD , 17));
//        add(amt);

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

        a = new JRadioButton("8Am-10Am");
        a.setBounds(900 , 360 ,100 , 30);
        add(a);

        b = new JRadioButton("10Am-12Am");
        b.setBounds(1000 , 360 ,100 , 30);
        add(b);

        c = new JRadioButton("12Am-2Pm");
        c.setBounds(1100 , 360 ,100 , 30);
        add(c);

        ButtonGroup time = new ButtonGroup();
        time.add(a);
        time.add(b);
        time.add(c);
//        String[] str1 = {"8:00Am - 10:00Am" , "10:00Am - 12:00Am" ,  "12:00Am - 2:00Pm"};
//        amt1 = new JComboBox<>(str1);
//        amt1.getAlignmentX();
//        amt1.setBounds(900 , 360 , 300 , 30);
//        amt1.setFont(new Font("RALEWAY" , Font.BOLD , 17));
//        add(amt1);


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


        save = new JButton("Save");
        save.setBounds(550, 700,100,30);
        save.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        save.addActionListener(this);
        add(save);
        setVisible(true);

        reset = new JButton("Reset");
        reset.setBounds(750, 700,100,30);
        reset.setFont(new Font("RALEWAY" , Font.BOLD, 15));
        add(reset);
        setVisible(true);



        add(label);
        add(label1);

    }

    public static void main(String[] args) {
        new NewMember();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sformno = "" + random;
        String sname = nameTextField.getText();
        String smn = mnoTextField.getText();
        String semail = emTextField.getText();

        String sgender = null;
        if(male.isSelected()){
            sgender = "male";
        } else if (female.isSelected()) {
            sgender = "female";
        }else if (other.isSelected()) {
            sgender = "others";
        }


        String sfname = fnameTextField.getText();
        String smname = mnameTextField.getText();
        String stime = null;
        if(a.isSelected()){
            stime = "8Am-10Am";
        } else if (b.isSelected()) {
            stime = "10Am-12Am";
        }else if (c.isSelected()) {
            stime = "12Am-2Pm";
        }

        String saddharno = adhaarTextField.getText();
        String sage = ageTextField.getText();
        String samount = amountTextField.getText();



        if(sname.equals("")){
            JOptionPane.showMessageDialog(null , "Name is Empty");
        }

        GymDBConnection cb = new GymDBConnection();
        String query = ("INSERT INTO Member VALUES( '"+sformno+"' ,'"+sname+"' , '"+smn+"' , '"+semail+"' ,'"+sgender+"' , '"+sfname+"' , '"+smname+"' , '"+stime+"' , '"+saddharno+"' , '"+sage+"' ,'"+samount+"'  )");


        try{
            PreparedStatement ps = cb.conn.prepareStatement(query);
            ps.executeUpdate();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

    }
}
