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
    
    private boolean status;

    public Paciente() {
    }

    public Paciente(boolean status, int id, String nome, String email, String telefone, Endereco endereco, String cpf) {
        super(id, nome, email, telefone, endereco, cpf);
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
