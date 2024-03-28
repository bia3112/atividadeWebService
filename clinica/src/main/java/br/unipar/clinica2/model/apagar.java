/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;
  import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author vinicius.duarte
 */
public class apagar {


public class SistemaAgendamento {
    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Consulta> consultas;

    public SistemaAgendamento() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public void cadastrarPaciente(String nome) {
        pacientes.add(new Paciente(nome, true));
    }

    public void cadastrarMedico(String nome) {
        medicos.add(new Medico(nome, true));
    }

    public String agendarConsulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        if (!paciente.isAtivo()) {
            return "Não é possível agendar uma consulta para um paciente inativo.";
        }

        if (medico != null && !medico.isAtivo()) {
            return "Não é possível agendar uma consulta com um médico inativo.";
        }

        LocalDateTime limiteInicio = LocalDateTime.of(dataHora.toLocalDate(), LocalDateTime.of(0, 0, 0, 7, 0).toLocalTime());
        LocalDateTime limiteFim = LocalDateTime.of(dataHora.toLocalDate(), LocalDateTime.of(0, 0, 0, 19, 0).toLocalTime());

        if (dataHora.getDayOfWeek().getValue() > 5 || dataHora.isBefore(limiteInicio) || dataHora.isAfter(limiteFim)) {
            return "A clínica está fechada neste horário.";
        }

        for (Consulta consulta : consultas) {
            if (consulta.getDataHora().isEqual(dataHora)) {
                return "Já existe uma consulta marcada para este horário.";
            }
        }

        if (medico == null) {
            List<Medico> medicosDisponiveis = new ArrayList<>();
            for (Medico m : medicos) {
                if (m.isAtivo()) {
                    medicosDisponiveis.add(m);
                }
            }
            if (medicosDisponiveis.isEmpty()) {
                return "Não há médicos disponíveis para esta data/hora.";
            }
            medico = medicosDisponiveis.get(new Random().nextInt(medicosDisponiveis.size()));
        }

        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().equals(paciente) && consulta.getDataHora().toLocalDate().isEqual(dataHora.toLocalDate())) {
                return "O paciente já possui uma consulta marcada para este dia.";
            }
            if (consulta.getMedico().equals(medico) && consulta.getDataHora().isEqual(dataHora)) {
                return "O médico já possui uma consulta marcada para este horário.";
            }
        }

        LocalDateTime antecedenciaMinima = LocalDateTime.now().plusMinutes(30);
        if (dataHora.isBefore(antecedenciaMinima)) {
            return "É necessário agendar com pelo menos 30 minutos de antecedência.";
        }

        consultas.add(new Consulta(paciente, medico, dataHora));
        return "Consulta agendada com sucesso.";
    }

    public static void main(String[] args) {
        SistemaAgendamento sistema = new SistemaAgendamento();

        sistema.cadastrarPaciente("João");
        sistema.cadastrarMedico("Dr. Silva");

        Paciente paciente = sistema.pacientes.get(0);
        Medico medico = sistema.medicos.get(0);

        LocalDateTime dataHora = LocalDateTime.of(2024, 3, 28, 10, 0);
        String resultado = sistema.agendarConsulta(paciente, medico, dataHora);
        System.out.println(resultado);
    }
}

    
}
