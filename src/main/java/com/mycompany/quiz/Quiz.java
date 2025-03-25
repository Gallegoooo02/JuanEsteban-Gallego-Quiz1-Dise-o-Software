/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.quiz;

import Exception.InvalidMotocicletaDataException;
import Exception.InvalidUserDataException;
import Service.MotocicletaService;
import Service.UserService;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Victus
 */
public class Quiz {

    public static void main(String[] args) throws SQLException, InvalidUserDataException, InvalidMotocicletaDataException {

        UserService user = new UserService();
        MotocicletaService moto = new MotocicletaService();

        System.out.print("Introduce nombre de usuario: ");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Registrar usuario");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Gestionar motocicleta");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Introduce nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Introduce contraseña: ");
                String password = scanner.nextLine();
                System.out.print("Introduce email: ");
                String email = scanner.nextLine();

                boolean success = user.createUser(password, username, email);
                if (success) {
                    System.out.println("Usuario registrado con éxito.");
                } else {
                    System.out.println("Error al registrar el usuario. Es posible que el nombre ya esté registrado.");
                }

            } else if (choice == 2) {
                System.out.print("Introduce nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Introduce contraseña: ");
                String password = scanner.nextLine();

                boolean success = user.login(username, password);
                if (success) {
                    System.out.println("Inicio de sesión exitoso.");
                } else {
                    System.out.println("Usuario o contraseña incorrectos.");
                }
            } else if (choice == 3) {
                System.out.println("\n1. Registrar motocicleta");
                System.out.println("2. editar moto");
                System.out.println("3. eliminar motocicleta");
                System.out.print("Elige una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1) {
                    System.out.println("Introduce el ID");
                    String id = scanner.nextLine();
                    System.out.println("Introduce la marca");
                    String marca = scanner.nextLine();
                    System.out.println("Introduce el cilindraje");
                    int cilindraje = Integer.parseInt(scanner.nextLine());
                    System.out.println("Introduce el precio");
                    float precio = Float.parseFloat(scanner.nextLine());
                    System.out.println("Introduce el color");
                    String color = scanner.nextLine();
                    boolean respuesta = moto.create(id, marca, cilindraje, precio, color);
                    if (respuesta) {
                        System.out.println("Motocicleta registrada");

                    } else {
                        System.out.println("Error al registrar motocicleta");
                    }
                } else if(opcion == 2)  {
                        System.out.println("Introduce el ID");
                        String id = scanner.nextLine();
                        System.out.println("Introduce la marca");
                        String marca = scanner.nextLine();
                        System.out.println("Introduce el cilindraje");
                        int cilindraje = Integer.parseInt(scanner.nextLine());
                        System.out.println("Introduce el precio");
                        float precio = Float.parseFloat(scanner.nextLine());
                        System.out.println("Introduce el color");
                        String color = scanner.nextLine();
                        boolean respuesta = moto.editar(id, marca, cilindraje, precio, color);
                        if (respuesta) {
                            System.out.println("Motocicleta editada");

                        } else {
                            System.out.println("Error al editar motocicleta");
                        }
                    }else if(opcion == 3){
                        System.out.println("Introduce el ID");
                        String id = scanner.nextLine();
                        boolean respuesta = moto.eliminar(id);
                        if (respuesta) {
                            System.out.println("Motocicleta eliminada");

                        } else {
                            System.out.println("Error al eliminar motocicleta");
                        }
                        break;
                }

            } else if (choice == 4) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        scanner.close();
    }
}
