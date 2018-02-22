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
import es.salesianos.models.Console;
import es.salesianos.models.Game;

@Repository
public class GamesRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	private static Logger log = LogManager.getLogger(GamesRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public Game search(Game gameForm) {
		String sql = "SELECT * FROM Game WHERE title = :title";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", gameForm.getTitle());
		Game games = (Game) template.query(sql, new BeanPropertyRowMapper(Game.class));
		return games;
	}

	public void insertGame(Game gameForm) {
		String sql = "INSERT INTO Game (title, age, releaseDate, companyId)" + "VALUES ( :title, :age, :releaseDate, :companyId)";
		MapSqlParameterSource paramsToInsert = new MapSqlParameterSource();
		paramsToInsert.addValue("title", gameForm.getTitle());
		paramsToInsert.addValue("age", gameForm.getAge());
		paramsToInsert.addValue("releaseDate", gameForm.getReleaseDate());
		paramsToInsert.addValue("companyId", gameForm.getCompanyId());
		namedJdbcTemplate.update(sql, paramsToInsert);
	}

	public List<Game> searchAll() {
		String sql = "SELECT * FROM Game";
		List<Game> games = template.query(sql, new BeanPropertyRowMapper(Game.class));
		return games;
	}

	public List<Game> orderByTitle() {
		String sql = "SELECT * FROM Game ORDER BY title";
		List<Game> games = template.query(sql, new BeanPropertyRowMapper(Game.class));
		return games;
	}

	public List<Game> orderByReleaseDate() {
		String sql = "SELECT * FROM Game ORDER BY releaseDate";
		List<Game> games = template.query(sql, new BeanPropertyRowMapper(Game.class));
		return games;
	}

	public void delete(Game gameForm) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", gameForm.getTitle());
		namedJdbcTemplate.update("DELETE FROM Game WHERE title = :title", params);
	}

	public void update(Game gameForm) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", gameForm.getTitle());
		namedJdbcTemplate.update("DELETE FROM Game WHERE title = :title", params);
		String sql = "INSERT INTO Game (title, age, releaseDate, companyId)" + "VALUES ( :title, :age, :releaseDate, :companyId)";
		MapSqlParameterSource paramsToInsert = new MapSqlParameterSource();
		paramsToInsert.addValue("title", gameForm.getTitle());
		paramsToInsert.addValue("age", gameForm.getAge());
		paramsToInsert.addValue("releaseDate", gameForm.getReleaseDate());
		paramsToInsert.addValue("companyId", gameForm.getCompanyId());
		namedJdbcTemplate.update(sql, paramsToInsert);
	}

	public List<Game> selectByCompany(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("company", id);
		List<Game> games = template.query("SELECT * FROM Game WHERE company = :company",
				new BeanPropertyRowMapper<Game>(Game.class));
		return games;
	}
}
