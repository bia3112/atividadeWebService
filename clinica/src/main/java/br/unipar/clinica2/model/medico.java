/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

/**
 *
 * @author vinid
 */
public class Medico extends Pessoa {
    
     
     private int crm;
     private Especialidade especialidade;
     private boolean status;

    public Medico(int crm, Especialidade especialidade, boolean status, int id, String nome, String email, String telefone, Endereco endereco, String cpf) {
        super(id, nome, email, telefone, endereco, cpf);
        this.crm = crm;
        this.especialidade = especialidade;
        this.status = status;
    }

    public Medico() {
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}

