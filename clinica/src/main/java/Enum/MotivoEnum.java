/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Enum;

/**
 *
 * @author Beatr
 */
public enum MotivoEnum {
    
    MEDICO_CANCELOU("Médico cancelou"),
    PACIENTE_DESISTIU("Paciente desistiu"),
    OUTROS("Outros");
    
    private final String descricao;
    
    MotivoEnum(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    
}
