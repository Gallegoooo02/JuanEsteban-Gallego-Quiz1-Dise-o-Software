/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DTOs.MotocicletaDTO;
import Exception.InvalidMotocicletaDataException;
import Repositorio.MotocicletaRepository;
import Validator.MotocicletaValidator;
import java.sql.SQLException;

/**
 *
 * @author Victus
 */
public class MotocicletaService {
    
    private MotocicletaRepository moto = new MotocicletaRepository();

    public MotocicletaDTO getMotocicletaById(String id) throws SQLException {
        return moto.findById(id);
    }

    public boolean create(String id, String marca, int cilindraje, float precio, String color) throws
            SQLException, InvalidMotocicletaDataException {
        if (!MotocicletaValidator.validateId(id)||!MotocicletaValidator.validateMarca(marca) || !MotocicletaValidator.validateCilindraje(cilindraje) || !MotocicletaValidator.validatePrecio(precio) || !MotocicletaValidator.validateColor(color) ) {

            throw new InvalidMotocicletaDataException("Datos inválidos");

        }
        MotocicletaDTO motocicleta = new MotocicletaDTO(id, marca, cilindraje, precio, color);
        moto.save(motocicleta);
        return true;
    }

    public boolean editar(String id, String marca, int cilindraje, float precio, String color) throws
            SQLException, InvalidMotocicletaDataException {
        if (!MotocicletaValidator.validateMarca(marca)|| !MotocicletaValidator.validateCilindraje(cilindraje) ||!MotocicletaValidator.validatePrecio(precio)|| !MotocicletaValidator.validateColor(color)) {

            throw new InvalidMotocicletaDataException("Datos inválidos");
        }

        MotocicletaDTO motocicletaExistente = moto.findById(id);
        if (motocicletaExistente == null) {
            throw new InvalidMotocicletaDataException("Motocicleta no encontrada");
        }

        MotocicletaDTO motocicletaActualizada = new MotocicletaDTO(id, marca, cilindraje, precio, color);
        moto.editar(motocicletaActualizada);
        return true;
    }

    public boolean eliminar(String id) throws SQLException, InvalidMotocicletaDataException {
        MotocicletaDTO motocicletaExistente = moto.findById(id);
        if (motocicletaExistente == null) {
            throw new InvalidMotocicletaDataException("Motocicleta no encontrada");
        }

        moto.delete(id);
        return true;
    }
}
