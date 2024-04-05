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
    
    private String crm;
    private Especialidade especialidade;
    private String status;

    public Medico(String crm, Especialidade especialidade, String status, 
            int id, String nome, String email, String telefone, 
            Endereco endereco, String cpf) {
        super(id, nome, email, telefone, endereco, cpf);
        this.crm = crm;
        this.especialidade = especialidade;
        this.status = status;
    }

    public Medico() {
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}

