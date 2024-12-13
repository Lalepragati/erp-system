import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeatAllocationTable extends JFrame implements ActionListener {
    private JTable table;
    JButton b;
    private DefaultTableModel model;

    public SeatAllocationTable() {
        b=new JButton("Back");
        add(b);
        b.setBounds(680,380,80,40);
        b.addActionListener(this);
        Font f1=new Font("Algerian",Font.BOLD,30);
        // Create table model with 6 rows and 4 columns
        String[] columns = {"Category", "First year ", "Second year", "Third year"};
        Object[][] data = {{"General", "10", "10", "10"},
                {"OBC", "7 ", "7", "7"},
                {"SC", "7", "7", "7"},
                {"ST", "7", "7", "7"},
                {"NT", "6", "6", "6"},
                {"SBC", "3", "3", "3"},
                {"Total Seats ", "40", "40", "40"}};
        model = new DefaultTableModel(data, columns);

        // Create JTable with table model
        table  = new JTable(model);
        table.setRowHeight(40); // Set row height for better visibility
        table.setFont(f1);
        // Set column widths
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);

        // Add JTable to JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Homepage tf= new Homepage();
        tf.setSize(2000,1200);
        tf.setVisible(true);
        tf.setTitle("JTextField Example");
        tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*public static void main(String []args)
    {
        SeatAllocationTable fy = new SeatAllocationTable();
        fy.setVisible(true);
        fy.setSize(2000,1200);
        fy.setTitle("seat Allocation Table");
        fy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }*/
}
