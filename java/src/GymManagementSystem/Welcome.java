package GymManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static javax.swing.JOptionPane.YES_NO_OPTION;

public class Welcome extends JFrame implements MouseListener {


    Welcome(){
        setLayout(null);
        JFrame jf = new JFrame();
        jf.setSize(1650,1080);
        setSize(1650,1080);
//        setLocation(350, 10);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.getHSBColor(242,2432,2442));


        JLabel name = new JLabel("WELCOME!");
        name.setBounds(630, 240,600,90);
        name.setFont(new Font("ALGERIAN" , Font.BOLD , 50));
        add(name);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\new member.png"));
        Image i2 = i1.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(10,10,70,60);

        JLabel nm = new JLabel("New Member");
        nm.setBounds(80, 20,200,40);
        nm.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(nm);
        nm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new NewMember().setVisible(true);
            }
        });


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\update & delete member.png"));
        Image i5 = i4.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label1 = new JLabel(i6);
        label1.setBounds(220,10,70,60);

        JLabel text = new JLabel("Update & Delete Member");
        text.setBounds(280, 20,250,40);
        text.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(text);
        text.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new UpdateDeleteMember().setVisible(true);
            }
        });


        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\list of members.png"));
        Image i8 = i7.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel label2 = new JLabel(i9);
        label2.setBounds(530,10,70,60);

        JLabel lom = new JLabel("List of Member");
        lom.setBounds(590, 20,200,40);
        lom.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(lom);
        lom.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ListOfMembers().setVisible(true);
            }
        });
//

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\payment.png"));
        Image i11 = i10.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel label3 = new JLabel(i12);
        label3.setBounds(760,10,70,60);

        JLabel pay = new JLabel("Payment");
        pay.setBounds(840, 20,200,40);
        pay.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(pay);


        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\logout.png"));
        Image i14 = i13.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel label4 = new JLabel(i15);
        label4.setBounds(960,10,70,60);

        JLabel logout = new JLabel("Log Out");
        logout.setBounds(1030, 20,200,40);
        logout.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(logout);
        logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                  JOptionPane.showMessageDialog(null , "Do you really want to logout", "Select" , YES_NO_OPTION);
                if ( JOptionPane.YES_OPTION==0) {

                    setVisible(false);
                    new loginform().setVisible(true);
                }

            }
        });



        ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\exit.png"));
        Image i17 = i16.getImage().getScaledInstance(70,60, Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        JLabel label5 = new JLabel(i18);
        label5.setBounds(1130,10,70,60);

        JLabel exit = new JLabel("Exit");
        exit.setBounds(1200, 20,200,40);
        exit.setFont(new Font("RALEWAY" , Font.BOLD , 20));
        add(exit);
        exit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                 JOptionPane.showMessageDialog(null , "Do you really want to exit", "Select" , YES_NO_OPTION);

                if(YES_NO_OPTION==0) {
                    System.exit(0);
                }

            }
        });

        add(label);
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);



    }


    public static void main(String[] args) {
        new Welcome();

    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
