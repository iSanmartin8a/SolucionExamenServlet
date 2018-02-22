package es.salesianos.assemblers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import es.salesianos.models.Game;

public class GameAssembler {

	public static Game assembleGameForm(HttpServletRequest request) {
		Game game = new Game();
		game.setTitle(request.getParameter("title"));
		game.setAge(request.getParameter("age"));
		game.setReleaseDateFromString((request.getParameter("releaseDate")));
		return game;
	}
}
