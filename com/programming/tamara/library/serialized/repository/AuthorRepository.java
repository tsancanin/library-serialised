package programming.tamara.library.serialized.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import programming.tamara.library.serialized.model.Author;
import programming.tamara.library.serialized.util.DataBaseConnection;

public class AuthorRepository {
	
	public static List<Author> selectAll() throws Exception {
		
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT idAuthor,name, surname FROM Authors";

			stmt = DataBaseConnection.conn.createStatement();
			rset = stmt.executeQuery(query);
			ArrayList<Author> authors =  new ArrayList<Author>();
			
			while (rset.next()) {
				Author author = new Author(rset.getInt(1),rset.getString(2),rset.getString(3));
				authors.add(author);
			}
			return authors;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new Exception("Greska u SQL upitu!");
		} finally {
			try {rset.close();} catch (SQLException ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (SQLException ex1) {ex1.printStackTrace();}
		}
	}

}
