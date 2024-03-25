/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Exception;

/**
 *
 * @author Beatr
 */
public class CampoPreenchidoException extends Exception {

    public CampoPreenchidoException(String campo) {
        super("O campo " + campo + " deve ser preenchido.");
    }
    
}
