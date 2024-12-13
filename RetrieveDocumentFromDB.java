import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;


public class RetrieveDocumentFromDB extends JFrame{

    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/hostel_project";
        String username = "root";
        String password = "Pr@g@ti2005";


        int documentId = 1; // Replace with the ID of the document you want to retrieve

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Retrieve document content from the database
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT fileData, filename FROM documents WHERE id = ?");
            preparedStatement.setInt(1, documentId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Get document content as a byte array
                byte[] documentContent = resultSet.getBytes("fileData");
                String documentName = resultSet.getString("filename");
                ByteArrayInputStream inputStream= new ByteArrayInputStream(documentContent);
                BufferedImage image = ImageIO.read(inputStream);

                JFrame f =new JFrame();

                ImageIcon i2=new ImageIcon(image);
                Image img=i2.getImage();
                Image newimg=img.getScaledInstance(900,1000,java.awt.Image.SCALE_SMOOTH);
                i2=new ImageIcon(newimg);

                JLabel j =new JLabel(i2);
                f.add(j);
                f.pack();
                f.setVisible(true);
                f.setSize(1000,1000);
                // Save the document content to a file
                saveToFile(documentContent, documentName);
                System.out.println("Document retrieved and saved: " + documentName);
            } else {
                System.out.println("Document not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToFile(byte[] content, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(content);
        }
    }
}