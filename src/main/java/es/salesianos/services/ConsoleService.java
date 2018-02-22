package es.salesianos.services;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import es.salesianos.assemblers.ConsoleAssembler;
import es.salesianos.connections.ConnectionManager;
import es.salesianos.connections.H2Connection;
import es.salesianos.models.Console;
import es.salesianos.repositories.ConsolesRepository;
import es.salesianos.repositories.GamesRepository;

@Service
@Profile("memory")
public class ConsoleService {
	@Autowired
	private ConsolesRepository repository;
	
	ConsoleAssembler assembler = new ConsoleAssembler();
	ConnectionManager manager = new H2Connection();

	public Console assembleUserFromRequest(HttpServletRequest req) {
		return ConsoleAssembler.assembleConsoleFrom(req);
	}

	public void createNewConsoleFromRequest(Console consoleForm) {
		Console consoleInDatabase = repository.search(consoleForm);
		if (consoleInDatabase == null) {
			repository.insertConsole(consoleForm);
		} else {
			repository.update(consoleForm);
		}
	}

	public List<Console> listAllConsoles() {
		return repository.searchAll();
	}

	public List<Console> listOrderByTitle() {
		return repository.orderByTitle();
	}

	public void deleteConsole(Console console) {
		repository.delete(console);
	}

	public ConsolesRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsolesRepository repository) {
		this.repository = repository;
	}

	public List<Console> listAllByCompany(int companyId) {
		return repository.selectByCompany(companyId);
	}
}
