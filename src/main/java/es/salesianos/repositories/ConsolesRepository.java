package es.salesianos.repositories;

import java.sql.Connection;
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
import es.salesianos.models.Console;

@Repository
public class ConsolesRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private static Logger log = LogManager.getLogger(ConsolesRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public Console search(Console consoleForm) {
		String sql = "SELECT * FROM Console WHERE name = :name";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", consoleForm.getName());
		Console consoles = (Console) template.query(sql, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}

	public void insertConsole(Console consoleForm) {
		String sql = "INSERT INTO Console (name, creationDate)" + "VALUES ( :name, :companyId)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", consoleForm.getName());
		params.addValue("companyId", consoleForm.getCompanyId());
		namedJdbcTemplate.update(sql, params);
	}

	public void update(Console consoleForm) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", consoleForm.getName());
		namedJdbcTemplate.update("DELETE FROM Console WHERE name = :name", params);
		String sql = "INSERT INTO Console (name, creationDate)" + "VALUES ( :name, :companyId)";
		MapSqlParameterSource paramsToInsert = new MapSqlParameterSource();
		paramsToInsert.addValue("name", consoleForm.getName());
		paramsToInsert.addValue("companyId", consoleForm.getCompanyId());
		namedJdbcTemplate.update(sql, paramsToInsert);
	}

	public List<Console> searchAll() {
		String sql = "SELECT * FROM Console";
		List<Console> consoles = template.query(sql, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}

	public List<Console> orderByTitle() {
		String sql = "SELECT * FROM Console ORDER BY title";
		List<Console> consoles = template.query(sql, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}

	public void delete(Console console) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		namedJdbcTemplate.update("DELETE FROM Consoles WHERE name = :name", params);
	}

	public List<Console> selectByCompany(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("company", id);
		List<Console> consoles = template.query("SELECT * FROM Console WHERE company = :company",
				new BeanPropertyRowMapper<Console>(Console.class));
		return consoles;
	}
}
