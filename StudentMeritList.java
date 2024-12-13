import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentMeritList implements ActionListener {
	public StudentMeritList() {
		JFrame frame = new JFrame("Merit List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);


		table.setPreferredScrollableViewportSize(new Dimension(900, 800)); // Adjust dimensions as needed
		Font tableFont = new Font("Calibri", Font.PLAIN, 22);
		model.addColumn("Student Name");
		model.addColumn("Year");
		model.addColumn("Category");
		model.addColumn("Branch");
		model.addColumn("Percentage");

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");
			Statement stmt = conn.createStatement();

			model.addRow(new Object[]{" "});

			String[] categories = {"Open", "OBC", "SC", "ST", "SBC", "NT"};
			int[] seats = {10, 7, 8, 6, 2, 4};

			// Query for each category
			for (int i = 0; i < categories.length; i++) {
				String category = categories[i];
				int allocatedSeats = seats[i];
				String query = "SELECT Student_Name ,Year,category,Branch,Percentage FROM registration_details_TY WHERE category='" + category + "' LIMIT " + allocatedSeats;
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					model.addRow(new Object[]{rs.getString("Student_Name"), rs.getString("Year"), rs.getString("category"), rs.getString("Branch"), rs.getString("Percentage"),});
				}
			}

			model.addRow(new Object[]{" "});
			model.addRow(new Object[]{" ", " ", "SECOND YEAR LIST "});
			model.addRow(new Object[]{" "});

			for (int i = 0; i < categories.length; i++) {
				String category = categories[i];
				int allocatedSeats = seats[i];
				String query = "SELECT Student_Name ,Year,category,Branch,Percentage FROM registration_details_SY WHERE category='" + category + "' LIMIT " + allocatedSeats;
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					model.addRow(new Object[]{rs.getString("Student_Name"), rs.getString("Year"), rs.getString("category"), rs.getString("Branch"), rs.getString("Percentage"),});
				}
			}

			model.addRow(new Object[]{" "});
			model.addRow(new Object[]{" ", " ", "FIRST YEAR LIST "});
			model.addRow(new Object[]{" "});

			for (int i = 0; i < categories.length; i++) {
				String category = categories[i];
				int allocatedSeats = seats[i];
				String query = "SELECT Student_Name ,Year,category,Branch,Percentage FROM registration_details_FY WHERE category='" + category + "' order by percentage  desc ";
				ResultSet rs = stmt.executeQuery(query);
				while (rs.next()) {
					model.addRow(new Object[]{rs.getString("Student_Name"), rs.getString("Year"), rs.getString("category"), rs.getString("Branch"), rs.getString("Percentage"),});
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane(table);
		frame.add(scrollPane, BorderLayout.CENTER);

		JButton backButton = new JButton("Back");
		backButton.setFont(tableFont);
		backButton.addActionListener(this);
		backButton.setBackground(Color.BLACK);
		backButton.setForeground(Color.WHITE);
		JLabel l = new JLabel(" Student Merit List");
		l.setFont(tableFont);
		frame.add(l, BorderLayout.NORTH);
		l.setBackground(Color.BLACK);
		l.setForeground(Color.red);
		l.setBounds(200,0,2000,240);
		l.setOpaque(true);
		frame.add(backButton, BorderLayout.SOUTH);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Implement action for back button
		Homepage tf=new Homepage();
		tf.setSize(2000,1200);
		tf.setVisible(true);
		tf.setTitle("JTextField Example");
		tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StudentMeritList();
			}
		});
	}
}
