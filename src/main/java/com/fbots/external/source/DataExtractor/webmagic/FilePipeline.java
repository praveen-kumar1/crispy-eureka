//package com.fbots.external.source.DataExtractor.webmagic;
//
//import us.codecraft.webmagic.ResultItems;
//import us.codecraft.webmagic.Task;
//import us.codecraft.webmagic.pipeline.Pipeline;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//public class FilePipeline implements Pipeline {
//    private String savePath; // The directory where you want to save the pages
//
//    public FilePipeline(String savePath) {
//        this.savePath = savePath;
//    }
//
//    @Override
//    public void process(ResultItems resultItems, Task task) {
//        String title = resultItems.get("title");
//        String url = resultItems.get("url");
//        String content = resultItems.get("content");
//
//        // Create a directory if it doesn't exist
//        File directory = new File(savePath);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        // Create a file with the title as the filename
//        String filename = title + ".html"; // You can customize the filename as needed
//        File file = new File(directory, filename);
//
//        try (FileWriter writer = new FileWriter(file)) {
//            writer.write(content);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
