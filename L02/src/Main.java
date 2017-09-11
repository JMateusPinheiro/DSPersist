import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Commands cm = new Commands();		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.print("~");
				String input = br.readLine();
				if ("exit".equals(input)) {
					System.exit(0);
				} else if("wc".equals(input)){
					cm.wc();
				} else if("cat".equals(input)){
					cm.cat();
				} else if("head".equals(input)){
					cm.head(10);
				} else if("copy".equals(input)){
					cm.CopiarArquivo();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
