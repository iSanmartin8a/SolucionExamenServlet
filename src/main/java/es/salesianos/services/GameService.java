package es.salesianos.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import es.salesianos.assemblers.GameAssembler;
import es.salesianos.models.Game;
import es.salesianos.repositories.GamesRepository;

@Service
@Profile("memory")
public class GameService {
	@Autowired
	private GamesRepository repository;
	GameAssembler assembler = new GameAssembler();

	public Game assembleUserFromRequest(HttpServletRequest req) {
		return GameAssembler.assembleGameForm(req);
	}

	public void createNewVideoGameFromRequest(Game gameForm) {
		Game gameDB = repository.search(gameForm);
		if (gameDB == null) {
			repository.insertGame(gameForm);
		} else {
			repository.update(gameForm);
		}
	}

	public List<Game> listAllVideogames() {
		return repository.searchAll();
	}

	public List<Game> OrderByTitle() {
		return repository.orderByTitle();
	}

	public List<Game> OrderByReleaseDate() {
		return repository.orderByReleaseDate();
	}

	public void deleteVideoGame(Game game) {
		repository.delete(game);
	}

	public GamesRepository getRepository() {
		return repository;
	}

	public void setRepository(GamesRepository repository) {
		this.repository = repository;
	}

	public List<Game> listAllByCompany(int companyId) {
		return repository.selectByCompany(companyId);
	}
}
