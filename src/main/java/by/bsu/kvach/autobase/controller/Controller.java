package by.bsu.kvach.autobase.controller;

import by.bsu.kvach.autobase.command.ActionCommand;
import by.bsu.kvach.autobase.factory.ActionFactory;
import by.bsu.kvach.autobase.resources.ConfigurationManager;
import by.bsu.kvach.autobase.resources.MessageManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String page = null;
		// Определение команды, пришедшей из JSP
		ActionFactory user = new ActionFactory();

		ActionCommand command = user.defineCommand(req);
		page = command.execute(req);

		if (page != null){
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(req, resp);

		}
		else {
			page = ConfigurationManager.getProperty("path.page.index");

			req.getSession().setAttribute("nullPage",
					MessageManager.getProperty("message.nullpage"));
			resp.sendRedirect(req.getContextPath() + page);
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}

