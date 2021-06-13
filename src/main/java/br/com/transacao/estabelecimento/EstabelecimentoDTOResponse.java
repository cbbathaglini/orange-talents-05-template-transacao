package br.com.transacao.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoDTOResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public Estabelecimento converter(){
        return new Estabelecimento(this.nome,this.cidade, this.endereco);
    }

    public EstabelecimentoDTOResponse() {
    }

    public EstabelecimentoDTOResponse(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "EstabelecimentoDTOResponse{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
