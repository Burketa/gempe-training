package com.example.netflix_clone.model;

public class CEP {

    public CEP(String logradouro, String localidade) {
        this.logradouro = logradouro;
        this.localidade = localidade;
    }

    private String logradouro;
    private String localidade;

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

}
