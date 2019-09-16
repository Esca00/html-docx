package com.song.demo.html2pdf;



import com.spire.doc.Document;
import com.spire.doc.documents.XHTMLValidationType;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;



/**
 * @Author: Song Chengzhi
 * @Date: 2019/8/14 17:25
 */
public class PDF2Word {

    public static void pdf2word(){
        String urlPdf = "K:\\test\\123.pdf";
        String doc = "K:\\test\\123.docx";
        //加载PDF
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(urlPdf);
        //保存为Word格式
        pdf.saveToFile(doc, FileFormat.DOCX);
    }

    public static void main(String[] args) {
        String urlPdf = "K:\\test\\123.pdf";
        String doc = "K:\\test\\123.docx";
        //加载PDF
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(urlPdf);
        //保存为Word格式
        pdf.saveToFile(doc, FileFormat.DOCX);

    }


//    public void html2word()throws Exception{
//        Document document = new Document();
//
//        //使用LoadHTML方法加载源文档
//        TextReader reader = File.OpenText("Target.html");
//        document.LoadHTML(reader, XHTMLValidationType.None);
//        document.setXHTMLValidateOption( XHTMLValidationType.None);
//        document.SaveToFile("HTMLtoWord.doc", FileFormat.Doc);
//    }
}
