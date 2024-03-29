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
     private Especialidade Especialidade;

    public Medico(int crm, Especialidade Especialidade, int id, String nome, 
            String email, String telefone, Endereco endereco, String cpf) {
        super(id, nome, email, telefone, endereco, cpf);
        this.crm = crm;
        this.Especialidade = Especialidade;
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
        return Especialidade;
    }

    public void setEspecialidade(Especialidade Especialidade) {
        this.Especialidade = Especialidade;
    }
    
    
}

