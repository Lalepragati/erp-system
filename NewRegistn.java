import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.ItemEvent;
//import java.awt.event.ItemListener;

public class NewRegistn extends JFrame implements ActionListener {
	JLabel l1, l2_Sname, l3_Phone_No,l4, l5_email,l6,l7,l8,l9,l10,ps,branchLabel,l11;
	JTextField s_nameTextField,s_noTextField,p_noTextField,emailTextField,marksTextField;
	JTextArea l_address,p_address;
	JButton b1,b2,b3 ;
	JPasswordField jf;
	JComboBox cmb, branchcb;
	JRadioButton fy, sy, ty;

	NewRegistn(){

		Container c=getContentPane();
		//c.setBackground(Color.pink);
		// c.setLayout(new FlowLayout(FlowLayout.CENTER));
		c.setLayout(null);

		Font f0=new Font("Algerian",Font.BOLD,26);

		Font f1=new Font("Arial black",Font.BOLD,12);
		//Font f2=new Font("Arial black",Font.BOLD,19);

		l1=new JLabel("Register Here !! ");
		l1.setBounds(230,10,370,60);
		l1.setFont(f0);
		l1.setForeground(Color.RED);
		l1.setFocusable(true);
		l2_Sname =new JLabel("Student Full Name : ");
		l2_Sname.setToolTipText(" Enter Your Surname Name First !");
		l2_Sname.setBounds(55,90,200,20);
		l2_Sname.setFont(f1);
		s_nameTextField=new JTextField(20);
		s_nameTextField.setBounds(250,90,370,30);

		l3_Phone_No =new JLabel("Your Phone No :");
		l3_Phone_No.setBounds(55,140,370,30);
		l3_Phone_No.setFont(f1);
		s_noTextField=new JTextField(20);
		s_noTextField.setBounds(250,140,370,30);


		l5_email =new JLabel("Enter Email Id :");
		l5_email.setBounds(55,190,170,30);
		l5_email.setFont(f1);
		emailTextField=new JTextField(20);
		emailTextField.setBounds(250,190,370,30);

		l4=new JLabel("Enter Enroll no  :");
		l4.setBounds(55,280,170,30);
		l4.setFont(f1);
		p_noTextField=new JTextField(20);
		p_noTextField.setBounds(250,280,370,30);



		l6=new JLabel("Select Your Year :");
		l6.setBounds(55,240,170,30);
		l6.setFont(f1);

		ButtonGroup bg=new ButtonGroup();
		fy = new JRadioButton("First Year",true);
		fy.setBounds(250,240,100,20);
		sy = new JRadioButton(" Second Year");
		sy.setBounds(350,240,100,20);
		ty = new JRadioButton(" Third Year");
		ty.setBounds(470,240,100,20);
		bg.add(fy);
		bg.add(sy);
		bg.add(ty);

		add(fy);
		add(sy);
		add(ty);

	 l7=new JLabel(" Enter  percentage: ");
		l7.setBounds(55,330,180,20);
		l7.setFont(f1);
		marksTextField=new JTextField(20);
		// tf2.setEchoChar('*');
		marksTextField.setBounds(250,330,370,30);
		marksTextField.setFont(f1);

		l8=new JLabel(" Choose Your Category: ");
		l8.setBounds(55,380,180,20);
		l8.setFont(f1);
		String a[] = {"OPEN","OBC","SC","ST","SBC","NT","VJNT","OTHER"};
		cmb=new JComboBox(a);
		add(cmb);
	//	cmb.addItemListener(this);
		add(l8);
		cmb.setBounds(250,380,180,27);

		branchLabel=new JLabel(" Choose Your Branch: ");
		branchLabel.setBounds(55,425,180,20);
		branchLabel.setFont(f1);
		String b[] = {"IF","CE","ME","EE","PG","MU"};
		branchcb=new JComboBox(b);
		add(branchcb);
		//	cmb.addItemListener(this);
		add(branchLabel);
		branchcb.setBounds(250,425,180,27);

		l9=new JLabel(" Local Address : ");
		l9.setToolTipText(" Enter Your Address Here !");
		l9.setBounds(55,475,200,20);
		l9.setFont(f1);
		l_address=new JTextArea(20,30);
		l_address.setBounds(250,470,370,40);

		l10=new JLabel(" Permanent Address : ");
		l10.setToolTipText(" Enter Your  permanent  Address Here !");
		l10.setBounds(55,535,180,30);
		l10.setFont(f1);
		p_address=new JTextArea(20,30);
		p_address.setBounds(250,530,370,40);

		ps=new JLabel("Create Password : ");
		ps.setToolTipText(" Enter Your Password Here !");
		ps.setBounds(55,590,180,30);
		ps.setFont(f1);
		jf=new JPasswordField();
		jf.setEchoChar('*');
		jf.setBounds(250,590,370,30);
		jf.setFont(f1);
/*
		l11=new JLabel("Upload Documents : ");
		l11.setToolTipText(" Enter Your Password Here !");
		l11.setBounds(55,630,180,30);
		l11.setFont(f1);

	b3=new JButton("Upload Documents");
		b3.setToolTipText(" Your Data Will Submited !");
		b3.setBounds(300,640,150,40);
		b3.setBackground(Color.cyan);
*/
		b1=new JButton("NEXT");
		b1.setToolTipText(" Your Data Will Submited !");
		b1.setBounds(200,760,120,40);
		b1.setBackground(Color.cyan);

		b2=new JButton("Back");
		b2.setBounds(450,760,120,40);
		b2.setBackground(Color.cyan);

		add(l1);
		add(l2_Sname);add(s_nameTextField);
		add(l3_Phone_No);add(s_noTextField);
		add(l6);add(marksTextField);
		add(l4);add(p_address);
		add(l5_email);add(emailTextField);
        add(l7);add(p_noTextField);
		add(l9);add(l_address);
		add(l10);add(p_address);
		add(ps);add(jf);
		b1.setFont(f1);
		b2.setFont(f1);
		//b3.setFont(f1);
		add(b1);
		add(b2);
		//add(b3);add(l11);
		b1.addActionListener(this);
		b2.addActionListener(this);
	//	b3.addActionListener(this);
		//cmb.addItemListener(this);
	}
	//public void itemStateChanged(ItemEvent i){}
	public void actionPerformed(ActionEvent ae) {

		String str = ae.getActionCommand();
		String name = s_nameTextField.getText();
		String S_no = s_noTextField.getText();
		String year = null;

		if (str.equals("Back")) {
			Homepage tf = new Homepage();
			tf.setSize(2000, 1200);
			tf.setVisible(true);
			tf.setTitle("JTextField Example");
			tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	/*	if (str.equals("Upload Documents")) {
			ImagePDFCreator tf = new ImagePDFCreator();
		}*/
		if (str.equals("NEXT")) {
			if (fy.isSelected()) {
				year = "First Year";
			} else if (sy.isSelected()) {
				year = "Second Year";
			} else if (ty.isSelected()) {
				year = "Third Year";
			}

			String percentage = marksTextField.getText();
			String Category = (String) cmb.getSelectedItem();
			String branch = (String) branchcb.getSelectedItem();
			String P_No = p_noTextField.getText();
			String Email = emailTextField.getText();
			String Pass = jf.getText();
			int S_no_length=S_no.length();
			int pass_length=Pass.length();
			int P_No_length=P_No.length();

			try {
				if (name.equals("") || percentage.equals("") || Pass.equals("") || year.equals("") || Category.equals("") || S_no.equals("")) {
					JOptionPane.showMessageDialog(null, "All Information is Required !");
				} else {
					if(S_no_length!=10) {
						String msg = ("Phone Number Must be Of 10 digits ! ");
						JOptionPane.showMessageDialog(null, msg);
					}
					if(P_No_length!=10) {
						String msg = ("Phone Number Must be Of 10 digits ! ");
						JOptionPane.showMessageDialog(null, msg);
					}
					if(pass_length!=8) {
						String msg = ("Password Must be Of 8 Charecters ! ");
						JOptionPane.showMessageDialog(null, msg);
					}
					else {
						//if(S_no_length==10 && pass_length==8 && P_No_length==10) {
						JDBC_Connection c = new JDBC_Connection();
						if (year.equals("First Year")) {
							String query = "insert into Registration_Details_FY(Student_Name,Std_Phone_No,Year,Branch,Percentage,Category,Parent_Phone_No,Email,Password) values('" + name + "','" + S_no + "','" + year + "','" + branch + "','" + percentage + "','" + Category + "','" + P_No + "','" + Email + "','" + Pass + "')";
							c.s.executeUpdate(query);
						} else if (year.equals("Second Year")) {
							String query1 = "insert into Registration_Details_SY(Student_Name,Std_Phone_No,Year,Branch,Percentage,Category,Parent_Phone_No,Email,Password) values('" + name + "','" + S_no + "','" + year + "','" + branch + "','" + percentage + "','" + Category + "','" + P_No + "','" + Email + "','" + Pass + "')";
							c.s.executeUpdate(query1);
						} else if (year.equals("Third Year")) {
							String query2 = "insert into Registration_Details_TY(Student_Name,Std_Phone_No,Year,Branch,Percentage,Category,Parent_Phone_No,Email,Password) values('" + name + "','" + S_no + "','" + year + "','" + branch + "','" + percentage + "','" + Category + "','" + P_No + "','" + Email + "','" + Pass + "')";
							c.s.executeUpdate(query2);
						}
						String msg = ("Registration Successfully ! \n\n Your Username Is : " + S_no + "\n And Your Password Is : " + Pass);
						setVisible(false);
						JOptionPane.showMessageDialog(null, msg);
						Homepage tfd = new Homepage();
						tfd.setSize(1000, 700);
						tfd.setVisible(true);
						tfd.setTitle("JTextField Example");
						tfd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
				}

			} catch (Exception e1) {
				String msg = ("Enter Details In Proper Format ! ");
				JOptionPane.showMessageDialog(null, msg);
				System.out.println("Enter Details In Proper Format !"+e1);
			}
		}

	}


	public static void main(String[] args) {
		NewRegistn f1 =new NewRegistn();
		f1.setVisible(true);
		f1.setSize(730,800);
		f1.setTitle("New Registration ");
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
