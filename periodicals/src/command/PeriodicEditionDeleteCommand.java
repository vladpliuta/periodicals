package command;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import connect.DataSource;
import dao.PeriodicEditionDAO;
import dto.PeriodicEdition;
import resource.ConfigurationManager;

/**
 * команда удаления периодического издания из БД
 * 
 * @author Vladimir Pliuta
 *
 */
public class PeriodicEditionDeleteCommand implements ActionCommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = null;
		String idString = request.getParameter("id");
		int id = Integer.valueOf(idString);

		try {
			page = ConfigurationManager.getProperty("page.periodicEditionsAdmin");
			Connection conn = DataSource.getInstance().getConnection();
			conn.setAutoCommit(false);
			PeriodicEditionDAO periodicEdition = new PeriodicEditionDAO(conn);
			boolean delete = periodicEdition.delete(id);
			if (delete) {
				List<PeriodicEdition> periodicEditions = new PeriodicEditionDAO(conn).findAll();
				request.setAttribute("periodicEditionsList", periodicEditions);
			}
			conn.commit();
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
