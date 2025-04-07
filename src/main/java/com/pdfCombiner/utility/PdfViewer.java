package com.pdfCombiner.utility;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PdfViewer extends JFrame {

    public PdfViewer(File pdfFile) {
        setTitle("PDF Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 1000);
        setLocationRelativeTo(null);

        try {
            PDDocument document = PDDocument.load(pdfFile);
            PDFRenderer pdfRenderer = new PDFRenderer(document);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage image = pdfRenderer.renderImageWithDPI(page, 120); // 120 DPI
                JLabel label = new JLabel(new ImageIcon(image));
                panel.add(label);
            }

            JScrollPane scrollPane = new JScrollPane(panel);
            getContentPane().add(scrollPane);

            document.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error opening PDF: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();
                PdfViewer viewer = new PdfViewer(selectedFile);
                viewer.setVisible(true);
            }
        });
    }
}
