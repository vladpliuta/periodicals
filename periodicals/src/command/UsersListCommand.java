package command;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import connect.DataSource;
import dao.ReaderDAO;
import dto.Reader;
import resource.ConfigurationManager;

/**
 * команда отображения списка всех пользователей (извлекая их из БД) для
 * страницы админа
 * 
 * @author Vladimir Pliuta
 *
 */
public class UsersListCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		try {
			page = ConfigurationManager.getProperty("page.usersList");
			Connection conn = DataSource.getInstance().getConnection();
			List<Reader> usersList = new ReaderDAO(conn).findAll();
			request.setAttribute("usersList", usersList);
			conn.close();
		} catch (SQLException e) {
			request.getSession().setAttribute("error", e);
			page = ConfigurationManager.getProperty("page.error");
		} catch (IOException e) {
			request.getSession().setAttribute("error", e);
			page = ConfigurationManager.getProperty("page.error");
		} catch (PropertyVetoException e) {
			request.getSession().setAttribute("error", e);
			page = ConfigurationManager.getProperty("page.error");
		}
		return page;
	}
}
