package dao;
import java.util.HashMap;
import java.util.Map;

public class Valor_barramenu {
	private Map<String,String> menu;
	private Map<String,String> dropbox;
	
	public Valor_barramenu() {
		menu=new HashMap<String,String>();
		this.menu.put("Eletro", "/Eletro");
		this.menu.put("Informatica", "/Informatica");
		this.menu.put("SmartPhones", "/SmartPhones");
		this.menu.put("Ar e Ventilação", "/Ar");
		this.menu.put("Games", "/Games");
		
		dropbox=new HashMap<String,String>();
		this.dropbox.put("Eletro", "/Eletro");
		this.dropbox.put("Informatica", "/Informatica");
		this.dropbox.put("SmartPhones", "/SmartPhones");
		this.dropbox.put("Ar e Ventilação", "/Ar");
		this.dropbox.put("Games", "/Games");
	}
	
	public Map<String,String> getMenu(){		
		return this.menu;
	}
	
	public Map<String,String> getDrop(){		
		return this.menu;
	}


}
