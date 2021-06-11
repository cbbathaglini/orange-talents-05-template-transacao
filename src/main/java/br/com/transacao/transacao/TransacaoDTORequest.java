package br.com.transacao.transacao;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.cartao.CartaoDTORequest;
import br.com.transacao.estabelecimento.Estabelecimento;
import br.com.transacao.estabelecimento.EstabelecimentoDTORequest;

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
    private EstabelecimentoDTORequest estabelecimentoDTORequest;

    @NotNull
    private CartaoDTORequest cartaoDTORequest;

    @NotBlank
    private LocalDateTime efetivadaEm;

    public Transacao converter(){
        Estabelecimento estabelecimento = this.estabelecimentoDTORequest.converter();
        Cartao cartao = this.cartaoDTORequest.converter();
        return new Transacao(this.id,this.valor, estabelecimento, cartao, this.efetivadaEm);
    }

    public TransacaoDTORequest() {
    }

    public TransacaoDTORequest(String id, BigDecimal valor, EstabelecimentoDTORequest estabelecimentoDTORequest, CartaoDTORequest cartaoDTORequest, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimentoDTORequest = estabelecimentoDTORequest;
        this.cartaoDTORequest = cartaoDTORequest;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoDTORequest getEstabelecimentoDTORequest() {
        return estabelecimentoDTORequest;
    }

    public CartaoDTORequest getCartaoDTORequest() {
        return cartaoDTORequest;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
