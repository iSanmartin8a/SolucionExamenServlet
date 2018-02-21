package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {

	private int iD;
	private String name;
	private Date creationDate;
	
	public int getId() {
		return iD;
	}

	public void setId(int iD) {
		this.iD = iD;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public void setCreationDateFromString(String creationDate2) {
		SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = textFormat.parse(creationDate2);
		}catch(ParseException ex){
			ex.printStackTrace();
		}
		this.creationDate = date;
	}
	
}
