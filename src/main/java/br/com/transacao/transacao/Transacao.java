package br.com.transacao.transacao;

import br.com.transacao.cartao.Cartao;
import br.com.transacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Transacao {

    @Id
    private String id;

    private BigDecimal valor;

    @ManyToOne
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }
}
/*
 * {
 *    "id":"c63fd0e0-eccb-4af3-9d49-39cde0ffdaf1",
 *    "valor":1.4874248222626738,
 *    "estabelecimento":{
 *       "nome":"B. A. Ware",
 *       "cidade":"North Winstonbury",
 *       "endereco":"18327 Mills Groves, West Marquita, SD 31244"
 *    },
 *    "cartao":{
 *       "id":"b0012b90-42c8-40e6-903b-64acb3aa649b",
 *       "email":"luram.archanjo@zup.com.br"
 *    },
 *    "efetivadaEm":"2020-08-10T13:16:56"
 * }
 */
