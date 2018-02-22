package es.salesianos.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import es.salesianos.models.Company;
import es.salesianos.repositories.CompanyRepository;
import es.salesianos.repositories.GamesRepository;

@Service
@Profile("memory")
public class CompanyService {
	@Autowired
	private CompanyRepository repository;

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
	
	public void insert(Company company) {
 		repository.insertCompany(company);
 	}

	public void delete(String name) {
 		repository.deleteCompany(name);
 	}

}
