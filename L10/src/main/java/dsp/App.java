package dsp;

import java.util.HashMap;
import java.util.Map;

import dsp.controllers.RedisController;
import dsp.model.Article;

public class App {

	public static void main(String[] args) {

		RedisController redisController = new RedisController();
		Map<String, String> m = new HashMap<String, String>();
		
		Article art1 = new Article("article1", "Descrição 2","nomearquivo1.txt", "11/12/2678");
		Article art2 = new Article("article2", "Descrição 2","nomearquivo2.txt", "10/12/2089");
//		
//		m.put("name", art1.getName() );
//		m.put("description", art1.getDescription());
//		m.put("filename", art1.getFilename() );
//		m.put("posting_date", art1.getPosting_date());
//
//		redisController.insertKeyValueHash(art1.getName(), m);
//		
//		m.put("name", art2.getName() );
//		m.put("description", art2.getDescription());
//		m.put("filename", art2.getFilename() );
//		m.put("posting_date", art2.getPosting_date());
//		// add uma tag nova
//		m.put("new-tag", "New tag");
//		
//		redisController.insertKeyValueHash(art2.getName(), m);
//
//		redisController.getAllTagsValuesArticle("art:" + art1.getName());
//		System.out.println();
//		redisController.getAllTagsValuesArticle("art:" + art2.getName());
//		System.out.println("\nall articles");
//		redisController.getArticles();
//		
//		redisController.getAllTagsArticle(art1.getName());
//		redisController.getAllTagsArticle(art2.getName());
//		
//		redisController.nameDescAllArticles();
		
		
	}
}