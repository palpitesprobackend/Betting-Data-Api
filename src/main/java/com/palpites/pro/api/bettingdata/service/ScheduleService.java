package com.palpites.pro.api.bettingdata.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleService {

    @Scheduled(cron = "0 0 3 * * ?") // Executa às 03:00 AM todos os dias
    public void realizarTarefa() {
        // Coloque a lógica da sua tarefa aqui
        // Esta tarefa será executada às 03:00 AM no horário de São Paulo
    }
}
