package l03.classes;

import java.io.Serializable;

public class Links implements Serializable{
	
	String rel;
	String href;
	public String getRel(){
		return rel;
	}
	public void setRel(String rel){
		this.rel = rel;
	}
	public String getHref(){
		return href;
	}
	public void setHref(String href){
		this.href = href;
	}

}


