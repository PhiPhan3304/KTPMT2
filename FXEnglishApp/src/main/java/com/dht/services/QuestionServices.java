/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dht.services;

import com.dht.pojo.Choice;
import com.dht.pojo.JdbcUtils;
import com.dht.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionServices {

    public List<Question> getQuestions(int limit, String kw) throws SQLException {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            PreparedStatement stm;
            String sql;

            if (limit == 0) {
                sql = "SELECT * FROM question WHERE content like concat('%', ?, '%')";
                if(kw == null)
                    kw = "";
                stm = conn.prepareCall(sql);
                stm.setString(1, kw);
            } else {
                sql = "SELECT * FROM question ORDER BY rand() LIMIT ?";
                stm = conn.prepareCall(sql);
                stm.setInt(1, limit);

            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                questions.add(q);
            }
        }

        return questions;
    }

    public List<Choice> getChoices(String questionId) throws SQLException {
        List<Choice> results = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()) {
            String sql = "SELECT * FROM choice WHERE question_id=?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, questionId);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"),
                        rs.getBoolean("is_correct"), rs.getString("question_id"));

                results.add(c);
            }

            return results;
        }
    }
}
