package br.com.transacao;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/*
 * definir nossa mensagem
 */
public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;

    @Component
    public class ListenerDeTransacao {

        @KafkaListener(topics = "${spring.kafka.topic.transactions}")
        public void ouvir(EventoDeTransacao eventoDeTransacao) {
            System.out.println(eventoDeTransacao);
        }
    }

}