package ung.mccb.csci.csci330.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Car {

    private String make;
    private String model;
    private String year;
    private String color;
    private String tag;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int saveRecord(){
        int affectedRow=0;
        String query = "insert into car" + "(tag, make, model, color, year)"
                + "values(?,?,?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
            sqlStatement.setString(1, getTag());
            sqlStatement.setString(2, getMake());
            sqlStatement.setString(3, getModel());
            sqlStatement.setString(4, getYear());
            sqlStatement.setString(5, getColor());


            // get the number of return rows
            affectedRow = sqlStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Status: operation failed due to " + e);

        }
        return affectedRow;

    }
    }

