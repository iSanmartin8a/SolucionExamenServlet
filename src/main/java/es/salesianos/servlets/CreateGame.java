package es.salesianos.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.models.Console;
import es.salesianos.models.Game;
import es.salesianos.services.ConsoleService;
import es.salesianos.services.GameService;

public class CreateGame extends HttpServlet {
	private GameService service = new GameService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Game game = service.assembleUserFromRequest(req);
		service.createNewVideoGameFromRequest(game);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateVideogame.jsp");
		dispatcher.forward(req, resp);
	}

	public GameService getService() {
		return service;
	}

	public void setVideogameService(GameService service) {
		this.service = service;
	}
}
