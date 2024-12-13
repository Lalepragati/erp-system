import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;

public class Profile_Info extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JLabel[] labels;
    JLabel sname, Phone_No, year, Percentage, Email, Category, Parent_Phone_No, branchLabel;
    String uname;
    JButton b;
    public Connection conn;
    public Statement s;
    public ResultSet rs;

    Profile_Info(String usname) {
        uname = usname;
        setLayout(null);

        labels = new JLabel[8];
        String[] labelNames = {"Name", "Branch", "Year", "Percentage", "Phone no", "Category", "Enrollment no", "Email"};
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelNames[i] + " : ");
            labels[i].setBounds(270, 70 + i * 40, 150, 30);
            add(labels[i]);
        }
        Font f0 = new Font("Algerian", Font.BOLD, 26);
        Font f1 = new Font("Arial black", Font.BOLD, 15);
        //Font f2=new Font("Arial black",Font.BOLD,19);

        l9 = new JLabel(" Profile Information ");
        l9.setBackground(Color.cyan);
        l9.setForeground(Color.red);
        l9.setBounds(120, 30, 400, 40);
        l9.setFont(f0);


        b = new JButton("Back");
        b.setBounds(200, 400, 80, 40);
        add(b);
        b.addActionListener(this);


        l1 = new JLabel("Name : ");
        l1.setBounds(70, 80, 150, 40);
        l1.setFont(f1);
        sname = new JLabel();
        sname.setBounds(250, 80, 200, 30);

        l2 = new JLabel("Branch : ");
        l2.setBounds(70, 120, 100, 30);
        l2.setFont(f1);
        branchLabel = new JLabel();
        branchLabel.setBounds(250, 120, 100, 30);

        l3 = new JLabel("Year : ");
        l3.setBounds(70, 160, 100, 30);
        l3.setFont(f1);
        year = new JLabel();
        year.setBounds(250, 160, 100, 30);

        l4 = new JLabel("Percentage : ");
        l4.setBounds(70, 190, 140, 40);
        l4.setFont(f1);
        Percentage = new JLabel();
        //sname.setText((login.rs1).getString(1));
        Percentage.setBounds(250, 190, 100, 30);

        l5 = new JLabel("Phone no : ");
        l5.setBounds(70, 230, 140, 30);
        l5.setFont(f1);
        Phone_No = new JLabel();
        Phone_No.setBounds(250, 230, 200, 30);

        l6 = new JLabel("Category : ");
        l6.setBounds(70, 260, 150, 30);
        l6.setFont(f1);
        Category = new JLabel();
        Category.setBounds(250, 260, 100, 30);

        l7 = new JLabel("Enrollment no : ");
        l7.setBounds(70, 300, 160, 30);
        l7.setFont(f1);
        Parent_Phone_No = new JLabel();
        Parent_Phone_No.setBounds(250, 300, 100, 30);

        l8 = new JLabel("Email : ");
        l8.setBounds(70, 340, 100, 30);
        l8.setFont(f1);
        Email = new JLabel();
        Email.setBounds(250, 340, 200, 30);

        add(l1);
        add(sname);
        add(l2);
        add(branchLabel);
        add(l3);
        add(year);
        add(l4);
        add(Percentage);
        add(l5);
        add(Phone_No);
        add(l6);
        add(Category);
        add(l8);
        add(Email);
        add(l7);
        add(Parent_Phone_No);
        add(l9);


try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM Registration_Details_tY WHERE Std_Phone_No='" + uname + "'");
        if (rs.next()) {
            setLabels(rs);
        } else {
            rs = s.executeQuery("SELECT * FROM Registration_Details_fy WHERE Std_Phone_No='" + uname + "'");
            if (rs.next()) {
                setLabels(rs);
            } else {
                rs = s.executeQuery("SELECT * FROM Registration_Details_sy WHERE Std_Phone_No='" + uname + "'");
                if (rs.next()) {
                    setLabels(rs);
                }
            }
        }
    } catch(
    Exception e)

    {
        e.printStackTrace();
    }

}

    private void setLabels(ResultSet rs) {
        try {
            for (int i = 0; i < labels.length; i++) {
                labels[i].setText(rs.getString(i + 2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        Homepage tf= new Homepage();
        tf.setSize(2000,1200);
        tf.setVisible(true);
        tf.setTitle("JTextField Example");
        tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*
    public static void main(String[] args) {
        Profile_Info f1 =new Profile_Info();
        f1.setVisible(true);
        f1.setSize(700,730);
        f1.setTitle("New Registration ");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
