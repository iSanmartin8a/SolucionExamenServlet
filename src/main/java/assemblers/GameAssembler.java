package assemblers;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import models.Game;

public class GameAssembler {
	
	public static Game assembleGameForm(HttpServletRequest request) {
		Game game = new Game();
		game.setTitle(request.getParameter("title"));
		game.setAge(request.getParameter("age"));
		game.setReleaseDateFromString((request.getParameter("releaseDate")));
		return game;
	}
}
