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

	@PostMapping("CreateConsole")
	public ModelAndView consoleInsert(@ModelAttribute Console console) {
		service.createNewConsoleFromRequest(console);
		ModelAndView modelAndView = new ModelAndView("CreateConsole", "command", new Console());
		return modelAndView;
	}

	@GetMapping("/ListConsole")
	public ModelAndView listConsoles() {
		ModelAndView modelAndView = new ModelAndView("listConsole", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAllConsoles());
		return modelAndView;
	}

	@PostMapping("/ListConsoleByCompany")
	public ModelAndView listConsolesByCompanies(@ModelAttribute("companyName") int companyId) {
		ModelAndView modelAndView = new ModelAndView("listCompanyConsole", "command", new Console());
		modelAndView.addObject("listAllConsole", service.listAllByCompany(companyId));
		return modelAndView;
	}
}
