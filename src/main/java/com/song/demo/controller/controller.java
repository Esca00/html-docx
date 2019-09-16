package com.song.demo.controller;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @Author: Song Chengzhi
 * @Date: 2019/8/14 10:10
 */
@Controller
public class controller {

    @PostMapping("")
    public void html2pdf(){



        //获取pdf的临时保存路径
        //tmp为网站下的目录
        //把生成的pdf放到网站下以便下载
        String pdfPath = "";
        String pdfName = "111.pdf";



    }
    public static void testHtml2Pdf() throws Exception{

        StringBuilder htmlString = new StringBuilder();

        htmlString.append("<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "  <h1><a id=\"_0\"></a>架构设计目标</h1> \n" +
                "  <h3><a id=\"_2\"></a>关键功能需求</h3> \n" +
                "  <table> \n" +
                "   <thead> \n" +
                "    <tr> \n" +
                "     <th>xuqiubianhao</th> \n" +
                "     <th>关键功能名称</th> \n" +
                "     <th>关键功能描述</th> \n" +
                "    </tr> \n" +
                "   </thead> \n" +
                "   <tbody> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "   </tbody> \n" +
                "  </table> \n" +
                "  <h3><a id=\"_10\"></a>关键质量属性</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_14\"></a>约束因素</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h1><a id=\"_18\"></a>架构设计综述</h1> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_22\"></a>架构设计关键决策点</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_26\"></a>被选架构架构设计方案</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <table> \n" +
                "   <thead> \n" +
                "    <tr> \n" +
                "     <th>评估准则</th> \n" +
                "     <th>备选方案一</th> \n" +
                "     <th>备选方案二</th> \n" +
                "    </tr> \n" +
                "   </thead> \n" +
                "   <tbody> \n" +
                "    <tr> \n" +
                "     <td>需求满足程度</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>项目组技术储备</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>技术成熟度</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>对相关系统的改造技术要求</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>……</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "    </tr> \n" +
                "   </tbody> \n" +
                "  </table> \n" +
                "  <h1><a id=\"_38\"></a>逻辑架构视图</h1> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_42\"></a>概述</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_46\"></a>重要逻辑单元</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_50\"></a>用例实现</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h1><a id=\"_54\"></a>物理架构视图</h1> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <table> \n" +
                "   <thead> \n" +
                "    <tr> \n" +
                "     <th>部署地点</th> \n" +
                "     <th>名称</th> \n" +
                "     <th>部署的软件组件</th> \n" +
                "     <th>运行环境软件及版本</th> \n" +
                "     <th>运行环境设备要求</th> \n" +
                "    </tr> \n" +
                "   </thead> \n" +
                "   <tbody> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>content1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "    </tr> \n" +
                "   </tbody> \n" +
                "  </table> \n" +
                "  <h1><a id=\"_65\"></a>开发架构视图</h1> \n" +
                " <p><img src=\"http://10.30.8.8:9001/ATS/view/loadPicture/c55686f30f9a46d281aa3b4bfae068a6\" alt=\"TEST\" /></p> \n"+
                "  <h1><a id=\"_69\"></a>运行架构视图</h1> \n" +
                "  <p><img src=\"http://10.30.8.8:9001/ATS/view/loadPicture/15c1178e3f604a28b547b7dcd16b18cb\" alt=\"TSETSS\" /></p> \n" +
                "  <h1><a id=\"_73\"></a>数据架构视图</h1> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h1><a id=\"_77\"></a>系统间关系视图</h1> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h3><a id=\"_81\"></a>服务接口</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <table> \n" +
                "   <thead> \n" +
                "    <tr> \n" +
                "     <th>编号</th> \n" +
                "     <th>服务提供者</th> \n" +
                "     <th>服务调用者</th> \n" +
                "     <th>服务名称</th> \n" +
                "     <th>服务参数</th> \n" +
                "     <th>接口技术</th> \n" +
                "     <th>业务功能</th> \n" +
                "    </tr> \n" +
                "   </thead> \n" +
                "   <tbody> \n" +
                "    <tr> \n" +
                "     <td>1</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "     <td>content6</td> \n" +
                "     <td>content7</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>2</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "     <td>content6</td> \n" +
                "     <td>content7</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>3</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "     <td>content6</td> \n" +
                "     <td>content7</td> \n" +
                "    </tr> \n" +
                "    <tr> \n" +
                "     <td>4</td> \n" +
                "     <td>content2</td> \n" +
                "     <td>content3</td> \n" +
                "     <td>content4</td> \n" +
                "     <td>content5</td> \n" +
                "     <td>content6</td> \n" +
                "     <td>content7</td> \n" +
                "    </tr> \n" +
                "   </tbody> \n" +
                "  </table> \n" +
                "  <h3><a id=\"_92\"></a>数据接口</h3> \n" +
                "  <p>请将此处内容进行替换</p> \n" +
                "  <h1><a id=\"_96\"></a>关键质量属性设计</h1> \n" +
                "  <p>请将此处内容进行替换</p>\n" +
                " </body>\n" +
                "</html>");


//        OutputStream os = new FileOutputStream("K:\\test\\test.pdf");    //生成PDF文件的路径
//        ITextRenderer renderer = new ITextRenderer();
//        ITextFontResolver font = renderer.getFontResolver();
//        font.addFont("J:\\simsunttc\\simsun.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体
//        font.addFont("C:\\Windows\\Fonts\\simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);//添加中文识别，这里是设置的宋体，Linux下要换成对应的字体

//        renderer.setDocumentFromString(htmlString.toString());
//
//
//        renderer.layout();
//        renderer.createPDF(os);
//        renderer.finishPDF();
        Document document = new Document();
        OutputStream os = new FileOutputStream(new File("K:\\test\\test.pdf"));
        PdfWriter.getInstance(document,os);

        document.open();

//        BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\simsunb.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
//        BaseFont baseFont = BaseFont.createFont("J:\\simsunttc\\simsunb.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont);
        document.add(new Paragraph("aaaa解决中文问题了！",font));
        document.close();
        System.out.println("转换结束");

    }

    /**
     * @description: inputSteam转byte[] 因为根据路径死活读不到文件
     * @param: [inputStream]
     * @return: byte[]
     */
    public static byte[] inputStream2Byte(InputStream inputStream) {
        byte[] buffer = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            inputStream.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    public static void main(String[] args) throws Exception {
        testHtml2Pdf();
    }

    @GetMapping("/index")
    public String test(){
        return "sample";
    }

    @PostMapping("/word")
    public void getWord(@RequestParam( value="file") MultipartFile file,HttpServletRequest request, HttpServletResponse response)  {

        byte[] data = new byte[0];
        try {
            data = file.getBytes();
            String filepath ="K:\\test\\test.docx"  ;
            File files  = new File(filepath);
            if(files.exists()){
                files.delete();
            }
            FileOutputStream fos = new FileOutputStream(files);
            fos.write(data,0,data.length);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}

