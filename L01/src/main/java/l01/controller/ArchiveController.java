package l01.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import l01.Model.Contato;

@Controller
public class ArchiveController {

	private Properties prop = new Properties();

	@RequestMapping("/")
	public String Formulario(){
		return "index";
	}

	@PostMapping("CriarCSV")
	public String CriarCSV(Contato contato) throws IOException{
		String ch = contato.getNome() + "," + contato.getEndereco() + "," + contato.getTelefone() + "," + contato.getEmail();
		prop.load(new FileInputStream("config.properties"));
		OutputStream os = new FileOutputStream(prop.getProperty("caminhoArquivo"));	
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw =	new	BufferedWriter(osw);
		System.out.println(ch);

		bw.write(ch);
		bw.newLine();

		bw.close();
		osw.close();
		os.close();
		return "redirect:/";
	}

	@RequestMapping("VerCSV")
	public String VerCSV(HttpServletRequest sr) throws IOException{
		sr.setAttribute("contatos", LerCSV());
		System.out.println(LerCSV());
		return "VerCSV";
	}

	public List<Contato> LerCSV() throws IOException{
		List<Contato> listaContatos = new ArrayList<Contato>();
		Contato contato = null;
		prop.load(new FileInputStream("config.properties"));
		InputStream is = new FileInputStream(prop.getProperty("caminhoArquivo"));
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String linha;
		if((linha = br.readLine()) != null){ 
			while((linha = br.readLine()) != null){
				String [] Contatos = linha.split(",");
				contato = new Contato();
				contato.setNome(Contatos[0]);
				contato.setEndereco(Contatos[1]);
				contato.setTelefone(Contatos[2]);
				contato.setEmail(Contatos[3]);
				listaContatos.add(contato);
			}
		}
		br.close();
		isr.close();
		is.close();
		return listaContatos;
	}
}
