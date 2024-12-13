import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame implements ActionListener {
    JLabel l1,l2,l3,lb1;
    JTextField tf1,tf2;
    JButton b1,b2,b3;

    AdminLogin(){
        Container c=getContentPane();
        //c.setBackground(Color.pink);
        // c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setLayout(null);

        Font f1=new Font("Arial black",Font.BOLD,12);

        Font f3=new Font("Algerian",Font.BOLD,28);
        lb1=new JLabel("    __ Admin Login __  ");
        lb1.setBounds(80,40,700,60);
        lb1.setFont(f3);
        lb1.setForeground(Color.red);

        l1=new JLabel("Login Here");
        l1.setBounds(200,130,170,40);
        l1.setFont(f1);

        l2=new JLabel("Username : ");
        l2.setToolTipText(" Enter Your Username Here !");
        l2.setBounds(150,200,150,40);
        l2.setFont(f1);

        l3=new JLabel("Password : ");
        l3.setToolTipText(" Enter Your Password Here !");
        l3.setBounds(150,250,150,40);
        l3.setFont(f1);

        tf1=new JTextField(20);
        tf1.setBounds(260,208,90,31);
        tf2=new JTextField(20);
        tf1.setFont(f1);
        // tf2.setEchoChar('*');
        tf2.setBounds(260,250,90,31);
        tf2.setFont(f1);


        b1=new JButton("Login");
        b1.setToolTipText(" Your Data Will Submited !");
        b1.setBounds(150,330,80,40);

        b3=new JButton("Back");
        b3.setBounds(200,400,80,40);

        b2=new JButton("Clear");
        b2.setBounds(250,330,80,40);
        add(l1);
        add(l2);add(tf1);
        add(l3);add(tf2);
        b1.setFont(f1);
        add(b1);
        add(b2);
        add(lb1);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b1.setBackground(Color.green);
        b1.setForeground(Color.black);
        b2.setBackground(Color.green);
        b2.setForeground(Color.black);
        b3.setBackground(Color.green);
        b3.setForeground(Color.black);

    }
    public void actionPerformed(ActionEvent ae){
        String str=ae.getActionCommand();
        if(str.equals("Clear"))
        {
            tf1.setText("");
            tf2.setText("");
        }
        if(str.equals("Back"))
        {
            Homepage tf=new Homepage();
            tf.setSize(2000,1200);
            tf.setVisible(true);
            tf.setTitle("JTextField Example");
            tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        if(tf1.getText().equals("Gpn20")&& tf2.getText().equalsIgnoreCase("gpn0020"))
        {
            new AllEntries();
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid Username and Password");
            tf1.setText("");
            tf2.setText("");
        }
        }

}
