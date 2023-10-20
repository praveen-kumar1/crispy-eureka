package com.fbots.external.source.DataExtractor.parser;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class PdfParser {

    public static void main(String[] args) {
        try {
            // Load the PDF document
            PdfReader pdfReader = new PdfReader("/Users/pravekumar/Learn From ES/DataExtractor/src/main/java/com/fbots/external/source/DataExtractor/parser/ather-450-faq.pdf");

            // Iterate through the pages and extract text
            for (int page = 1; page <= pdfReader.getNumberOfPages(); page++) {
                String pageText = PdfTextExtractor.getTextFromPage(pdfReader, page);

                // You can process the text extracted from each page here
                System.out.println("Page " + page + ":\n" + pageText);
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                // If you want to parse the text paragraph-wise, you can split the 'pageText' variable into paragraphs.
//                String[] paragraphs = pageText.split("\n");
//                for (String paragraph : paragraphs) {
//                    // Process each paragraph here
//                    System.out.println(paragraph);
//                    System.out.println();
//                }
            }

            // Close the PDF reader
            pdfReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
