package br.com.transacao.cartao;

import br.com.transacao.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, String> {
}
