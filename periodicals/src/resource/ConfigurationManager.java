package resource;

import java.util.ResourceBundle;

/**
 * классы, извлекающий из properties информацию о адресах jsp
 * 
 * @author Vladimir Pliuta
 *
 */
public class ConfigurationManager {
	private final static ResourceBundle resource = ResourceBundle.getBundle("resource.config");

	private ConfigurationManager() {
	}

	public static String getProperty(String key) {
		return resource.getString(key);
	}
}
