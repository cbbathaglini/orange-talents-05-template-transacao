package br.com.transacao;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.cartao.CartaoDTORequest;
import br.com.transacao.estabelecimento.Estabelecimento;
import br.com.transacao.estabelecimento.EstabelecimentoDTORequest;
import br.com.transacao.transacao.Transacao;
import br.com.transacao.transacao.TransacaoDTORequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
 * definir nossa mensagem
 */
public class EventoDeTransacao {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoDTORequest estabelecimento;
    private CartaoDTORequest cartao;
    private LocalDateTime efetivadaEm;

    public EventoDeTransacao(TransacaoDTORequest transacaoDTORequest) {

        this.valor = transacaoDTORequest.getValor();
        this.estabelecimento = transacaoDTORequest.getEstabelecimentoDTORequest();
        this.cartao = transacaoDTORequest.getCartaoDTORequest();
        this.efetivadaEm = transacaoDTORequest.getEfetivadaEm();

    }

    public EventoDeTransacao() {
    }

    public Transacao converter() {
        Estabelecimento estabelecimento = this.estabelecimento.converter();
        Cartao cartao = this.cartao.converter();
        return new Transacao(this.id, this.valor, estabelecimento, cartao, this.efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDTORequest getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoDTORequest getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "EventoDeTransacao{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}