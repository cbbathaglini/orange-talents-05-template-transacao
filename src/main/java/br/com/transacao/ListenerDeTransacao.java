package br.com.transacao;

import br.com.transacao.transacao.Transacao;
import br.com.transacao.transacao.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}", groupId = "${spring.kafka.consumer.group-id}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {
        if(eventoDeTransacao != null) {
            System.out.println((char)27 + "[32m" + eventoDeTransacao.toString());
            //System.out.println("---------------->" + eventoDeTransacao.toString());
            //System.out.println("---------------->" + eventoDeTransacao.getEstabelecimento());
            //System.out.println("---------------->" + eventoDeTransacao.getCartao());
            Transacao transacao = eventoDeTransacao.converter();
            transacaoRepository.save(transacao);
        }
        System.err.println("Está vindo null...");
    }
}