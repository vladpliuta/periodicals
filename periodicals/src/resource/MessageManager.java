package resource;

import java.util.ResourceBundle;

/**
 * классы, извлекающий из properties сообщения
 * 
 * @author Vladimir Pliuta
 *
 */
public class MessageManager {
	private final static ResourceBundle resource = ResourceBundle.getBundle("resource.messages");

	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resource.getString(key);
	}
}
