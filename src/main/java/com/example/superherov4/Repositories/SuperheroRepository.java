package com.example.superherov4.Repositories;

import com.example.superherov4.DTO.CitySuperhero;
import com.example.superherov4.DTO.SuperheroPowerByName;
import com.example.superherov4.Model.Superhero;
import com.example.superherov4.Model.SuperheroPowerCount;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository ("Superhero_DB")
public class SuperheroRepository implements ISuperheroRepository {

    @Value("${spring.datasource.url}")
    private  String db_url;

    @Value("${spring.datasource.username}")
    private  String uid;

    @Value("${spring.datasource.password}")
    private  String pwd;

    public List<Superhero> getSuperheroAll() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url,uid,pwd))
        {
            String SQL = "SELECT * FROM superhero;";
            Statement stnt = con.createStatement();
            ResultSet rs = stnt.executeQuery(SQL);
            while (rs.next()) {
                int id = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");

                superheroes.add(new Superhero(id, heroName, realName, creationYear));
            }
            return superheroes;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Superhero getSuperhero(String name) {
        Superhero superhero1 = null;

        try (Connection con = DriverManager.getConnection(db_url,uid,pwd)){
            String SQL = "SELECT * FROM superhero WHERE heroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superhero1 = new Superhero(id, heroName,realName, creationYear);
            }
            return superhero1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public List<SuperheroPowerCount> getSuperheroPower(String name) {
        List<SuperheroPowerCount> superheroObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url,uid,pwd)){
            String SQL = "SELECT heroName, realName, COUNT(*) AS numPowers FROM Superhero_Superpower JOIN superhero ON Superhero.superheroID = superhero_superpower.superheroID WHERE heroName = ? GROUP BY Superhero.superheroID;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int numPower = rs.getInt("numPowers");
                superheroObj.add(new SuperheroPowerCount(heroName,realName,numPower));
            }
            return superheroObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   }

   public List<SuperheroPowerByName> getSuperheroPowerByName(String name) {
        List<SuperheroPowerByName> powerObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url,uid,pwd)){
            String SQL = "SELECT heroName, realName, superpowerName FROM superpower " +
                    "JOIN Superhero JOIN Superhero_superpower ON " +
                    "superpower.superpowerID = superhero_superpower.superpowerID AND " +
                    "superhero.superheroID = superhero_superpower.superheroID " +
                    "WHERE superhero.heroName = ?;";
        PreparedStatement pstmt = con.prepareStatement(SQL);
        pstmt.setString(1,name);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String heroName = rs.getString("heroName");
            String realName = rs.getString("realName");
            String superpowerName = rs.getString("superpowerName");
            powerObj.add(new SuperheroPowerByName(heroName,realName,superpowerName));
        }
        return powerObj;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
   }

   public List<CitySuperhero> getSuperheroCity(String name) {
        List<CitySuperhero> cityObj = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(db_url,uid,pwd)){
            String SQL = "SELECT heroName, cityName FROM superhero JOIN City JOIN City_superhero ON " +
                    "City.cityID = city_superhero.cityID AND " +
                    "superhero.superheroID = city_superhero.superheroID " +
                    "WHERE superhero.heroName = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String heroName = rs.getString("heroName");
                String cityName = rs.getString("cityName");
                cityObj.add(new CitySuperhero(heroName,new ArrayList<>(List.of(heroName))));
            }
            return cityObj;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   }
}
