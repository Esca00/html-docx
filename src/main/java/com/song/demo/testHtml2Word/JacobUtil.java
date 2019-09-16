package com.song.demo.testHtml2Word;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class JacobUtil {
	
	// 8 代表word保存成html
	public static final int WORD_HTML = 8; 
	
	// 1 代表html保存成word
	public static final int HTML_WORD = 1; 
 
	public static void main(String[] args) {
		String wordFile = "K:\\test\\7778.doc";
		String htmlFile = "K:\\test\\777.html";
	//	JacobUtil.wordToHtml(wordFile, htmlFile);
		
		
		JacobUtil.htmlToWord(htmlFile, wordFile);
		JacobUtil.wordConveter(wordFile);
	}
	
    /**  
     * WORD转HTML  
     * @param docfile WORD文件全路径  
     * @param htmlfile 转换后HTML存放路径 
     * notes:需要将jacob.dll拷贝到windows/system32或者项目所在jre\bin目录下面(比如我的Eclipse正在用的Jre路径是D:\Java\jdk1.7.0_17\jre\bin)。
     * @param html html静态页面路径
     * @param wordFile 要生成的word文档路径 
     */  
    public static void wordToHtml(String docfile, String htmlfile)   
    {   
    	// 启动word应用程序(Microsoft Office Word 2003)
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        System.out.println("*****正在转换...*****");
        try  
        {	
        	// 设置word应用程序不可见  
            app.setProperty("Visible", new Variant(false));  
            // documents表示word程序的所有文档窗口，（word是多文档应用程序）
            Dispatch docs = app.getProperty("Documents").toDispatch();  
            // 打开要转换的word文件
            Dispatch doc = Dispatch.invoke(docs, "Open", Dispatch.Method, new Object[] { docfile, new Variant(false), new Variant(true) }, new int[1]).toDispatch();   
            // 作为html格式保存到临时文件
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] { htmlfile, new Variant(10) }, new int[1]);   
            // 关闭word文件
            Dispatch.call(doc, "Close", new Variant(false));   
        }   
        catch (Exception e)   
        {   
            e.printStackTrace();   
        }   
        finally  
        {   
        	//关闭word应用程序
            app.invoke("Quit", new Variant[] {});   
        } 
        System.out.println("*****转换完毕********");
    }
    
    
    /**
 
     * JACOB方式
 
     * notes:需要将jacob.dll拷贝到windows/system32或者项目所在jre\bin目录下面(比如我的Eclipse正在用的Jre路径是D:\Java\jdk1.7.0_17\jre\bin)。
 
     * @param html html静态页面路径
 
     * @param wordFile 要生成的word文档路径
 
     */
 
    public static void htmlToWord(String htmlFile, String wordFile) {    
    	
            ActiveXComponent app = new ActiveXComponent("Word.Application"); // 启动word
            System.out.println("*****正在转换...*****");
            try {
 
                app.setProperty("Visible", new Variant(false));
 
                Dispatch wordDoc = app.getProperty("Documents").toDispatch();
 
                wordDoc = Dispatch.invoke(wordDoc, "Add", Dispatch.Method, new Object[0], new int[1]).toDispatch();
 
                Dispatch.invoke(app.getProperty("Selection").toDispatch(), "InsertFile", Dispatch.Method, new Object[] { htmlFile, "", new Variant(false), new Variant(false), new Variant(false) }, new int[3]);
 
                Dispatch.invoke(wordDoc, "SaveAs", Dispatch.Method, new Object[] {wordFile, new Variant(HTML_WORD)}, new int[1]);
 
                Dispatch.call(wordDoc, "Close", new Variant(false));
 
            } catch (Exception e) {
 
                e.printStackTrace();
 
            } finally {
 
                app.invoke("Quit", new Variant[] {});
 
            }
            System.out.println("*****转换完毕********");
    }
    
    public static void wordConveter(String  filepath) {
    	File file = new File(filepath);
        // 启动word应用程序(Microsoft Office Word 2003)
        ActiveXComponent app = new ActiveXComponent("Word.Application");
        System.out.println("正在转换     "+file.getAbsolutePath()+"");
        try {
            // 设置word应用程序不可见
            app.setProperty("Visible", new Variant(false));
            // documents表示word程序的所有文档窗口，（word是多文档应用程序）
            Dispatch docs = app.getProperty("Documents").toDispatch();
            // 打开要转换的word文件
            Dispatch doc = Dispatch.invoke(
                    docs,
                    "Open",
                    Dispatch.Method,
                    new Object[] { file.getAbsolutePath(), new Variant(false),
                            new Variant(true) }, new int[1]).toDispatch();
            String savePath=file.getAbsolutePath().replaceAll(".doc$","");

            // 作为type格式保存到临时文件
            // *Variant(0):doc
        // *Variant(1):dot
        // *Variant(2-5)，Variant(7):txt
        // *Variant(6):rft
        // *Variant(8)，Variant(10):htm
        // *Variant(9):mht
        // *Variant(11)，Variant(19-22):xml
        // *Variant(12):docx
        // *Variant(13):docm
        // *Variant(14):dotx
        // *Variant(15):dotm
        // *Variant(16)、Variant(24):docx
        // *Variant(17):pdf
        // *Variant(18):xps
        // *Variant(23):odt
        // *Variant(25):与Office2003与2007的转换程序相关，执行本程序后弹出一个警告框说是需要更高版本的 Microsoft

         int type=12;
            Dispatch.invoke(doc, "SaveAs", Dispatch.Method, new Object[] {
            		savePath , new Variant(type) }, new int[1]);
            // 关闭word文件
            Dispatch.call(doc, "Close", new Variant(false));
        } catch (Exception e) {
                System.out.println("*******转换出错********");
        } finally {
            // 关闭word应用程序
            app.invoke("Quit", new Variant[] {});
        }
        System.out.println("*******转换完毕********");
    }


}
