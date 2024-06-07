package service;
import java.util.Base64;


public class PasswordDecoder {
	
	public String encoder(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	public String decoder(String password) {
		return Base64.getDecoder().decode(password).toString();
	}

}
