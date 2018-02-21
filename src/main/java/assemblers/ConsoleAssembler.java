package assemblers;

import javax.servlet.http.HttpServletRequest;

import models.Console;

public class ConsoleAssembler {
	
	public static Console assembleConsoleFrom(HttpServletRequest request) {
		
		Console console = new Console();
		
		console.setName(request.getParameter("name"));
		console.setCompanyId(Integer.parseInt(request.getParameter("company")));
		return console;
		
	}
}
