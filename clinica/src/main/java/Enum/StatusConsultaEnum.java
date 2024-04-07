/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enum;

/**
 *
 * @author Beatr
 */

//CREATE TYPE STATUS_CONSULTA_ENUM AS ENUM ('ATIVO', 'MEDICO_CANCELOU', 'PACIENTE_DESISTIU', 'OUTROS')
//ALTER TABLE CONSULTA ADD COLUMN STATUS STATUS_CONSULTA_ENUM

public enum StatusConsultaEnum {
    
    ATIVO("ATIVO"),
    MEDICO_CANCELOU("MÉDICO CANCELOU"),
    PACIENTE_DESISTIU("PACIENTE DESISTIU"),
    OUTROS("OUTROS");
    
     private final String descricao;

    StatusConsultaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
}
