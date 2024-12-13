
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;


public class remove_user extends JFrame implements ActionListener {

    JButton b1, b2, removeButton;  // Add removeButton

    JTable table;
    remove_user() {
        Color c1 = new Color(204, 231, 191);
        getContentPane().setBackground(c1);
        setLayout(null);

        table = new JTable();
        try {
            JDBC_Connection c = new JDBC_Connection();
            ResultSet rs = c.s.executeQuery("select * from Registration_Details_FY");
            //table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 10, 900, 650);

        add(jsp);
        b1=new JButton("Cancel");
        b1.setBounds(950, 50, 100, 30);
        removeButton = new JButton("Remove");
        removeButton.setBounds(950, 10, 100, 30);
        removeButton.addActionListener(this);
        b1.addActionListener(this);
        add(removeButton);
        add(b1);

        setVisible(true);
        setTitle("Bonafide Certificate Automation");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(200, 50);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b2) {

            int selectedRow = table.getSelectedRow();

            if (selectedRow != -1) {
                try {
                    JDBC_Connection c = new JDBC_Connection();
                    String name = table.getValueAt(selectedRow, table.getColumn("first_second_name").getModelIndex()).toString();

                    // Execute DELETE query to remove the record from the database
                    String deleteQuery = "DELETE FROM userslogin WHERE first_second_name = '" + name + "'";
                    c.s.executeUpdate(deleteQuery);


                    // Remove the selected row from the JTable
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.removeRow(selectedRow);

                    JOptionPane.showMessageDialog(this, "user removed successfully");
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error removing user");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a user to remove");
            }
        }
        else if(ae.getSource()==b1){
            setVisible(false);
            new AllEntries();

        }
    }

    public static void main(String args[]) {
        new remove_user();
    }
}
