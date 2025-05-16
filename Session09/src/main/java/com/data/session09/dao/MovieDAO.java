package com.data.session09.dao;

import com.data.session09.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDAO {
    private final String url = "jdbc:mysql://localhost:3306/session09";
    private final String username = "root";
    private final String password = "12345678";

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Movies";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public Movie getMovieById(Long id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Movies WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getLong("id"));
                movie.setTitle(resultSet.getString("title"));
                movie.setDirector(resultSet.getString("director"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setDescription(resultSet.getString("description"));
                movie.setDuration(resultSet.getInt("duration"));
                movie.setLanguage(resultSet.getString("language"));
                return movie;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
