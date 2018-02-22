package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Game;
import services.GameService;

public class GamesOrderByReleaseDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GameService service = new GameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Game> listAllVideoGame = service.OrderByReleaseDate();
		req.getSession().setAttribute("listAllVideoGame", listAllVideoGame);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListGame.jsp");
		dispatcher.forward(req, resp);
	}
}
