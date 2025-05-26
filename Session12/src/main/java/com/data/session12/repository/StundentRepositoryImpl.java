package com.data.session12.repository;

import com.data.session12.connection.ConnectDB;
import com.data.session12.model.Student;
import com.data.session12.utils.EnumStatus;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StundentRepositoryImpl extends StudentRepository {

    @Override
    public List<Student> findAll() throws SQLException {
        Connection conn = null;
        conn = ConnectDB.getConnection();


        try{
            CallableStatement callSt = conn.prepareCall("CALL find_all_student()");
            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setSex(rs.getBoolean("sex"));
                student.setBod(rs.getDate("bod"));
                student.setAvatar(rs.getString("avatar"));
                student.setStatus(EnumStatus.valueOf(rs.getString("status").toUpperCase()));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }




        return null;

    }
}
