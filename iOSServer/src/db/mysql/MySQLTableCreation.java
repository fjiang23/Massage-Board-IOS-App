package db.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class MySQLTableCreation {
	// Run this as Java application to reset db schema.
	public static void main(String[] args) {
		try {
			// Ensure the driver is imported.
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = null;

			try {
				System.out.println("Connecting to \n" + MySQLDBUtil.URL);
				conn = DriverManager.getConnection(MySQLDBUtil.URL);
			} catch (SQLException e) {
				System.out.println("SQLException " + e.getMessage());
				System.out.println("SQLState " + e.getSQLState());
				System.out.println("VendorError " + e.getErrorCode());
			}
			if (conn == null) {
				return;
			}

			// Step 1 Drop tables in case they exist.
			Statement stmt = conn.createStatement();

			String sql = "DROP TABLE IF EXISTS posts";
			stmt.executeUpdate(sql);

			
			// Step 2. Create new tables.
			//sql = "CREATE TABLE posts " + "(user VARCHAR(255) NOT NULL, " + " message VARCHAR(255), "
					//+  "lat FLOAT NOT NULL, " + " lon FLOAT NOT NULL, "+ " PRIMARY KEY ( lat, lon ))";
			sql = "CREATE TABLE posts " + "(user VARCHAR(255) NOT NULL, " + " message VARCHAR(255), "
					+  "lat FLOAT NOT NULL, " + " lon FLOAT NOT NULL)";
			stmt.executeUpdate(sql);

			
			// Step 3: insert data
			// Create a fake user
			sql = "INSERT INTO posts " + "VALUES (\"Alphago\", \"Anybody want to play Go?\", 32.729419, -117.198008)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Rick\", \"I lost my portal gun!\", 32.879092, -117.237716)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Morty\", \"Oh my god!\", 32.868095, -117.236486)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Doraemon\", \"Who want to share Uber with me?\", 32.863963, -117.252546)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Feng\", \"Once apon a time, there is a far far away kingdom\", 32.90, -117.444)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Tour Information\", \"San Diego sits in the extreme south of California on the border with Mexico. The city has miles of beaches and a number of U.S. military facilities as well as the world's busiest land border crossing.\", 32.90, -117.444)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Tom\", \"Welcome to San Diego\", 39, -125.444)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			sql = "INSERT INTO posts " + "VALUES (\"Jerry\", \"I love UCSD\", 38.90, -121.444)";
			System.out.println("Executing query:\n" + sql);
			stmt.executeUpdate(sql);
			
			System.out.println("Import is done successfully.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
