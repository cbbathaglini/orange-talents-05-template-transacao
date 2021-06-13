package br.com.transacao.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    private String id;
    private String email;

    public Cartao() {
    }


    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public CartaoDTOResponse converter() {
        return new CartaoDTOResponse(this.id,this.email);
    }
}
