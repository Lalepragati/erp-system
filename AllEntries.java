import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllEntries extends JFrame implements ActionListener {
    AllEntries(){
        JFrame frame = new JFrame("Merit List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font f1=new Font("Calibri",Font.PLAIN,18);


        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setFont(f1);
        model.addColumn("Sr no ");
        model.addColumn("Student Name");
        model.addColumn("Year");
        model.addColumn("Category");
        model.addColumn("Branch");
        model.addColumn("Percentage");
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");
            Statement stmt = conn.createStatement();
            // Entries Sequence as per registration

                String query = "SELECT  sr_no,Student_Name,Student_Name ,Year,category,Branch,Percentage FROM registration_details_ty";
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    model.addRow(new Object[]{  rs.getString("sr_no"),rs.getString("Student_Name"),rs.getString("Year"),rs.getString("category"), rs.getString("Branch"),rs.getString("Percentage"),});
                }


//SECOND YEAR
        model.addRow(new Object[]{(" ")});
        model.addRow(new Object[]{("  "),("  "),("SECOND YEAR LIST ")});
        model.addRow(new Object[]{(" ")});
        query = "SELECT  sr_no,Student_Name,Student_Name ,Year,category,Branch,Percentage FROM registration_details_SY";
        rs = stmt.executeQuery(query);
        while (rs.next())
        {
                model.addRow(new Object[]{ rs.getString("sr_no"), rs.getString("Student_Name"),rs.getString("Year"),rs.getString("category"), rs.getString("Branch"),rs.getString("Percentage"),});
        }
//FIRST YEAR
            model.addRow(new Object[]{(" ")});
            model.addRow(new Object[]{("  "),("  "),("FIRST YEAR LIST ")});
            model.addRow(new Object[]{(" ")});

                query = "SELECT   sr_no,Student_Name ,Year,category,Branch,Percentage FROM registration_details_FY";
                rs = stmt.executeQuery(query);
                while (rs.next())
                {
                    model.addRow(new Object[]{ rs.getString("sr_no"),rs.getString("Student_Name"),rs.getString("Year"),rs.getString("category"), rs.getString("Branch"),rs.getString("Percentage"),});
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        Font tableFont = new Font("Calibri", Font.PLAIN, 22);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.setFont(tableFont);
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);

        JButton b2 = new JButton("Remove");
        b2.setFont(tableFont);
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        JLabel l = new JLabel(" All Entries ");
        l.setFont(tableFont);
        frame.add(l, BorderLayout.NORTH);
        l.setBackground(Color.BLACK);
        l.setForeground(Color.red);
        l.setBounds(200,0,2000,240);
        l.setOpaque(true);
        frame.add(backButton, BorderLayout.SOUTH);
        frame.add(b2, BorderLayout.SOUTH);
        frame.setSize(2000, 1200);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String str = e.getActionCommand();
        if (str.equals("Remove")) {
            remove_user tf = new remove_user();
            tf.setSize(2000, 1200);
            tf.setVisible(true);
            tf.setTitle("JTextField Example");
            tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        Homepage tf= new Homepage();
        tf.setSize(2000,1200);
        tf.setVisible(true);
        tf.setTitle("JTextField Example");
        tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	public static void main(String []args) {
		new AllEntries();
	}

}
