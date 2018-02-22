package es.salesianos.controllers;

import java.util.logging.LogManager;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import es.salesianos.models.Company;
import es.salesianos.models.Console;
import es.salesianos.services.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@GetMapping("/CreateCompany")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("CreateCompany", "command", new Company());
		return modelAndView;
	}
	
	@PostMapping("createCompany")
	public ModelAndView companyInsert(@ModelAttribute Company company) {
		service.insert(company);
		ModelAndView modelAndView = new ModelAndView("CreateCompany", "command", new Company());
		return modelAndView;
	}
	
	@GetMapping("/CreateConsole")
	public ModelAndView registerConsole() {
		ModelAndView modelAndView = new ModelAndView("createConsole", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAllCompany());
		return modelAndView;
	}
	
	@GetMapping("/ListConsoleByCompany")
	public ModelAndView listConsolesCompanies() {
		ModelAndView modelAndView = new ModelAndView("listCompanyConsole", "command", new Console());
		modelAndView.addObject("listAllCompany", service.listAllCompany());
		return modelAndView;
	}
}
