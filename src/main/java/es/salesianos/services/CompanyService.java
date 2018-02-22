package es.salesianos.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.assemblers.CompanyAssembler;
import es.salesianos.connections.ConnectionManager;
import es.salesianos.connections.H2Connection;
import es.salesianos.models.Company;
import es.salesianos.repositories.CompanyRepository;
import es.salesianos.repositories.GamesRepository;

@Service
@Profile("memory")
public class CompanyService {
	@Autowired
	private CompanyRepository repository;
	
	CompanyAssembler assembler = new CompanyAssembler();
	ConnectionManager manager = new H2Connection();

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
