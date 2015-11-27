package br.com.cwi.crescer.lavanderia.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.br.CPF;

import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

public class ClienteDTO {

    private Long id;

    @NotBlank
    @Length(max=70)
    private String nome;

    @NotBlank
    @Length(min=11,max=11)
    @CPF
    private String cpf;

    @NotBlank
    @Length(max=100)
    @Email
    private String email;

    @NotBlank
    @Length(max=50)
    private String endereco;

    @NotBlank
    @Length(max=50)
    private String bairro;

    @NotNull
    private Long idCidade;

    @NotNull
    @Range(max = 99999999)
    private Long cep;

    private SituacaoCliente situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

}
