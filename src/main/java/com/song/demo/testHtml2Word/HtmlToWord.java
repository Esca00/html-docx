package com.song.demo.testHtml2Word;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.util.HtmlUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlToWord {

///**
//* 外部接口
//* @param htmlPath html文件的路径
//* @param cssPath css文件的路径
//* @param wordPath word文件的路径(保存本地的路径)
//* @param code 编码方式(一般都为utf-8)
//* @throws Exception
//*/
//public   void htmlToWord2(String htmlPath, String cssPath, String wordPath, String code) throws Exception {
//	/*InputStream bodyIs = new FileInputStream("H:\\MyTest\\Java\\test_show\\test.html");
//	InputStream cssIs = new FileInputStream("H:\\MyTest\\Java\\test_show\\test.css");*/
//	InputStream bodyIs = new FileInputStream(htmlPath);
//	//InputStream cssIs = new FileInputStream(cssPath);
//	String body = this.getContent(bodyIs);
//	 String css = "";//this.getContent(cssIs);
//	// 拼一个标准的HTML格式文档
//	String content = "<html><head><style>" + css + "</style></head><body>" + body + "</body></html>";
//	InputStream is = new ByteArrayInputStream(content.getBytes(code));
//	OutputStream os = new FileOutputStream(wordPath);
//	this.inputStreamToWord(is, os);
//}

/**
* 把is写入到对应的word输出流os中 不考虑异常的捕获，直接抛出
* 
* @param is
* @param os
* @throws IOException
*/
private void inputStreamToWord(InputStream is, OutputStream os) throws IOException {
	POIFSFileSystem fs = new POIFSFileSystem();
	// 对应于org.apache.poi.hdf.extractor.WordDocument
	fs.createDocument(is, "WordDocument");
	fs.writeFilesystem(os);
	os.close();
	is.close();
	fs.close();
}

/**
* 把输入流里面的内容以UTF-8编码当文本取出。 不考虑异常，直接抛出
* 
* @param ises
* @return
* @throws IOException
*/
private String getContent(InputStream... ises) throws IOException {
	if (ises != null) {
	StringBuilder result = new StringBuilder();
	BufferedReader br;
	String line;
	for (InputStream is : ises) {
	br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	while ((line = br.readLine()) != null) {
	result.append(line);
	}
	}
	return result.toString();
	}
	return null;
	}
//	public static String docToHtml() throws Exception {
//	    File path = new File(ResourceUtils.getURL("classpath:").getPath());
//	    String imagePathStr = path.getAbsolutePath() + "\\static\\image\\";
//	    String sourceFileName = path.getAbsolutePath() + "\\static\\test.doc";
//	    String targetFileName = path.getAbsolutePath() + "\\static\\test2.html";
//	    File file = new File(imagePathStr);
//	    if(!file.exists()) {
//	        file.mkdirs();
//	    }
//	    HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
//	    org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
//	    WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
//	    //保存图片，并返回图片的相对路径
//	    wordToHtmlConverter.setPicturesManager((content, pictureType, name, width, height) -> {
//	        try (FileOutputStream out = new FileOutputStream(imagePathStr + name)) {
//	            out.write(content);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return "image/" + name;
//	    });
//	    wordToHtmlConverter.processDocument(wordDocument);
//	    org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
//	    DOMSource domSource = new DOMSource(htmlDocument);
//	    StreamResult streamResult = new StreamResult(new File(targetFileName));
//	    TransformerFactory tf = TransformerFactory.newInstance();
//	    Transformer serializer = tf.newTransformer();
//	    serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
//	    serializer.setOutputProperty(OutputKeys.INDENT, "yes");
//	    serializer.setOutputProperty(OutputKeys.METHOD, "html");
//	    serializer.transform(domSource, streamResult);
//	    return targetFileName;
//	}
	
//	public static String docxToHtml() throws Exception {
//	    File path = new File(ResourceUtils.getURL("classpath:").getPath());
//	    String imagePath = path.getAbsolutePath() + "\\static\\image";
//	    String sourceFileName = path.getAbsolutePath() + "\\static\\test.docx";
//	    String targetFileName = path.getAbsolutePath() + "\\static\\test.html";
//
//	    OutputStreamWriter outputStreamWriter = null;
//	    try {
//	        XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
//	        XHTMLOptions options = XHTMLOptions.create();
//	        // 存放图片的文件夹
//	        options.setExtractor(new FileImageExtractor(new File(imagePath)));
//	        // html中图片的路径
//	        options.URIResolver(new BasicURIResolver("image"));
//	        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");
//	        XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
//	        xhtmlConverter.convert(document, outputStreamWriter, options);
//	    } finally {
//	        if (outputStreamWriter != null) {
//	            outputStreamWriter.close();
//	        }
//	    }
//	    return targetFileName;
//	}
 

	public static String readfile(String filePath) {
	    File file = new File(filePath);
	    InputStream input = null;
	    try {
	        input = new FileInputStream(file);
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    StringBuffer buffer = new StringBuffer();
	    byte[] bytes = new byte[1024];
	    try {
	        for (int n; (n = input.read(bytes)) != -1;) {
	            buffer.append(new String(bytes, 0, n, "utf8"));
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return buffer.toString();
	}
	
	public static String writeWordFile(String content) {
        String path = "D:/wordFile";
        Map<String, Object> param = new HashMap<String, Object>();

        if (!"".equals(path)) {
            File fileDir = new File(path);
            if (!fileDir.exists()) {
                fileDir.mkdirs();	
            }
            content = HtmlUtils.htmlUnescape(content);
            List<HashMap<String, String>> imgs = getImgStr(content);
            int count = 0;
            for (HashMap<String, String> img : imgs) {
                count++;
                //处理替换以“/>”结尾的img标签
                content = content.replace(img.get("img"), "${imgReplace" + count + "}");
                //处理替换以“>”结尾的img标签
                content = content.replace(img.get("img1"), "${imgReplace" + count + "}");
                Map<String, Object> header = new HashMap<String, Object>();
                String   imagePath  = img.get("src") ;
                
                InputStream inputStream = null;
                HttpURLConnection httpURLConnection = null;
                try {
                	URL url = new URL(imagePath);
                	httpURLConnection = (HttpURLConnection) url.openConnection();// 设置网络连接超时时间
                	httpURLConnection.setConnectTimeout(3000);// 设置应用程序要从网络连接读取数据
                	httpURLConnection.setDoInput(true);
                	httpURLConnection.setRequestMethod("GET");
                	int responseCode = httpURLConnection.getResponseCode();
                	if (responseCode == 200) {// 从服务器返回一个输入流
                		inputStream = httpURLConnection.getInputStream();
                	}
                 }catch (Exception e) {
                            e.printStackTrace();
                 }
                	
                



                try {
                    //File filePath = new File(ResourceUtils.getURL("classpath:").getPath());
                   // String imagePath = filePath.getAbsolutePath() + "\\static\\";
                  
                    //如果没有宽高属性，默认设置为400*300
                    if(img.get("width") == null || img.get("height") == null) {
                        header.put("width", 400);
                        header.put("height", 300);
                    }else {
                        header.put("width", (int) (Double.parseDouble(img.get("width"))));
                        header.put("height", (int) (Double.parseDouble(img.get("height"))));
                    }
                    header.put("type", "jpg");
                    header.put("content", OfficeUtil.inputStream2ByteArray(inputStream, true));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                param.put("${imgReplace" + count + "}", header);
            }
            try {
                // 生成doc格式的word文档，需要手动改为docx
                byte by[] = content.getBytes("UTF-8");
                ByteArrayInputStream bais = new ByteArrayInputStream(by);
                POIFSFileSystem poifs = new POIFSFileSystem();
                DirectoryEntry directory = poifs.getRoot();
                DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);
                FileOutputStream ostream = new FileOutputStream("D:\\wordFile\\temp.doc");
                poifs.writeFilesystem(ostream);
                bais.close();
                ostream.close();
                JacobUtil.wordConveter("D:\\wordFile\\temp.doc");
                // 临时文件（手动改好的docx文件）
                CustomXWPFDocument doc = OfficeUtil.generateWord(param, "D:\\wordFile\\temp.docx");
                //最终生成的带图片的word文件
                FileOutputStream fopts = new FileOutputStream("D:\\wordFile\\final.docx");
                doc.write(fopts);
                fopts.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "D:/wordFile/final.docx";
    }

    //获取html中的图片元素信息
    public static List<HashMap<String, String>> getImgStr(String htmlStr) {
        List<HashMap<String, String>> pics = new ArrayList<HashMap<String, String>>();

        Document doc = Jsoup.parse(htmlStr);
        Elements imgs = doc.select("img");
        for (Element img : imgs) {
            HashMap<String, String> map = new HashMap<String, String>();
            if(!"".equals(img.attr("width"))) {
                map.put("width", img.attr("width").substring(0, img.attr("width").length() - 2));
            }
            if(!"".equals(img.attr("height"))) {
                map.put("height", img.attr("height").substring(0, img.attr("height").length() - 2));
            }
            map.put("img", img.toString().substring(0, img.toString().length() - 1) + "/>");
            map.put("img1", img.toString());
            map.put("src", img.attr("src"));
            pics.add(map);
        }
        return pics;
    }
    
    







/**
* 调用的模板
* @param args
*/ 
public static void main(String[] args) {
	String htmlPath = "c:\\tmp\\777.html";
	String body = "";
	InputStream bodyIs ;
	try {
		bodyIs = new FileInputStream(htmlPath);
	//InputStream cssIs = new FileInputStream(cssPath);
	HtmlToWord hw = new HtmlToWord();
		body = hw.getContent(bodyIs);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	writeWordFile(body);
	try {
		//ht.htmlToWord2(htmlPath, "", wordPath, "utf-8");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }


}

 

 
 

 