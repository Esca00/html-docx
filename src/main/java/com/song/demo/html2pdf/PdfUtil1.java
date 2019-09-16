package com.song.demo.html2pdf;

/**
 * @Author: Song Chengzhi
 * @Date: 2019/8/14 16:35
 */
import com.itextpdf.text.pdf.BaseFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.net.MalformedURLException;

/**
 * Pdf处理工具类
 *
 * @author
 * @create 2017-12-18 21:25
 **/
public class PdfUtil1 {

    protected static Logger logger = LoggerFactory.getLogger(PdfUtil.class);

    /**
     *
     * @param htmlFile html文件存储路径
     * @param pdfFile  生成的pdf文件存储路径
     * @param chineseFontPath 中文字体存储路径
     */
    public static void html2pdf(String htmlFile, String pdfFile, String chineseFontPath)  {
        // step 1
        String url;
        OutputStream os = null;
        try {
            url = new File(htmlFile).toURI().toURL().toString();
            os = new FileOutputStream(pdfFile);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocument(url);
            // 解决中文不显示问题
            ITextFontResolver fontResolver = renderer.getFontResolver();
            fontResolver.addFont(chineseFontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

            renderer.layout();
            renderer.createPDF(os);
        } catch (MalformedURLException e) {
            logger.warn(e.toString(), e);
        } catch (FileNotFoundException e) {
            logger.warn(e.toString(), e);
        } catch (com.lowagie.text.DocumentException e) {
            logger.warn(e.toString(), e);
        } catch (IOException e) {
            logger.warn(e.toString(), e);
        } finally {
            if(os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    logger.warn(e.toString(), e);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            //html文件路径
            String htmlFilePath = "K:\\test\\123.html";
            // 中文字体存储路径
            String chineseFontPath = "C:\\Windows\\Fonts\\simsunb.ttf";
            // html转pdf
            html2pdf(htmlFilePath,"K:\\test\\123.pdf", chineseFontPath);
            System.out.println("转换成功！");
        } catch (Exception e) {
            logger.error("html转换为pdf失败", e);
        }
    }
}
