import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, lb1;
    JTextField uname, ps;
    JButton b1, b2, b3;
    public Connection conn;
    public Statement s;
    public ResultSet rs, rs1, rs2;

    login() {
        Container c = getContentPane();
        //c.setBackground(Color.cyan);
        // c.setLayout(new FlowLayout(FlowLayout.CENTER));
        c.setLayout(null);

        Font f1 = new Font("Arial black", Font.BOLD, 12);
        Font f2 = new Font("Arial black", Font.BOLD, 19);
        Font f3 = new Font("Algerian", Font.BOLD, 28);

        lb1 = new JLabel("    __ Student Login __  ");
        lb1.setBounds(80, 40, 700, 60);
        lb1.setFont(f3);
        lb1.setForeground(Color.red);
        l1 = new JLabel("Login Here");
        l1.setBounds(200, 130, 170, 40);
        l1.setFont(f1);

        l2 = new JLabel("Username : ");
        l2.setToolTipText(" Enter Your Username Here !");
        l2.setBounds(150, 200, 150, 40);
        l2.setFont(f1);
        l3 = new JLabel("Password : ");
        l3.setToolTipText(" Enter Your Password Here !");
        l3.setBounds(150, 250, 150, 40);
        l3.setFont(f1);

        uname = new JTextField(20);
        uname.setBounds(260, 208, 90, 31);
        ps = new JTextField(20);
        // ps.setEchoChar('*');
        // tf2.setEchoChar('*');
        ps.setBounds(260, 250, 90, 31);
        //ps.setFont(f2);

        b1 = new JButton("Login");
        b1.setBounds(250, 330, 80, 40);
        b1.setToolTipText(" Your Data Will Submited !");
        b2 = new JButton("Clear");
        b2.setBounds(150, 330, 80, 40);

        b3 = new JButton("Back");
        b3.setBounds(200, 400, 80, 40);

        add(l1);
        add(l2);
        add(l3);
        add(uname);
        add(ps);
        b1.setFont(f1);
        b2.setFont(f1);
        add(b1);
        add(b2);
        add(lb1);
        add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
    }

    boolean validate_data(String usname, String pass) {
        try {
            //   JDBC_Connection c = new JDBC_Connection();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");
            s = conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("select * from Registration_Details_FY where Std_Phone_No = ? and Password =? ");
            PreparedStatement pst1 = conn.prepareStatement("select * from Registration_Details_SY where Std_Phone_No = ? and Password =? ");
            PreparedStatement pst2 = conn.prepareStatement("select * from Registration_Details_TY where Std_Phone_No = ? and Password =? ");

            //  PreparedStatement pst =conn.prepareStatement("select Registration_Details_FY.Std_Phone_No ,Registration_Details_FY.Password ,Registration_Details_SY.Std_Phone_No ,Registration_Details_SY.Password ,Registration_Details_TY.Std_Phone_No ,Registration_Details_TY.Password FROM Registration_Details_FY join Registration_Details_SY join Registration_Details_TY where Std_Phone_No = ? and Password =? ");
            pst.setString(1, usname);
            pst.setString(2, pass);
            pst1.setString(1, usname);
            pst1.setString(2, pass);
            pst2.setString(1, usname);
            pst2.setString(2, pass);
            rs = pst.executeQuery();
            rs1 = pst1.executeQuery();
            rs2 = pst2.executeQuery();
            if (rs.next()) {
                return true;
            }
            if (rs1.next()) {
                return true;
            }
            if (rs2.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String usname = uname.getText();
        String pass = ps.getText();
        String str = ae.getActionCommand();
        if (str.equals("Clear")) {
            uname.setText("");
            ps.setText("");
        }
        if (str.equals("Login")) {
            try {
                if (usname.equals("") || pass.equals("")) {
                    JOptionPane.showMessageDialog(null, "Username And Password Both Fields Are Required !");
                } else {

                    if (validate_data(usname, pass)) {
                        setVisible(false);
                        JOptionPane.showMessageDialog(null, "Login successfull");
                        user_Interface f1 = new user_Interface(usname);
                        f1.setVisible(true);
                        f1.setSize(800, 730);
                        f1.setTitle("New Registration ");
                        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username and Password");
                        uname.setText("");
                        ps.setText("");
                    }
                }

            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
            if (str.equals("Back")) {
                Homepage tf = new Homepage();
                tf.setSize(2000, 1200);
                tf.setVisible(true);
                tf.setTitle("JTextField Example");
                tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

    }
        public static void main (String args[]){
            login lg1 = new login();
            lg1.setVisible(true);
            lg1.setSize(500, 500);
            lg1.setTitle("Database Connection Example");

        }
    }

//678598473   Gayu3