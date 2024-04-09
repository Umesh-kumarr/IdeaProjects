package GymManagementSystem;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ListOfMembers extends JFrame {

    JTable j;

    JFrame f;

    ListOfMembers(){
        setLayout(null);
        JPanel panel = new JPanel();
        panel.setSize(1650,1080);
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

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("GymManagementSystem\\Image\\list of members.png"));
        Image i5 = i4.getImage().getScaledInstance(90,90, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel label1 = new JLabel(i6);
        label1.setBounds(820,20,90,90);

        JLabel nm = new JLabel("List of Member");
        nm.setBounds(900, 30,700,70);
        nm.setFont(new Font("RALEWAY" , Font.BOLD , 50));
        add(nm);





        String[][] data = {};
        String[] columnnames = {"id " , "Name"};

        j = new JTable();
        j.setBounds(90, 40 , 200 , 300);
        j.setBackground(new Color(3 ,45,48));
        j.setForeground(Color.black);
        panel.add(j);



        try {

            GymDBConnection cb = new GymDBConnection();
            String Memberinfo = ("Select*from Member");

            PreparedStatement ps = cb.conn.prepareStatement(Memberinfo);
            ps.executeQuery();
            j.setModel(DbUtils.resultSetToTableModel(ps.executeQuery()));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }





        add(label);
        add(label1);

    }

    public static void main(String[] args) {
        new ListOfMembers();
    }
}
