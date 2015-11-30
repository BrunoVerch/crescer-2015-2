package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;

public class ItemMapper {

	public static ItemDTO toDTO(Item entity) {
		ItemDTO dto = new ItemDTO();
        dto.setId(entity.getIdItem());
        dto.setIdMaterial(entity.getProduto().getMaterial().getIdMaterial());
        dto.setIdServico(entity.getProduto().getServico().getIdServico());
        dto.setDescricaoMaterial(entity.getProduto().getMaterial().getDescricao());
        dto.setDescricaoServico(entity.getProduto().getServico().getDescricao());
        dto.setIdPedido(entity.getPedido().getIdPedido());
        dto.setIdProduto(entity.getProduto().getIdProduto());
        dto.setPeso(entity.getPeso());
        dto.setSituacao(entity.getSituacao().toString());
        dto.setValorTotal(entity.getValorTotal());
        dto.setValorUnitario(entity.getValorUnitario());
        return dto;
    }
	
}
