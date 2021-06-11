package br.com.transacao.estabelecimento;

import br.com.transacao.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long>{
}
