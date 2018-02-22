package es.salesianos.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {
	private int Id;
	private String name;
	private Date creationDate;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
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
		} catch (ParseException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		this.creationDate = date;
	}
}
