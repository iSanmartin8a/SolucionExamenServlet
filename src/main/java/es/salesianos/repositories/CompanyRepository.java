package es.salesianos.repositories;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import es.salesianos.models.Company;

@Repository
public class CompanyRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	
	private static Logger log = LogManager.getLogger(CompanyRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insertCompany(Company companyForm) {
		String sql = "INSERT INTO Company (name, creationDate)" + "VALUES ( :name, :creationDate)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", companyForm.getName());
		params.addValue("creationDate", companyForm.getCreationDate());
		namedJdbcTemplate.update(sql, params);
	}

	public List<Company> searchAll() {
		String sql = "SELECT * FROM Company";
		List<Company> companies = template.query(sql, new BeanPropertyRowMapper(Company.class));
		return companies;
	}
}
