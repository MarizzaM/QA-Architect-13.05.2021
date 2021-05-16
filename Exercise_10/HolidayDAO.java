package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class HolidayDAO {

    private String m_conn;

    public HolidayDAO(String m_conn){
        this.m_conn = m_conn;
    }

    public ArrayList<Holiday> getAllHolidays(){

        ArrayList<Holiday> holidays = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM Holidays";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Holiday e = new Holiday(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("day"),
                            rs.getInt("month"),
                            rs.getInt("length"));
                    holidays.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  holidays;
    }

    public Holiday getHolidayById (int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM Holidays WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    Holiday holiday = new Holiday(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("day"),
                            rs.getInt("month"),
                            rs.getInt("length"));
                    return holiday;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertHoliday(Holiday holiday){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("INSERT INTO Holidays (name, day, month, length)" +
                                " VALUES ('%s', %d, %d, '%d')", holiday.getName(), holiday.getDay(),
                        holiday.getMonth(), holiday.getLength());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateHoliday(Holiday holiday, int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("UPDATE Holidays SET " +
                                "name = '%s', " +
                                "day = %d, " +
                                "month = %d, " +
                                "length = %d" +
                                " WHERE id = %d", holiday.getName(), holiday.getDay(),
                        holiday.getMonth(), holiday.getLength(), id);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteHoliday(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "DELETE FROM Holidays WHERE id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
