import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class user_Interface extends JFrame implements ActionListener {
    JLabel l1,l2;
    JButton b1,b2,b3;
    String Id;
    user_Interface( String usname){
        Id=usname;
        Font f1=new Font("Algerian",Font.BOLD,36);
        l1=new JLabel("     ___ Matoshri GOVT Girls Hostel   ___  ");
        l1.setBounds(400,40,850,60);
        l1.setFont(f1);
        l1.setForeground(Color.red);
        l1.setBackground(Color.cyan);
        add(l1);

        Font f2=new Font("Arial black",Font.BOLD,18);
        setFont(f2);

        ImageIcon i1=new ImageIcon("img.jpg");
        l2 = new JLabel(i1);
        l2.setBounds(120,80,500,400);
        b1=new JButton("Your Profile");
        b2=new JButton("Merit List");
        b3=new JButton("Seat Matrix");
        b1.setBounds(50,170,110,40);
        b2.setBounds(50,280,110,40);
        b3.setBounds(50,400,110,40);

        add(b1);
        add(b2);
        add(b3);
        add(l2);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
      //  b4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();

        if(str.equals("Your Profile")) {
            Profile_Info f1 = new Profile_Info(Id);
            f1.setVisible(true);
            f1.setSize(700, 600);
            f1.setTitle("Your Profile ");
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(str.equals("Merit List")) {
            new StudentMeritList();

        }
        if(str.equals("Seat Matrix"))
        {
            SeatAllocationTable fy = new SeatAllocationTable();
            fy.setVisible(true);
            fy.setSize(2000,1200);
            fy.setTitle("seat Allocation Table");
            fy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }
        
    }
   /* public static void main(String[] args) {
        user_Interface f1 =new user_Interface();
        f1.setVisible(true);
        f1.setSize(800,730);
        f1.setTitle("New Registration ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
