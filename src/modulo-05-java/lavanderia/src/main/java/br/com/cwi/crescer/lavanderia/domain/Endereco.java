package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(name = "CEP", length = 8)
    @Basic(optional = false)
    private Long cep;
	
    @Column(name = "Endereco", length = 50)
    @Basic(optional = false)
    private String endereco;

    @Column(name = "Bairro", length = 50)
    @Basic(optional = false)
    private String bairro;
    
    public Long getCep() {
		return cep;
	}
    
    public void setCep(Long cep) {
		this.cep = cep;
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
}
