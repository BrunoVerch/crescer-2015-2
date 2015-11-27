package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;

public class ProdutoMapper {

    public static Produto getNewEntity(ProdutoDTO dto) {
        Produto entity = new Produto();
        entity.setIdProduto(dto.getIdProduto());
        entity.setMaterial(dto.getMaterial());
        entity.setServico(dto.getServico());
        entity.setValor(dto.getValor());
        entity.setSituacao(dto.getSituacao());
        entity.setPrazo(dto.getPrazo());
        return entity;
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setMaterial(entity.getMaterial());
        dto.setServico(entity.getServico());
        dto.setValor(entity.getValor());
        dto.setPrazo(entity.getPrazo());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Produto merge(ProdutoDTO dto, Produto entity) {
        entity.setIdProduto(dto.getIdProduto());
        // toDO: colocar conforme salvar form
        return entity;
    }
}
