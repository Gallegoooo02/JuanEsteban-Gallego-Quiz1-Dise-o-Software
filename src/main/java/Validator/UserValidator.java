/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validator;

/**
 *
 * @author Victus
 */
public class UserValidator {

    public static boolean validateId(Integer id) {
        return id != null && id > 0;
    }

    public static boolean validateContraseña(String password) {
        return password != null && !password.trim().isEmpty(); 
    }

    public static boolean validateNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

}
