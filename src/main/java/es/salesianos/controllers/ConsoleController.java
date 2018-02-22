package es.salesianos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.models.Console;
import es.salesianos.models.Game;
import es.salesianos.services.ConsoleService;

public class ConsoleController {

	@Autowired
	private ConsoleService service;

	@PostMapping("registerconsole")
	public ModelAndView consoleInsert(@ModelAttribute Console console) {
		service.createNewConsoleFromRequest(console);
		ModelAndView modelAndView = new ModelAndView("RegisterConsole", "command", new Console());
		return modelAndView;
	}

	@GetMapping("/ListConsoles")
	public ModelAndView listConsoles() {
		ModelAndView modelAndView = new ModelAndView("ListConsoles", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAllConsoles());
		return modelAndView;
	}

	@GetMapping("/RegisterVideogame")
	public ModelAndView registerVideogame() {
		ModelAndView modelAndView = new ModelAndView("RegisterVideogame", "command", new Game());
		modelAndView.addObject("listAllConsoles", service.listAllConsoles());
		return modelAndView;
	}

	@GetMapping("/ListVideogamesConsoles")
	public ModelAndView listVideogamesConsoles() {
		ModelAndView modelAndView = new ModelAndView("ListVideogamesConsoles", "command", new Game());
		modelAndView.addObject("listAllConsoles", service.listAllConsoles());
		return modelAndView;
	}

	@PostMapping("/listConsolesByCompany")
	public ModelAndView listConsolesByCompanies(@ModelAttribute("companyName") int companyId) {
		ModelAndView modelAndView = new ModelAndView("ListConsolesCompanies", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAllByCompany(companyId));
		return modelAndView;
	}

}
