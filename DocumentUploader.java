import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class DocumentUploader extends JFrame implements ActionListener {
    private JButton b1, b2, b3, b4, b5, b6, b7, b8, b10, v1, v2, v3, v4, v5, v6, v7, v8, v9, skip;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    public Statement s;

    public DocumentUploader() {
        setTitle("Document Uploader");
        setSize(700, 600);
        setLayout(null);

        Font f0 = new Font("Algerian", Font.BOLD, 26);
        Font f1 = new Font("Arial black", Font.BOLD, 12);

        l1 = new JLabel(" Documents Required ");
        l1.setBounds(210, 40, 370, 60);
        l1.setFont(f0);

        l2 = new JLabel("1)  Admission Receipt \n(Of Current Year) ");
        l2.setBounds(65, 130, 330, 30);
        l2.setFont(f1);

        b1 = new JButton("Upload Document");
        b1.setToolTipText(" Click the Button to Upload Your Document !");
        b1.setBounds(410, 130, 160, 26);
        b1.setBackground(Color.cyan);

//        v1 = new JButton("view Document");
//        v1.setBounds(610, 130, 160, 26);
//        v1.setBackground(Color.cyan);

        l3 = new JLabel("2)  Domicile Certificate ");
        l3.setBounds(65, 170, 330, 30);
        l3.setFont(f1);

//        v2 = new JButton("view Document");
//        v2.setBounds(610, 170, 160, 26);
//        v2.setBackground(Color.cyan);

        b2 = new JButton("Upload Document");
        b2.setToolTipText(" Click the Button to Upload Your Document !");
        b2.setBounds(410, 170, 160, 26);
        b2.setBackground(Color.cyan);

//        v3 = new JButton(" view Document");
//        v3.setBounds(610, 170, 160, 26);
//        v3.setBackground(Color.cyan);

        l4 = new JLabel("3)  Nationality Certificate ");
        l4.setBounds(65, 210, 330, 30);
        l4.setFont(f1);

        b3 = new JButton("Upload Document");
        b3.setToolTipText(" Click the Button to Upload Your Document !");
        b3.setBounds(410, 210, 160, 26);
        b3.setBackground(Color.cyan);

//        v4 = new JButton("view Document");
//        v4.setBounds(610, 210, 160, 26);
//        v4.setBackground(Color.cyan);

        l5 = new JLabel("4)  Caste Certificate ");
        l5.setBounds(65, 250, 330, 30);
        l5.setFont(f1);

        b4 = new JButton("Upload Document");
        b4.setToolTipText(" Click the Button to Upload Your Document !");
        b4.setBounds(410, 250, 160, 26);
        b4.setBackground(Color.cyan);

//        v5 = new JButton("view Document");
//        v5.setBounds(610, 250, 160, 26);
//        v5.setBackground(Color.cyan);

        l6 = new JLabel("5)  Income Certificate ");
        l6.setBounds(65, 290, 330, 30);
        l6.setFont(f1);

        b5 = new JButton("Upload Document");
        b5.setToolTipText(" Click the Button to Upload Your Document !");
        b5.setBounds(410, 290, 160, 26);
        b5.setBackground(Color.cyan);

//        v6 = new JButton("view Document");
//        v6.setBounds(610, 290, 160, 26);
//        v6.setBackground(Color.cyan);

        l7 = new JLabel("6)  Recent Odd Semester Marksheet ");
        l7.setBounds(65, 330, 330, 30);
        l7.setFont(f1);

        b6 = new JButton("Upload Document");
        b6.setToolTipText(" Click the Button to Upload Your Document !");
        b6.setBounds(410, 330, 160, 26);
        b6.setBackground(Color.cyan);
//
//        v7 = new JButton("view Document");
//        v7.setBounds(610, 330, 160, 26);
//        v7.setBackground(Color.cyan);

        l8 = new JLabel("7)  Recent Even Semester Marksheet ");
        l8.setBounds(65, 370, 330, 30);
        l8.setFont(f1);
        add(l8);
        b7 = new JButton("Upload Document");
        b7.setToolTipText(" Click the Button to Upload Your Document !");
        b7.setBounds(410, 370, 160, 26);
        b7.setBackground(Color.cyan);

//        v8 = new JButton("view Document");
//        v8.setBounds(610, 370, 160, 26);
//        v8.setBackground(Color.cyan);

        l9 = new JLabel("8)  College Id Card ");
        l9.setBounds(65, 410, 330, 30);
        l9.setFont(f1);

        b8 = new JButton("Upload Document");
        b8.setToolTipText(" Click the Button to Upload Your Document !");
        b8.setBounds(410, 410, 160, 26);
        b8.setBackground(Color.cyan);

//        v9 = new JButton("view Document");
//        v9.setBounds(610, 410, 160, 26);
//        v9.setBackground(Color.cyan);
//

        b10 = new JButton("SUBMIT");
        b10.setToolTipText(" Your Data Will Submited !");
        b10.setBounds(280, 500, 120, 40);
        b10.setBackground(Color.black);
        b10.setForeground(Color.white);

        skip = new JButton("SKIP");
        skip.setBounds(420, 500, 120, 40);
        skip.setBackground(Color.black);
        skip.setForeground(Color.white);

        l8 = new JLabel(" Upload all documents in Image Format Only (Jpg, jpeg, png, etc..) ");
        l8.setBounds(180, 570, 620, 40);
        l8.setFont(f1);
        l8.setForeground(Color.red);

        add(l1);
        add(l2);
        add(b1);
       // add(v1);
        add(l3);
        add(b2);
      //  add(v2);
        add(l4);
        add(b3);
       // add(v3);
        add(l5);
        add(b4);
      //  add(v4);
        add(l6);
        add(b5);
       // add(v5);
        add(l7);
        add(b6);
       //// add(v6);
        add(l8);
        add(b7);
       // add(v7);
        add(l9);
        add(b8);
       // add(v8);
        add(b10);
       // add(v9);
        add(skip);

        skip.addActionListener(this);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);
                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;
                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileDialog = new FileDialog(DocumentUploader.this, "Select a document to upload", FileDialog.LOAD);
                fileDialog.setVisible(true);

                String fileName = fileDialog.getFile();
                String filePath = fileDialog.getDirectory() + fileName;

                if (fileName != null) {
                    uploadDocument(filePath);
                }
            }
        });
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    private void uploadDocument(String filePath) {
        try {
            // Read the file content
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            byte[] fileData = new byte[(int) file.length()];
            fis.read(fileData);
            fis.close();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel_project", "root", "Pr@g@ti2005");
            s = connection.createStatement();

            // Insert the document into the database

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO verify_ducuments (Admission_Receipt) VALUES ( ?)");
           // preparedStatement.setString(1, file.getName());
            preparedStatement.setBytes(1, fileData);

         preparedStatement = connection.prepareStatement("INSERT INTO verify_ducuments (Domicile_Certificate) VALUES ( ?)");
           // preparedStatement.setString(1, file.getName());
            preparedStatement.setBytes(1, fileData);
            preparedStatement.executeUpdate();
            // Close the database connection
            preparedStatement.close();
            connection.close();
            if(file.length() !=0) {
                JOptionPane.showMessageDialog(null, "Document uploaded  successfully");
            }else{
                JOptionPane.showMessageDialog(null, "Please select Required Documents !!.");
            }
        } catch (IOException | SQLException e) {
//            logTextArea.append("Error uploading document: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();

        if(str.equals("SKIP"))
        {
            Homepage tf = new Homepage();
            tf.setSize(2000, 1200);
            tf.setVisible(true);
            tf.setTitle("JTextField Example");
            tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args) {
        DocumentUploader d1 = new DocumentUploader();
        d1.setVisible(true);
    }
    }

