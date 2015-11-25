package br.com.cwi.crescer.lavanderia.dto;

import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteResumoDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;

    public ClienteResumoDTO() {
    }

    public ClienteResumoDTO(Long id, String nome, String cpf, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
    }

    public ClienteResumoDTO(Cliente entity) {
        id = entity.getIdCliente();
        nome = entity.getNome();
        cpf = entity.getCpf();
        email = entity.getEmail();
        endereco = entity.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco() {
		return endereco;
	}
    
    public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
