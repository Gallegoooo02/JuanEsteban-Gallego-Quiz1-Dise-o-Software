/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositorio;
import org.mindrot.jbcrypt.BCrypt;
import DTOs.UserDTO;
import com.mycompany.quiz.DatabaseConfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Victus
 */
public class UserRepository {

    public UserDTO findById(int id) throws SQLException {
        String query = "SELECT * FROM usuario WHERE id = " + id;
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new UserDTO(
                        resultSet.getInt("id"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("nombre"),
                        resultSet.getString("email")
                );
            } else {
                return null;
            }
        }
    }

    public void save(UserDTO usuario) throws SQLException {
        String hashedPassword = hashPassword(usuario.getContraseña());
        String query = "INSERT INTO usuario(id,contraseña,nombre,email) VALUES ('" + usuario.getId() + "', '" +hashedPassword + "', '" + usuario.getNombre()+ "', '" + usuario.getEmail()+ "')";
        try (Connection connection = DatabaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }

    public static boolean login(String username, String password) {
        String query = "SELECT contraseña FROM usuario WHERE nombre = ?";

        try (Connection conn = DatabaseConfig.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String storedPasswordHash = rs.getString("contraseña");

                return checkPassword(password, storedPasswordHash);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    private static boolean checkPassword(String password, String storedHash) {
        return BCrypt.checkpw(password, storedHash);
    }
}
