package com.bankapp.config;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnection {
private static final String PROPS_FILE = "/db.properties"; // on classpath
private static String url;
private static String username;
private static String password;


static {
try (InputStream in = DBConnection.class.getResourceAsStream(PROPS_FILE)) {
Properties props = new Properties();
if (in != null) props.load(in);
url = props.getProperty("jdbc.url", "jdbc:mysql://localhost:3306/bankdb?useSSL=false&serverTimezone=UTC");
username = props.getProperty("jdbc.username", "root");
password = props.getProperty("jdbc.password", "Sharmavathi@64");
// load driver (optional with newer JDBC)
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (Exception e) {
System.err.println("Failed to load DB properties: " + e.getMessage());
// fallback defaults already set
}
}


public static Connection getConnection() throws SQLException {
return DriverManager.getConnection(url, username, password);
}
}