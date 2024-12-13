import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Homepage extends JFrame implements ActionListener{
    JLabel  l0,l1,htl,l2,logo,logo1,l3;
    JButton b1,b2,b3;

    public Homepage(){
        setBackground(Color.pink);
        l0=new JLabel();
        l0.setBounds(0,0,2000,240);
        l0.setOpaque(true);
        setLayout(null);

        l0.setBackground(Color.green);
        add(l0);

        Font f1=new Font("Algerian",Font.BOLD,36);
       Font f2=new Font("Algerian",Font.BOLD,33);
       Font f3=new Font("Calibri ",Font.BOLD,30);

       l1=new JLabel("    Government Polytechnic, Nanded  ");
        l1.setBounds(475,50,1100,100);
        l1.setFont(f1);
        l1.setForeground(Color.red);

       htl=new JLabel("Girls Hostel ");
       htl.setBounds(700,180,1000,70);
       htl.setFont(f2);
       htl.setForeground(Color.red);

       l3=new JLabel("   शासकीय तंत्रनिकेतन, नांदेड  (1964) ");
       l3.setBounds(605,125,1100,70);
       l3.setFont(f3);
       l3.setForeground(Color.black);
       ImageIcon i1=new ImageIcon("logo1.gif");
       ImageIcon i2=new ImageIcon("logo2.png");
       ImageIcon i3=new ImageIcon("img.jpg");


       Image img=i2.getImage();
       Image newimg=img.getScaledInstance(160,170,java.awt.Image.SCALE_SMOOTH);
        i2=new ImageIcon(newimg);

       Image img1=i3.getImage();
       Image newimg1=img1.getScaledInstance(1030,600,java.awt.Image.SCALE_SMOOTH);
       i3=new ImageIcon(newimg1);

        l2 = new JLabel(i3);
       logo = new JLabel(i1);
       logo1 = new JLabel(i2);

       l2.setBounds(210,300,900,400);
       logo.setBounds(330,75,160,170);
       logo1.setBounds(1230,75,160,170);

       TextArea t=new TextArea(10,59);
        t.setBounds(1200,300,600,410);
t.setText("\n  NOTICE BOARD "+" \n\n 1. last date to apply : 12-6-2024"+" \n\n"+" 2. First List will be display on 15- June" +"\n\n"+" 2. Second List will be display on 20- June" +"\n\n"+" 3. Required documents :-"+"\n\n"+"           i) ARC Form "+"\n"+"            ii) College Id ." + " \n" +"          iii) Sbi REceipt "+"\n" +"          iv)Marksheets  "+"\n");

        t.setEditable(false);
        t.setFont(f3);
        add(t);


        b1=new JButton("Admin Login");
       b1.setBackground(Color.green);
       b1.setForeground(Color.black);
        b2=new JButton("Student Login");
       b2.setBackground(Color.green);
       b2.setForeground(Color.black);
        b3=new JButton("New Registration");
        b3.setBackground(Color.green);
        b3.setForeground(Color.black);
//        b4=new JButton("all Login");
//        b4.setBackground(Color.green);
//        b4.setForeground(Color.black);
        b1.setBounds(450,700,240,55);
        b2.setBounds(705,700,235,55);
        b3.setBounds(963,700,300,55);
        b3.setBounds(963,700,300,55);
       b1.setFont(f3);
       b2.setFont(f3);
       b3.setFont(f3);
       // b4.setFont(f3);
        add(b1);
        add(b2);
        add(b3);
        add(logo);
        add(logo1);
        add(l2);
       add(l1);
       add(l3);
       add(htl);
       add(l0);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ae)
    {

            String str=ae.getActionCommand();
            if(str.equals("Admin Login"))
            {
                setVisible(false);
                AdminLogin f1 =new AdminLogin();
                f1.setVisible(true);
                f1.setSize(800,700);
                f1.setTitle("Admin Login");
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(str.equals("Student Login"))
            {
                setVisible(false);
                login f1 =new login();
                f1.setVisible(true);
                f1.setSize(800,700);
                f1.setTitle("JProgressBar Example");
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
            else if(str.equals("New Registration")){
                setVisible(false);
                NewRegistn f1 =new NewRegistn();
                f1.setVisible(true);
                f1.setSize(2000,1200);
                f1.setTitle("New Registration ");
                f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

    }
    public static void main(String []args)
    {
       // String[] imagePaths = {"img.jpg", "Hostel img2.jpg", "Hostel img3.jpg"}; // Replace these with actual image paths
     Homepage tf= new Homepage();
        tf.setSize(2000,1200);
        tf.setVisible(true);
        tf.setTitle("JTextField Example");
        tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}