/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.ConsultaRepository;
import br.unipar.clinica2.model.Consulta;
import br.unipar.clinica2.model.HorarioFuncionamento;
import br.unipar.clinica2.model.Medico;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author vinicius.duarte
 */
public class ConsultaService {
    
//    private ArrayList<Medico> listaMedico;
//    private Medico medicoAleatorio() {
//        Random random = new Random();
//        int id = random.nextInt(listaMedico.size());
//        return listaMedico.get(id);
//    }
    
//    private Map<DayOfWeek, HorarioFuncionamento> horarioFuncionamento;
//
//    private void horarioEspecificoFuncionamento() {
//        horarioFuncionamento = new EnumMap<>(DayOfWeek.class);
//        for(DayOfWeek dia : DayOfWeek.values()) {
//            if(dia != DayOfWeek.SUNDAY) {
//                horarioFuncionamento.put(dia, new HorarioFuncionamento(LocalTime.of(7, 0), LocalTime.of(19, 0)));
//            }
//        }
//    }
//    
//    public boolean isHorarioFuncionamento(DayOfWeek diaSemana, LocalTime horario) {
//        HorarioFuncionamento intervalo = horarioFuncionamento.get(diaSemana);
//        return intervalo != null && intervalo.estaNoIntervalo(horario);
//    }
//    
    
    public Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
  
//        Consulta consultaExistente = findByIdConsulta(consulta.getIdConsulta());
//        
//        if(!isHorarioFuncionamento(consulta.getDataHora().getDayOfWeek(), consulta.getDataHora().toLocalTime())) {
//            throw new ValidacaoException("Horário fora do funcionamento da clínica.");
//        }
//        
//        if(consulta.getPaciente().getStatus().equals("INATIVO")) {
//            throw new ValidacaoException("Paciente está inativo.");
//        }
//        if(consulta.getMedico().getStatus().equals("INATIVO")) {
//            throw new ValidacaoException("Médico está inativo.");
//        }
//        
//        if(!consulta.getPaciente().equals(consultaExistente.getPaciente())) {
//            if(!consulta.getDataHora().equals(consultaExistente.getDataHora())) {
//                throw new ValidacaoException("Paciente já tem uma consulta marcada para está data.");
//            }
//        }
//        if(!consulta.getMedico().equals(consultaExistente.getMedico())) {
//            if(!consulta.getDataHora().equals(consultaExistente.getDataHora())) {
//                throw new ValidacaoException("Paciente já tem uma consulta marcada para está data.");
//            }
//        }
//        if(consulta.getMedico() == null) {
//            if(!consulta.getDataHora().equals(consultaExistente.getDataHora())) {
//                consulta.setMedico(medicoAleatorio());
//            }
//        }
        
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.inserirConsulta(consulta);
        } catch(SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }
    
    public ArrayList<Consulta> listAllConsulta()throws SQLException {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        ArrayList<Consulta> retorno = consultaRepository.listAllConsulta();
        return retorno;
    }
       
    public Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
       
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.atualizarConsulta(consulta);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
  
    }
    
    public void deletarConsulta(int id) throws ValidacaoException {

//        if(id <= 0) {
//            throw new ValidacaoException("Número de caracteres inválido.");
//        }
        
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            consultaRepository.deletarConsulta(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }

    }
    
    public Consulta findByIdConsulta(int id) throws ValidacaoException {
            
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.findByIdConsulta(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
}
