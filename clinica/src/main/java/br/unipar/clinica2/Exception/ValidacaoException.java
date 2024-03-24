package br.unipar.clinica2.Exception;

import jakarta.xml.ws.WebFault;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinicius.duarte
 */
@WebFault
public class ValidacaoException extends Exception {
    
    public ValidacaoException(String message) {
        super(message);
    }
    
}
