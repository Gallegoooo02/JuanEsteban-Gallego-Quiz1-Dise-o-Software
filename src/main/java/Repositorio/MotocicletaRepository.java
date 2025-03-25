/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;

import DTOs.MotocicletaDTO;
import com.mycompany.quiz.DatabaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Victus
 */
public class MotocicletaRepository {
    
    public MotocicletaDTO findById(String id) throws SQLException {
        String query = "SELECT * FROM motocicleta WHERE id = '" + id+"'";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new MotocicletaDTO(
                        resultSet.getString("id"),
                        resultSet.getString("marca"),
                        resultSet.getInt("cilindraje"),
                        resultSet.getFloat("precio"),
                        resultSet.getString("color")
                );
            } else {
                return null;
            }
        }
    }

    public void save(MotocicletaDTO moto) throws SQLException {
        String query = "INSERT INTO motocicleta (id, marca, cilindraje, precio, color) VALUES ('" + moto.getId() + "', '" + moto.getMarca()+ "', '" + moto.getCilindraje() + "', '" + moto.getPrecio() + "', '" + moto.getColor() + "')";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
    
    public void editar(MotocicletaDTO moto) throws SQLException{
        String query = "Update motocicleta set marca = '" + moto.getMarca() + 
                "', cilindraje = " + moto.getCilindraje()
                + ", precio = " + moto.getPrecio()
                + ", color = '" + moto.getColor()
                + "' where id = '"+ moto.getId() 
                + "'";
         try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    } 
    
    public void delete(String id) throws SQLException{
        String query = "Delete from motocicleta where id = '" + id + "'";
         try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
}
