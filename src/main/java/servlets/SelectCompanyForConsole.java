package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Company;
import services.CompanyService;

public class SelectCompanyForConsole extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CompanyService service = new CompanyService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Company> listAllCompany = service.listAllCompany();
		req.setAttribute("listAllCompany", listAllCompany);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListConsoleByCompany.jsp");
		dispatcher.forward(req, resp);
	}
}
