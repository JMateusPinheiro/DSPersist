package l03.controller;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class JsoupController {

	private Properties prop = new Properties();

	public void CriarCSV(){
		
		try {
			prop.load(new FileInputStream("config.properties"));
			OutputStream os = new FileOutputStream(prop.getProperty("caminhoJsoup"));	
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw =	new	BufferedWriter(osw);

			Document doc = Jsoup.connect("https://www.americanas.com.br/").get();
			Elements ele = doc.select(".card-product-name");
			List<String> l = ele.eachText();
			String p = "";
			
			for(int a = l.size() - 1;a >= 0; a-- ){
				p = p + l.get(a) + ";";
			}
			
			bw.write(p);
			bw.newLine();

			bw.close();
			osw.close();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
