package dsp;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class SimpleClient {
	private Cluster cluster;
	private Session session;

	public void connect(String node) {
		cluster = Cluster.builder().addContactPoint(node).build();
		session = cluster.connect();
	}
	public void close() {
		cluster.close();
	}
	public void insertData() {
		session.execute("INSERT INTO twissandra.users (username , password ) VALUES ('José', '1234');");
		session.execute("INSERT INTO twissandra.users (username , password ) VALUES ('Maria', '1234');");
		session.execute("INSERT INTO twissandra.users (username , password ) VALUES ('Mara','1234');");
		session.execute("INSERT INTO twissandra.users (username , password ) VALUES ('Mateus', '1234');");
		session.execute("INSERT INTO twissandra.users (username , password ) VALUES ('Marcos', '1234');");
		System.out.println("Inserido com sucesso");
	}
	public static void main(String[] args) {
		SimpleClient client = new SimpleClient();
		client.connect("127.0.0.1");
		client.insertData();
		client.close();
	}
}