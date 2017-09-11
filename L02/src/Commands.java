import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Commands {

	public void cat() throws IOException{
		long tempoInicio = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/J.Mateus/Downloads/projeto-dao/Answers.csv"));
		String linha;
		while ((linha = br.readLine()) != null){	
			System.out.println(linha);
			System.out.println("____________________________________________________________________________________________________________________________________________________");
		}	
		br.close();
		System.out.println("TEMPO DECORRIDO: "+(System.currentTimeMillis()-tempoInicio) + " MS");
	}

	public void wc() throws IOException{
		long tempoInicio = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/J.Mateus/Downloads/projeto-dao/Answers.csv"));
		long line = 0;
		long charac = 0;
		long word = 0;
		String linha;
		while ((linha = br.readLine()) != null){
			charac += linha.length();
			line++;
			word += linha.split("[^\\w]+").length;
			word += linha.split(",").length;
		}
		System.out.println("########################");
		System.out.println("WORD COUNT");
		System.out.println("Linhas: " + line);
		System.out.println("Caracteres: " + charac);
		System.out.println("Palavras: " + word);
		System.out.println("#########################");
		br.close();
		System.out.println("TEMPO DECORRIDO: "+(System.currentTimeMillis()-tempoInicio) + " MS");
	}
	public void head(int linhas) throws IOException{
		long tempoInicio = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/J.Mateus/Downloads/projeto-dao/Answers.csv"));
		int i = 0;
		String linha;
		while ((linha =  br.readLine()) != null){
			if(i == linhas){
				break;
			}
			else{
				System.out.println(linha);
				System.out.println("___________________________________________________________________________________________________________________________________");
				i++;
			}

		}
		br.close();
		System.out.println("TEMPO DECORRIDO: "+(System.currentTimeMillis()-tempoInicio) + " MS");
	}
	public void CopiarArquivo() throws IOException{
		long tempoInicio = System.currentTimeMillis();
		FileInputStream input = new FileInputStream("C:/Users/J.Mateus/Downloads/Registrado.jpg");
		FileOutputStream out = new FileOutputStream("C:/Users/J.Mateus/Downloads/Registrado2.jpg");
		int ret = 0;
		byte [] array = new byte[8];
		while(ret > -1){
			ret = input.read(array);
			out.write(array);
			out.flush();
		}
		input.close();
		out.close();
		System.out.println("TEMPO DECORRIDO: "+(System.currentTimeMillis()-tempoInicio) + " MS");
}
}
