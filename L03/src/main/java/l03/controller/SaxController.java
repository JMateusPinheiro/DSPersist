package l03.controller;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import l03.classes.Servico;

public class SaxController extends DefaultHandler{

	private Properties prop = new Properties();
	List<Servico> servs = new ArrayList<Servico>();
	String tempVal;
	Servico serv;

	private void parseDocument () {
		//get a factory 
		SAXParserFactory spf = SAXParserFactory.newInstance();	

		try	{
			prop.load(new FileInputStream("config.properties"));
			// get a new instance of parser	
			SAXParser sp = spf.newSAXParser();	
			//parse	the	file and also register this	class for call backs
			sp.parse(prop.getProperty("caminhoXML"), this);

		} catch(SAXException se)	{
			se.printStackTrace();
		} catch(ParserConfigurationException pce)	{ 
			pce.printStackTrace();
		} catch	(IOException ie){	
			ie.printStackTrace();
		}	

	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes)	throws SAXException {	
		if (qName.equalsIgnoreCase("servico")){
			serv = new Servico();
		}
	}	

	@Override
	public void characters (char[] ch, int start, int length) throws SAXException {
		tempVal = new String (ch,start,length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {	

		if (qName.equalsIgnoreCase("servico"))	{	
			//add it to the list
			servs.add (serv);

		} else if(qName.equalsIgnoreCase("id"))	{
			serv.setId(tempVal);
		} else if(qName.equalsIgnoreCase("dbId"))	{
			serv.setDbId(tempVal);
		} else if (qName.equalsIgnoreCase("nome")){
			serv.setNome(tempVal);
		} else if(qName.equalsIgnoreCase("sigla")){
			serv.setSigla(tempVal);
		} else if(qName.equalsIgnoreCase("descricao")){
			serv.setDescricao(tempVal);
		} else if(qName.equalsIgnoreCase("contato")){
			serv.setContato(tempVal);
		} else if(qName.equalsIgnoreCase("gratuito")){
			serv.setGratuito(tempVal);
		} else if(qName.equalsIgnoreCase("porcentagem-manual")){
			serv.setPorcentagemManual(tempVal);
		}
	}
	
	public void GerarCSV(){
		parseDocument();
		try {
			prop.load(new FileInputStream("config.properties"));
			OutputStream os = new FileOutputStream(prop.getProperty("caminhoSax"), true);	
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw =	new	BufferedWriter(osw);

			String p = "";
			
			for(int a = 0;a <= servs.size(); a++ ){
				p = servs.get(a).getId() + ";" + servs.get(a).getDbId() + ";" + servs.get(a).getNome() + ";" + servs.get(a).getSigla() + ";" +
				servs.get(a).getDescricao() + ";" + servs.get(a).getContato() + ";" + servs.get(a).getGratuito() + ";" + servs.get(a).getPorcentagemManual() + ";";
				bw.write(p);
				bw.newLine();
			}
			
			bw.close();
			osw.close();
			os.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
