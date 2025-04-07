package com.pdfCombiner.main;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class PdfMerger {

    public static void main(String[] args) {
        // Select input folder (containing PDFs)
        JFileChooser folderChooser = new JFileChooser();
        folderChooser.setDialogTitle("Select Folder Containing PDFs");
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int folderResult = folderChooser.showOpenDialog(null);
        if (folderResult != JFileChooser.APPROVE_OPTION) {
            System.out.println("No folder selected. Exiting...");
            return;
        }

        File inputFolder = folderChooser.getSelectedFile();

        // Select output file path
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Destination for Merged PDF");
        //fileChooser.setSelectedFile(new File("merged.pdf"));
        fileChooser.setSelectedFile(new File("merged_"+System.currentTimeMillis()+".pdf"));

        int fileResult = fileChooser.showSaveDialog(null);
        if (fileResult != JFileChooser.APPROVE_OPTION) {
            System.out.println("No output file selected. Exiting...");
            return;
        }

        File outputFile = fileChooser.getSelectedFile();

        PDFMergerUtility merger = new PDFMergerUtility();
        merger.setDestinationFileName(outputFile.getAbsolutePath());

        File[] pdfFiles = inputFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (pdfFiles == null || pdfFiles.length == 0) {
            JOptionPane.showMessageDialog(null, "No PDF files found in selected folder!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            for (File file : pdfFiles) {
                System.out.println("Adding: " + file.getName());
                merger.addSource(file);
            }

            merger.mergeDocuments(null);
            JOptionPane.showMessageDialog(null, "✅ PDFs merged successfully!\nOutput: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "❌ Error while merging PDFs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Error while merging PDFs: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
