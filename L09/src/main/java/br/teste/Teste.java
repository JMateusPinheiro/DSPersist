package br.teste;

import br.controller.MongoDBController;

public class Teste {
	public static void main(String[] args) {
		MongoDBController mc = new MongoDBController();
		mc.addLivro(888, "Teste", "2017", 3, 90.00, 10, "Jubileu");
		mc.totalLivros();
		mc.listarLivros();
	} 
}