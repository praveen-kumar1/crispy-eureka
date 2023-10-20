//package com.fbots.external.source.DataExtractor.webmagic;
//
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//
//public class WebMagicCrawler implements PageProcessor {
//
//    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
//
//    @Override
//    public void process(Page page) {
//        page.addTargetRequests(page.getHtml().links().regex("(https://crmsupport.freshworks.com\\.com/\\w+/\\w+)").all());
//        page.putField("author", page.getUrl().regex("https://crmsupport.freshworks.com\\.com/(\\w+)/.*").toString());
//        page.putField("name", page.getHtml().xpath("//h1[@class='entry-title public']/strong/a/text()").toString());
//        if (page.getResultItems().get("name")==null){
//            //skip this page
//            page.setSkip(true);
//        }
//        page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
//    }
//
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    public static void main(String[] args) {
//        Spider.create(new WebMagicCrawler()).addUrl("https://crmsupport.freshworks.com/en/support/solutions/articles/50000008391-preventive-validation?cloud=freshchat").thread(5).run();
//    }
//}
