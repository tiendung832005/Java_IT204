package com.data.session19a.repository;

import com.data.session19a.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRepository {
    private final SessionFactory sessionFactory;

    public MovieRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Movie> findAllMovies(int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Movie", Movie.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }

    public void saveMovie(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(movie);
            session.getTransaction().commit();
        }
    }

    public Movie findMovieById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Movie.class, id);
        }
    }

    public void updateMovie(Movie movie) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(movie);
            session.getTransaction().commit();
        }
    }

    public void deleteMovie(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Movie movie = session.get(Movie.class, id);
            if (movie != null) {
                session.delete(movie);
            }
            session.getTransaction().commit();
        }
    }

    public void setMovieStatus(Long id, boolean status) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Movie movie = session.get(Movie.class, id);
            if (movie != null) {
                movie.setStatus(status);
                session.update(movie);
            }
            session.getTransaction().commit();
        }
    }
}