/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

/**
 *
 * @author vinid
 */
public class Medico  extends Pessoa {
    
     
     private int CRM;
     private Especialidade Especialidade;

    public Medico() {
    }

    public Medico(int CRM, Especialidade Especialidade) {
        this.CRM = CRM;
        this.Especialidade = Especialidade;
    }

    public Medico(int CRM, Especialidade Especialidade, int id, String nome, String email, String telefone, Endereco endereco, String CPF) {
        super(id, nome, email, telefone, endereco, CPF);
        this.CRM = CRM;
        this.Especialidade = Especialidade;
    }

    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
    }

    public Especialidade getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(Especialidade Especialidade) {
        this.Especialidade = Especialidade;
    }
     
  
    
     

    
}
