package com.fbots.external.source.DataExtractor.parser.pdfbox;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PDFParser {
    public static void main(String[] args) {
        try {
            // Load the PDF document
            File pdfFile = new File("/Users/pravekumar/Learn From ES/DataExtractor/src/main/java/com/fbots/external/source/DataExtractor/parser/ather-450-faq.pdf");
            PDDocument document = PDDocument.load(pdfFile);

            // Create a PDFTextStripper instance
            PDFTextStripper textStripper = new PDFTextStripper() {
                @Override
                protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
                    // This method will be called for each string in the PDF document
                    // You can process the text here, e.g., splitting it into paragraphs or handling it page-wise
                    System.out.println(text);
                }
            };

            // Iterate through the pages and extract text
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                textStripper.setStartPage(page + 1);
                textStripper.setEndPage(page + 1);
                String pageText = textStripper.getText(document);

                // You can process the text extracted from each page here
                System.out.println("Page " + (page + 1) + ":\n" + pageText);
            }

            // Close the PDF document
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
