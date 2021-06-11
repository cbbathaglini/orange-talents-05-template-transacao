package br.com.transacao.transacao;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.estabelecimento.Estabelecimento;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoDTORequest {

    @NotBlank
    private String id;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Estabelecimento estabelecimento;

    @NotNull
    private Cartao cartao;

    @NotBlank
    private LocalDateTime efetivadaEm;

    public Transacao converter(){
        return new Transacao(this.id,this.valor, this.estabelecimento, this.cartao, this.efetivadaEm);
    }

    public TransacaoDTORequest() {
    }

    public TransacaoDTORequest(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
