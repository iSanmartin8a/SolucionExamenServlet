package es.salesianos.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import es.salesianos.assemblers.CompanyAssembler;
import es.salesianos.connections.ConnectionManager;
import es.salesianos.connections.H2Connection;
import es.salesianos.models.Company;
import es.salesianos.repositories.CompanyRepository;

public class CompanyService {
	CompanyAssembler assembler = new CompanyAssembler();
	ConnectionManager manager = new H2Connection();
	private CompanyRepository repository = new CompanyRepository();

	public Company assembleUserFromRequest(HttpServletRequest req) {
		return CompanyAssembler.assembleCompanyFrom(req);
	}

	public void createNewCompanyFromRequest(Company companyForm) {
		repository.insertCompany(companyForm);
	}

	public List<Company> listAllCompany() {
		return repository.searchAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}
