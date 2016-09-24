package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.ActionCommand;
import command.ActionFactory;
import resource.ConfigurationManager;
import resource.MessageManager;

/**
 * контроллер запросов
 * единственный сервлет в программе
 * использует паттерн command
 * обрабатывает только post запросы
 * @author Vladimir Pliuta
 *
 */
@WebServlet(name = "Servlet", urlPatterns = "/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		ActionFactory client = new ActionFactory();
		ActionCommand command = client.defineCommand(request);
		page = command.execute(request);

		if (page == null) {
			page = ConfigurationManager.getProperty("page.error");
			request.getSession().setAttribute("error", MessageManager.getProperty("message.nullpage"));
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
}
