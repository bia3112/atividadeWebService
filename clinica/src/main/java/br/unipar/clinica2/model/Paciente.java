/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

/**
 *
 * @author vinid
 */
public class Paciente extends Pessoa {
    
    private String status;

    public Paciente() {
    }

    public Paciente(String status, int id, String nome, String email, 
            String telefone, Endereco endereco, String cpf) {
        super(id, nome, email, telefone, endereco, cpf);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
