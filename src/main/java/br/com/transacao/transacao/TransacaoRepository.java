package br.com.transacao.transacao;

import br.com.transacao.cartao.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransacaoRepository  extends PagingAndSortingRepository<Transacao, String> {

    @Query("SELECT t FROM Cartao c,Transacao t WHERE c.id = t.cartao.id and c.id = :numCartao")
    Page<Transacao> findByCartao(String numCartao, Pageable pageable);

}
