package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoIncluirDTO;

public class ProdutoMapper {

    public static Produto getNewEntity(ProdutoDTO dto) {
        Produto entity = new Produto();
        entity.setIdProduto(dto.getIdProduto());
        entity.setMaterial(dto.getMaterial());
        entity.setServico(dto.getServico());
        entity.setValor(dto.getValor());
        // entity.setSituacao(dto.getSituacao());
        entity.setPrazo(dto.getPrazo());
        return entity;
    }
    
    public static Produto getNewEntity(ProdutoIncluirDTO incluirDto) {
    	Material material = new Material();
    	material.setIdMaterial(incluirDto.getIdMaterial());
    	Servico servico = new Servico();
    	servico.setIdServico(incluirDto.getIdServico());
    	
        Produto entity = new Produto();
        entity.setIdProduto(incluirDto.getIdProduto());
        entity.setMaterial(material);
        entity.setServico(servico);
        entity.setValor(incluirDto.getValor());
        entity.setPrazo(incluirDto.getPrazo());
        return entity;
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setMaterial(entity.getMaterial());
        dto.setServico(entity.getServico());
        dto.setValor(entity.getValor());
        dto.setPrazo(entity.getPrazo());
        dto.setSituacao(entity.getSituacao().ordinal());
        return dto;
    }

    public static Produto merge(ProdutoDTO dto, Produto entity) {
        entity.setIdProduto(dto.getIdProduto());
        entity.setValor(dto.getValor());
        entity.setPrazo(dto.getPrazo());
        // toDO: colocar conforme salvar form
        return entity;
    }
}
