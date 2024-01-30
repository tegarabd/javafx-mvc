package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import database.Connect;

public class User {

	private int id;
	private String username;
	private String password;

	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static User getUserByUsernameAndPassword(String username, String password) {
		String query = String.format("SELECT * FROM user WHERE username = '%s' AND password = '%s'", username, password);
		ResultSet resultSet = Connect.getConnection().executeQuery(query);
		
		try {
			if (resultSet.next()) {
				return new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Vector<User> getUsers() {
		String query = "SELECT * FROM user";
		ResultSet resultSet = Connect.getConnection().executeQuery(query);
		Vector<User> users = new Vector<User>();

		try {
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("username"),
						resultSet.getString("password")));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void addUser(User user) {
		String query = "INSERT INTO user VALUES(null, '" + user.getUsername() + "', '" + user.getPassword() + "')";
		Connect.getConnection().executeUpdate(query);
	}

}
