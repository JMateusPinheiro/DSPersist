package dsp.neo4j;
import static org.neo4j.driver.v1.Values.parameters;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;

public class Neo4jController implements AutoCloseable { 
	private final Driver driver;

	public Neo4jController(String uri, String user, String password) {
		driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password)); 
	}

	public void close() throws Exception { 
		driver.close(); 
	} 

	public void createNodes(final String node){
		try (Session session = driver.session()) {
			session.writeTransaction(new TransactionWork <String> () {
				public String execute(Transaction tx) {
					StatementResult result = tx.run("CREATE (a:Node) " + 
							"SET a.node = $node " + 
							"RETURN a.node + ', from node ' + id(a)", 
							parameters("node", node));
					return result.single().get(0).asString();
				}
			});
			System.out.println("Node criado");
		}
	}
	
	public void connectNodes(){
		try (Session session = driver.session()) {
			session.writeTransaction(new TransactionWork <String> () {
				@Override
				public String execute(Transaction tx) {
					tx.run("MATCH "
							+ "(a:Node{node:'0'}),(b:Node{node:'1'}),(c:Node{node:'2'}),(d:Node{node:'3'}),(e:Node{node:'4'}),(f:Node{node:'5'})"
							+ " CREATE " //a:0, b:1, c:2, d:3, e:4, f:5
							+ "(a)-[:CONNECTED_TO { cost : 3.0 }]->(d),"
							+ "(b)-[:CONNECTED_TO { cost : 1.1 }]->(f),"
							+ "(c)-[:CONNECTED_TO { cost : 5.0 }]->(d),"
							+ "(c)-[:CONNECTED_TO { cost : 6.0 }]->(e),"
							+ "(d)-[:CONNECTED_TO { cost : 3.0 }]->(a),"
							+ "(d)-[:CONNECTED_TO { cost : 4.0 }]->(c),"
							+ "(e)-[:CONNECTED_TO { cost : 6.0 }]->(c),"
							+ "(f)-[:CONNECTED_TO { cost : 1.1 }]->(b),"
							+ "(f)-[:CONNECTED_TO { cost : 7.0 }]->(e),"
							+ "(f)-[:CONNECTED_TO { cost : 2.0 }]->(a);");
					return null;
				}
			});
			System.out.println("Relacionamentos criados");
		}
	}
	//MATCH (b:Node{node:'1'}),(e:Node{node:'4'}) ,p = shortestPath((b)-[r:CONNECTED_TO*]-(e)) RETURN p;
	public void shortestPath(){
		try (Session session = driver.session()) {
			session.writeTransaction(new TransactionWork <String> () {
				public String execute(Transaction tx) {
					StatementResult result = tx.run("MATCH (b:Node{node:'1'}),(e:Node{node:'4'}) ,p = shortestPath((b)-[r:CONNECTED_TO*]-(e)) RETURN p");
					System.out.println(result.next());
					return null;
				}
			});
		}
	}
	
	// MATCH p = (:Node{node:'1'})-[*]->(:Node{node:'4'}) return p;
	public void patternPath(){
		try (Session session = driver.session()) {
			session.writeTransaction(new TransactionWork <String> () {
				public String execute(Transaction tx) {
					StatementResult result = tx.run("MATCH p = (:Node{node:'1'})-[*]->(:Node{node:'4'}) return p");
					while(result.hasNext()){
						System.out.println(result.next());
					}
					return null;
				}
			});
		}
	}
	
	public static void main(String...args) throws Exception { 
		try (Neo4jController connect = new Neo4jController("bolt://localhost:7687", "neo4j", "1234")) { 
//			//Criando todos os nodes com função
//			for(int node = 0; node <=5 ; node ++){
//				connect.createNodes(String.valueOf(node));
//			}
//			
//			//criando os relacionamentos
//			connect.connectNodes();
//			
//			connect.shortestPath();
			connect.patternPath();
		}
	} 
}