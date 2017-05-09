package com.markbudai.openfleet.services;

import com.markbudai.openfleet.Application;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by Mark on 2017. 05. 07..
 */
@Service
public class DocumentService {

    private static Logger logger = LoggerFactory.getLogger(DocumentService.class);

    public DocumentService(){}

    public void writeDocument(OutputStream out){
        try{
            logger.debug("{}",this.getClass().getResource("wordTemplates\test.docx"));
            XWPFDocument document = new XWPFDocument(Application.class.getResourceAsStream("wordTemplates/test.docx"));

            for(XWPFParagraph paragraph : document.getParagraphs()){
                for(XWPFRun run : paragraph.getRuns()){
                    System.out.println(run.text());
                    String text = run.text();
                    text = text.replace("{name}","John Doe");
                    System.out.println(text);
                    run.setText(text,0);
                }
            }
            document.write(out);
        } catch (Exception e){
            logger.error("Exception happened {}",e);
        }

    }


    public static void main(String[] args) throws IOException {
        XWPFDocument document = new XWPFDocument();
        /*XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Blank Test Form something blah.");
        FileOutputStream out = new FileOutputStream(new File("test.docx"));
        document.write(out);
        out.close();*/

        document = new XWPFDocument(new FileInputStream("test.docx"));
        for(XWPFParagraph paragraph : document.getParagraphs()){
            for(XWPFRun run : paragraph.getRuns()){
                System.out.println(run.text());
                String text = run.text();
                text = text.replace("{name}","John Doe");
                System.out.println(text);
                run.setText(text,0);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(new File("out.docx"));
        document.write(outputStream);
    }
}
