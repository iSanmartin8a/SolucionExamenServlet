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

	@PostMapping("registervideogame")
	public ModelAndView videogameInsert(@ModelAttribute Game game) {
		service.createNewVideoGameFromRequest(game);
		ModelAndView modelAndView = new ModelAndView("RegisterVideogame", "command", new Game());
		return modelAndView;
	}

	@GetMapping("/ListVideogames")
	public ModelAndView listVideogames() {
		ModelAndView modelAndView = new ModelAndView("ListVideogames", "command", new Game());
		modelAndView.addObject("listAllVideogames", service.listAllVideogames());
		return modelAndView;
	}

	@GetMapping("/ListRecommendedAge")
	public ModelAndView recommendedAge() {
		ModelAndView modelAndView = new ModelAndView("ListRecommendedAge");
		modelAndView.addObject("recommendedAge");
		return modelAndView;
	}

	@PostMapping("orderVideogames")
	public ModelAndView order(@ModelAttribute("consoleName") String recommendedAge,
			@ModelAttribute("order") String order) {
		ModelAndView modelAndView = new ModelAndView("ListRecommendedAge", "command", new Game());
		modelAndView.addObject("listAllVideogames", service.OrderByReleaseDate());
		return modelAndView;
	}
}
