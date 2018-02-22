package connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConnectionManager {
	public Connection open(String jdbcUrl);
	public void close(Connection conn);
	public Connection executeSql(Connection conn, String sql);
	public void close(PreparedStatement prepareStatement);
	public void close(ResultSet resultSet);
}
