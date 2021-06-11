package br.com.transacao.cartao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CartaoDTORequest {
    @NotBlank
    private String id;

    @NotBlank
    private String email;

    public Cartao converter(){
        return new Cartao(this.id, this.email);
    }

    public CartaoDTORequest() {
    }

    public CartaoDTORequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
