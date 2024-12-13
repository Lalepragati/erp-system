import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StorePDFInDatabase {
    StorePDFInDatabase()
    {
        String url = "jdbc:mysql://localhost:3306/hostel_project";
        String username = "root";
        String password = "Pr@g@ti2005";
        String filePath = "D:/HostelProjectCode/output.pdf";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 PreparedStatement statement = conn.prepareStatement("INSERT INTO documents_one (document_data) VALUES (?)")) {
                 File file = new File(filePath);
                 FileInputStream inputStream = new FileInputStream(file);
                //  FileInputStream inputStream = new FileInputStream(file);
                 statement.setBinaryStream(1, inputStream);

                statement.executeUpdate();
                System.out.println("PDF document saved to database successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        new StorePDFInDatabase();


    }

}