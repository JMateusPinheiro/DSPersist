package br.controller;

import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

public class MongoDBController {

	public void addLivro(double isbn, String titulo, String ano_publicacao, 
			double qtd_estoque,double valor, double editora_id, String editora_nome){
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("DSPL07");
		String json = "{'isbn' : '" + isbn + "','titulo' :'" + titulo + "','ano_publicacao':'" + ano_publicacao + "','qtd_estoque':" + qtd_estoque +
				",'valor':" + valor + ",'editora': { 'id':" + editora_id + ",'nome':'" + editora_nome +"'}}";
		Document doc = Document.parse(json);
		MongoCollection<Document> col = db.getCollection("Biblioteca");
		col.insertOne(doc);
		client.close();
	}
	//a) Obter o nome da editora, a quantidade total de livros por editora e o valor total (qtd_estoque * valor) dos livros para cada editora.
	//Somente considerar os livros publicados a partir de 2010.
	public void listarLivros(){
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("DSPL07");
		MongoCollection<Document> col = db.getCollection("Biblioteca");
		for(Document d: col.aggregate(Arrays.asList(
				Aggregates.match(Filters.gte("ano_publicacao", "2010")), 
				Aggregates.group(null, Accumulators.sum("QuantidadeDisponivel", "$qtd_estoque")), 
				Aggregates.project(Projections.excludeId())))){
			System.out.println(d.toJson());
		}
		client.close();
	}
	//b) Obter a quantidade total de livros disponíveis em estoque com valor unitário abaixo de R$ 100,00
	public void totalLivros(){
		MongoClient client = new MongoClient();
		MongoDatabase db = client.getDatabase("DSPL07");
		MongoCollection<Document> col = db.getCollection("Biblioteca");
		for(Document d: col.aggregate(Arrays.asList(
				Aggregates.match(Filters.lt("valor", 100)), 
				Aggregates.group("$editora",
						Accumulators.sum("totalPrice", new Document("$multiply",
								Arrays.asList("$qtd_estoque", "$valor"))))))){
			System.out.println(d.toJson());
		}
		client.close();
	}
}
