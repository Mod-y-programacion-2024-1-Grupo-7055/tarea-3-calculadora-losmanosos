/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class ErrorAritmeticoException extends Exception{
    
    /**
     *
     * @param error
     */
    public ErrorAritmeticoException(String error) {
        super("Error aritmético: " + error);
    }
    
    
}
