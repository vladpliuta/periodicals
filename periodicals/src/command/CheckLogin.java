package command;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connect.DataSource;
import dao.ReaderDAO;
import dto.Reader;

/**
 * выполнение проверки правильности введенных логина и пароля с помощью запроса
 * в БД,
 * 
 * @author Vladimir Pliuta
 *
 */
public class CheckLogin {

	public static String checkEnter(String enterLogin, String enterPassword)
			throws SQLException, IOException, PropertyVetoException {
		String checkResalt = new String();
		Connection conn = DataSource.getInstance().getConnection();
		Reader reader = new ReaderDAO(conn).findByLogin(enterLogin);
		String login = reader.getLogin();
		String password = reader.getPassword();
		int adminFlag = reader.getAdminFlag();
		if (enterLogin.equals(login) && enterPassword.equals(password)) {
			if (adminFlag == 1) {
				checkResalt = "admin";
			} else {
				int idReader = reader.getId();
				checkResalt = Integer.toString(idReader);
			}
		} else {
			checkResalt = "error";
		}
		conn.close();
		return checkResalt;
	}
}
