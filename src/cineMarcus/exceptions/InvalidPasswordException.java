/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus.exceptions;

/**
 *
 * @author ruan
 */
public class InvalidPasswordException extends Exception{
    public InvalidPasswordException(String errorMessage) {
        super(errorMessage);
    }
}
