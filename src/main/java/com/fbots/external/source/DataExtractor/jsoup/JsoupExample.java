package com.fbots.external.source.DataExtractor.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;

import java.io.IOException;

public class JsoupExample {
    public static void main(String[] args) {
        String url = "https://support.freshbots.ai/en/support/solutions/articles/50000000469-configuring-multilingual-support-in-freddy-self-service"; // Replace with the URL of the webpage you want to scrape

        try {
            // Connect to the web page and retrieve its HTML content
            Document document = Jsoup.connect(url).get();

            // Extract the text content from the HTML document
            //String pageText = document.text();
            String formattedText = extractTextWithFormatting(document);


            System.out.println(formattedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractTextWithFormatting(Element element) {
        StringBuilder formattedText = new StringBuilder();

        for (TextNode textNode : element.textNodes()) {
            formattedText.append(textNode.text()).append(" ");
        }

        for (Element child : element.children()) {
            String childText = extractTextWithFormatting(child);
            formattedText.append(childText);
        }

        if (element.tagName().equals("p") || element.tagName().equals("br")) {
            formattedText.append("\n");
        }

        if (element.tagName().equals("h1") || element.tagName().equals("h2") || element.tagName().equals("h3")) {
            formattedText.append("\n\n");
        }

        return formattedText.toString();
    }

    private static String extractTextWithFormatting(Document document) {
        return extractTextWithFormatting(document.body());
    }
}
