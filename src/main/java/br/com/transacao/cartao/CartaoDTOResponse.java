package br.com.transacao.cartao;

public class CartaoDTOResponse {
    private String id;
    private String email;

    public CartaoDTOResponse() {
    }

    public CartaoDTOResponse(String id, String email) {
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
