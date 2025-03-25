/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DTOs.UserDTO;
import Exception.InvalidUserDataException;
import Repositorio.UserRepository;
import Validator.UserValidator;
import java.sql.SQLException;

/**
 *
 * @author Victus
 */
public class UserService {

    private UserRepository userRepository = new UserRepository();

    public UserDTO getUserById(int id) throws SQLException {
        return userRepository.findById(id);
    }

    public boolean createUser(String contraseña, String nombre, String email) throws
            SQLException, InvalidUserDataException {
        if ( !UserValidator.validateContraseña(contraseña) || !UserValidator.validateNombre(nombre) || !UserValidator.validateEmail(email)) {
            throw new InvalidUserDataException("Invalid user data");
        }
        UserDTO usuario = new UserDTO(0, contraseña, nombre, email);
        userRepository.save(usuario);
        return true;
    }
    
    public boolean login(String password, String name) {
    return userRepository.login(password, name);
    }

}
