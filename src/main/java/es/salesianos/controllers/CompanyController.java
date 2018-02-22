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
	
	@GetMapping("/RegisterCompany")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("RegisterCompany", "command", new Company());
		return modelAndView;
	}
	
	@PostMapping("registercompany")
	public ModelAndView companyInsert(@ModelAttribute Company company) {
		service.insert(company);
		ModelAndView modelAndView = new ModelAndView("RegisterCompany", "command", new Company());
		return modelAndView;
	}
	
	@GetMapping("ListCompanies")
	public ModelAndView listCompanies() {
		ModelAndView modelAndView = new ModelAndView("ListCompanies", "command", new Company());
		modelAndView.addObject("listAllCompanies", service.listAllCompany());
		return modelAndView;
	}
	
	@GetMapping("/RegisterConsole")
	public ModelAndView registerConsole() {
		ModelAndView modelAndView = new ModelAndView("RegisterConsole", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAllCompany());
		return modelAndView;
	}
	
	@GetMapping("/ListConsolesCompanies")
	public ModelAndView listConsolesCompanies() {
		ModelAndView modelAndView = new ModelAndView("ListConsolesCompanies", "command", new Console());
		modelAndView.addObject("listAllCompanies", service.listAllCompany());
		return modelAndView;
	}
}
