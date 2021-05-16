package com.example.demo;

import java.sql.*;
import java.util.ArrayList;

public class SpecialDayDAO {
    private String m_conn;

    public SpecialDayDAO(String m_conn){
        this.m_conn = m_conn;
    }

    public ArrayList<SpecialDay> getAllSpecialDays(){

        ArrayList<SpecialDay> specialDays = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {

            if (conn != null) {

                String sql = "SELECT * FROM Days_Special";

                Statement stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    SpecialDay e = new SpecialDay(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("day"),
                            rs.getInt("month"));
                    specialDays.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  specialDays;
    }

    public SpecialDay getSpecialDayById (int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "SELECT * FROM Days_Special WHERE id = " + id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()){
                    SpecialDay specialDay = new SpecialDay(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("day"),
                            rs.getInt("month"));
                    return specialDay;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void insertSpecialDay(SpecialDay specialDay){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("INSERT INTO Days_Special (name, day, month)" +
                                " VALUES ('%s', %d, %d)", specialDay.getName(), specialDay.getDay(),
                        specialDay.getMonth());
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateSpecialDay(SpecialDay specialDay, int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = String.format("UPDATE Days_Special SET " +
                                "name = '%s', " +
                                "day = %d, " +
                                "month = %d " +
                                "WHERE id = %d", specialDay.getName(), specialDay.getDay(),
                        specialDay.getMonth(), id);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteSpecialDay(int id){
        try (Connection conn = DriverManager.getConnection(m_conn)){
            if(conn != null) {
                String sql = "DELETE FROM Days_Special WHERE id = " + id;
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
