package l01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);

		Properties prop = new Properties();
		try {
			prop.setProperty("caminhoArquivo", "/Users/J.Mateus/Documents/Eclipse Workspaces/DSPP/L01/src/Contatos.csv");
			prop.store(new FileOutputStream("config.properties"), null);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

