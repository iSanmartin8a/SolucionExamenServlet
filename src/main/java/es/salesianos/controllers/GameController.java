package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.models.Game;
import es.salesianos.services.GameService;

public class GameController {
	@Autowired
	private GameService service;

	@PostMapping("createGame")
	public ModelAndView videogameInsert(@ModelAttribute Game game) {
		service.createNewVideoGameFromRequest(game);
		ModelAndView modelAndView = new ModelAndView("createGame", "command", new Game());
		return modelAndView;
	}

	@GetMapping("/ListGame")
	public ModelAndView listVideogames() {
		ModelAndView modelAndView = new ModelAndView("listGame", "command", new Game());
		modelAndView.addObject("listAllVideoGames", service.listAllVideogames());
		return modelAndView;
	}

	@PostMapping("/ListGame")
	public ModelAndView recommendedAge(@ModelAttribute("consoleName") String title,
			@ModelAttribute("order") String order) {
		ModelAndView modelAndView = new ModelAndView("orderByTitle", "command", new Game());
		modelAndView.addObject("listAllVideoGames", service.OrderByTitle());
		return modelAndView;
	}

	@PostMapping("ListGame")
	public ModelAndView order(@ModelAttribute("consoleName") String recommendedAge,
			@ModelAttribute("order") String order) {
		ModelAndView modelAndView = new ModelAndView("orderByReleaseDate", "command", new Game());
		modelAndView.addObject("listAllVideogames", service.OrderByReleaseDate());
		return modelAndView;
	}
}
