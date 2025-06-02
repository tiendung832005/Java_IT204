package com.data.session16.DAO;

import com.data.session16.connection.ConnectionDB;
import com.data.session16.model.Resume;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class ResumeDAO {

    public List<Resume> getAllResumes() throws SQLException{
        List<Resume> resumes = new ArrayList<>();
        String query = "SELECT * FROM resumes";

        try(Connection connection = ConnectionDB .openConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                Resume resume = new Resume(
                        resultSet.getLong("id"),
                        resultSet.getString("fullName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("education"),
                        resultSet.getString("experience"),
                        resultSet.getString("skills")
                );
                resumes.add(resume);
            }
        }
        return resumes;
    }

    public void saveResume(Resume resume) throws SQLException {
        String query = "INSERT INTO resumes (fullName, email, phoneNumber, education, experience, skills) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = ConnectionDB.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, resume.getFullName());
            preparedStatement.setString(2, resume.getEmail());
            preparedStatement.setString(3, resume.getPhoneNumber());
            preparedStatement.setString(4, resume.getEducation());
            preparedStatement.setString(5, resume.getExperience());
            preparedStatement.setString(6, resume.getSkills());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteResume(long id) throws SQLException {
        String query = "DELETE FROM resumes WHERE id = ?";

        try(Connection connection = ConnectionDB.openConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
