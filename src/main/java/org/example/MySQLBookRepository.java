package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLBookRepository {

    public void save(Book book) {

        String sql = "INSERT INTO books(isbn, title, author) VALUES ('%s', '%s', '%s')"
                .formatted(book.getIsbn(), book.getTitle(), book.getAuthor());

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
