//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.pdmodel.PDPageContentStream;
//import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
//
//import javax.swing.*;
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.*;
//
//public class ImagePDFCreator {
//    public static void main(String[] args) {
//        try {
//            // Create a new PDF document
//            PDDocument document = new PDDocument();
//
//            // Create a file chooser dialog to select images
//            JFileChooser fileChooser = new JFileChooser();
//            fileChooser.setMultiSelectionEnabled(true);
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//            int returnValue = fileChooser.showOpenDialog(null);
//
//            // Process selected images
//            if (returnValue == JFileChooser.APPROVE_OPTION) {
//                File[] selectedFiles = fileChooser.getSelectedFiles();
//
//                // Ensure that there are 10 selected images
//                if (selectedFiles.length == 2) {
//                    for (File file : selectedFiles) {
//                        // Create a new page for each image
//                        PDPage page = new PDPage();
//                        document.addPage(page);
//
//                        // Create a content stream to draw on the page
//                        PDPageContentStream contentStream = new PDPageContentStream(document, page);
//
//                        // Load the image
//                        BufferedImage image = ImageIO.read(file);
//
//                        // Set fixed width and height for images
//                        int imageWidth = 1000;
//                        int imageHeight = 1000;
//
//                        // Resize the image to fixed width and height
//                        Image scaledImage = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
//                        BufferedImage bufferedImage = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
//                        bufferedImage.getGraphics().drawImage(scaledImage, 0, 0, null);
//
//                        // Convert the buffered image to PDImageXObject
//                        PDImageXObject pdImage = PDImageXObject.createFromByteArray(document, toByteArray(bufferedImage), "image");
//
//                        // Draw the image on the page
//                        contentStream.drawImage(pdImage, 0, 0, imageWidth, imageHeight);
//
//                        // Close the content stream for the current page
//                        contentStream.close();
//                    }
//
//                    // Save the document
//                    document.save("output.pdf");
//                    document.close();
//
//                    System.out.println("PDF with images created successfully.");
//                } else {
//                    System.out.println("Please select exactly 10 images.");
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static byte[] toByteArray(BufferedImage image) throws IOException {
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ImageIO.write(image, "png", baos);
//        return baos.toByteArray();
//    }
//}

//write one
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.common.PDRectangle; // Import PDRectangle


import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImagePDFCreator extends JFrame {
    ImagePDFCreator() {
        try {
            // Create a new PDF document
            PDDocument document = new PDDocument();

            // Calculate A4 page size (assuming 72 points per inch)
            float pageWidth = 8.27f * 72; // Width in points (1 inch = 72 points)
            float pageHeight = 11.69f * 72; // Height in points (1 inch = 72 points)

            // Create a file dialog to select images
            FileDialog fileDialog = new FileDialog((Frame) null, "Select Images", FileDialog.LOAD);
            fileDialog.setMultipleMode(true);
            fileDialog.setVisible(true);
            File[] selectedFiles = fileDialog.getFiles();

            // Process selected images
            if (selectedFiles.length == 8) {
                for (File file : selectedFiles) {
                    // Create a new page for each image
                    PDPage page = new PDPage();
                    page.setMediaBox(new PDRectangle(pageWidth, pageHeight));
                    document.addPage(page);

                    // Create a content stream to draw on the page
                    PDPageContentStream contentStream = new PDPageContentStream(document, page);

                    // Load the image
                    BufferedImage image = ImageIO.read(file);

                    // Calculate scaling factors to fit the image within the page
                    float imageWidth = image.getWidth();
                    float imageHeight = image.getHeight();
                    float scaleX = pageWidth / imageWidth;
                    float scaleY = pageHeight / imageHeight;
                    float scale = Math.min(scaleX, scaleY);

                    // Calculate the position to center the image on the page
                    float xPos = (pageWidth - imageWidth * scale) / 2;
                    float yPos = (pageHeight - imageHeight * scale) / 2;

                    // Draw the image on the page
                    contentStream.drawImage(LosslessFactory.createFromImage(document, image), xPos, yPos, imageWidth * scale, imageHeight * scale);

                    // Close the content stream for the current page
                    contentStream.close();
                }

                // Save the document
                document.save("output.pdf");
                document.close();

                JOptionPane.showMessageDialog(null,"Documents Uploaded successfully !!");
            } else {
                JOptionPane.showMessageDialog(null,"Please select Required Documents !!.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
