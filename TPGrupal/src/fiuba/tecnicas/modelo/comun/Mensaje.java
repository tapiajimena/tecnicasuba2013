package fiuba.tecnicas.modelo.comun;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Mensaje {

	private static Properties prop;
	
	static {
	    prop = new Properties();
	    InputStream in = Mensaje.class.getResourceAsStream("mensajes.properties");
	    try {
			prop.load(in);
		    in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getMensaje(String key) {
		//Default value en vacio por si no encuentra la property.
		return prop.getProperty(key,"");
	}
}
