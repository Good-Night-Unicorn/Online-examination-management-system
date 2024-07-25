package com.demo.dao;

import com.demo.ontity.JdbcUtil;
import com.demo.ontity.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private JdbcUtil util = new JdbcUtil();

    public int add(Question question) {

        String sql = "insert into question(title,optionA,optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public List findAll() {
        String sql = "select * from question";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userlist = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionID = rs.getInt(1);
                String title = rs.getString(2);
                String optionA = rs.getString(3);
                String optionB = rs.getString(4);
                String optionC = rs.getString(5);
                String optionD = rs.getString(6);
                String answer = rs.getString(7);
                Question question = new Question(questionID, title, optionA, optionB, optionC, optionD, answer);
                userlist.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            {
                util.close();
            }
        }
        return userlist;
    }

    public int delete(String questionID) {
        String sql = "delete from question where questionID=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setInt(1, Integer.parseInt(questionID));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    public Question findByID(String questionID) {
        String sql = "select * from question where questionID=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        Question question = null;
        try {
            ps.setInt(1, Integer.parseInt(questionID));
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionId = rs.getInt(1);
                String title = rs.getString(2);
                String optionA = rs.getString(3);
                String optionB = rs.getString(4);
                String optionC = rs.getString(5);
                String optionD = rs.getString(6);
                String answer = rs.getString(7);
                question = new Question(questionId, title, optionA, optionB, optionC, optionD, answer);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }

        return question;
    }

    public int update(Question question) {

        String sql = "update question set title=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where questionID=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {

            ps.setString(1, question.getTitle());
            ps.setString(2, question.getOptionA());
            ps.setString(3, question.getOptionB());
            ps.setString(4, question.getOptionC());
            ps.setString(5, question.getOptionD());
            ps.setString(6, question.getAnswer());
            ps.setInt(7, question.getQuestionID());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;

    }

    public List findRand() {
        String sql = "select * from question order by rand() limit 0,4";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List userlist = new ArrayList();
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                Integer questionID = rs.getInt(1);
                String title = rs.getString(2);
                String optionA = rs.getString(3);
                String optionB = rs.getString(4);
                String optionC = rs.getString(5);
                String optionD = rs.getString(6);
                String answer = rs.getString(7);
                Question question = new Question(questionID, title, optionA, optionB, optionC, optionD, answer);
                userlist.add(question);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            {
                util.close();

            }
        }
        return userlist;
    }

}

