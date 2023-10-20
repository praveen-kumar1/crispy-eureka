package com.fbots.external.source.DataExtractor.webcollector;


import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Crawling news from github news
 *
 * @author hu
 */
public class TestCrawler extends BreadthCrawler {
    /**
     * @param crawlPath crawlPath is the path of the directory which maintains
     *                  information of this crawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     *                  links which match regex rules from pag
     */

    public TestCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        // Start URL
        addSeed("https://support.freshbots.ai/en/support/home");
        // Define URL patterns to restrict the crawler
        addRegex("https://support.freshbots.ai/.*");
    }

    @Override
    public void visit(Page page, CrawlDatums links) {
        // Define how to process the page
        String url = page.url();

        // In this example, we'll just print the URL and content
        System.out.println("URL: " + url);
        byte[] content = page.content();
        String html = new String(content);
        Document document = Jsoup.parse(html);
        String fileName = url.replaceAll("[\\/:*?\"<>|]", "_");
        saveHtmlToFile(document.text(), fileName);
    }

    public static void main(String[] args) throws Exception {
        TestCrawler crawler = new TestCrawler("depth_crawler", true);


        crawler.getConf().setTopN(1000);
        crawler.getConf().setExecuteInterval(2000);
        crawler.setThreads(10);
        // Start the crawler
        crawler.start(50);

        Thread.sleep(5000);

        // Stop the crawler
        crawler.stop();
    }

    private void saveHtmlToFile(String htmlContent, String fileName) {
        fileName = fileName + ".html";
        File file = new File("/Users/pravekumar/Crawler/webcollector/", fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(htmlContent);
            System.out.println("Saved HTML content to: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to save HTML content to file: " + file.getAbsolutePath());
        }
    }
}

