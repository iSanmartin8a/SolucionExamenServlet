package assemblers;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import models.Company;

public class CompanyAssembler {
	
	public static  Company assembleCompanyFrom(HttpServletRequest request) {
		Company company = new Company();
		
		company.setName(request.getParameter("name"));
		company.setCreationDateFromString(request.getParameter("creationDate"));
		return company;
		
	}
}
