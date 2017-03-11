package facade;

import entity.Person;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultPersonDao implements PersonDAO {

	private DataSource dataSource;

	@Override
	public Person getByID(long id) {

		String sql = "Select * from Person where PersonID = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Person person = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				person = new Person();
				person.setPersonID(resultSet.getLong(1));
				person.setFirstName(resultSet.getString(2));
				person.setLastName(resultSet.getString(3));
				person.setBirthDate(resultSet.getTimestamp(4));
			}
			return person;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) resultSet.close();
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return person;
	}

	@Override
	public void insert(Person person) {
		String sql = "insert into Person (PersonID, FirstName, LastName, BirthDate) values (?, ?, ?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, person.getPersonID());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getLastName());
			statement.setTimestamp(4, person.getBirthDate());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void update(Person person) {
		String sql = "update Person set FirstName = ?, LastName = ?, BirthDate = ? where PersonID = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setTimestamp(3, person.getBirthDate());
			statement.setLong(4, person.getPersonID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void delete(long id) {
		String sql = "delete from Person where PersonID = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) statement.close();
				if (connection != null) connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
