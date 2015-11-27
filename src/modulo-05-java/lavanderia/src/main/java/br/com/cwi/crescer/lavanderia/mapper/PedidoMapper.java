package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;

public class PedidoMapper {

    public static Pedido getNewEntity(PedidoDTO dto) {
        Pedido entity = new Pedido();
        entity.setCliente(dto.getCliente());
        entity.setDataEntrega(dto.getDataEntrega());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setIdPedido(dto.getIdPedido());
        entity.setItens(dto.getItens());
        entity.setSituacao(dto.getSituacao());
        entity.setValor(dto.getValor());
        entity.setValorDesconto(dto.getValorDesconto());
        entity.setValorFinal(dto.getValorFinal());
        return entity;
    }

    public static PedidoDTO toDTO(Pedido entity) {
        PedidoDTO dto = new PedidoDTO();
        dto.setCliente(entity.getCliente());
        dto.setDataEntrega(entity.getDataEntrega());
        dto.setDataInclusao(entity.getDataInclusao());
        dto.setIdPedido(entity.getIdPedido());
        dto.setItens(entity.getItens());
        dto.setSituacao(entity.getSituacao());
        dto.setValor(entity.getValor());
        dto.setValorDesconto(entity.getValorDesconto());
        dto.setValorFinal(entity.getValorFinal());
        return dto;
    }

    public static Pedido merge(PedidoDTO dto, Pedido entity) {
        entity.setCliente(dto.getCliente());
        // toDO: colocar conforme salvar form
        return entity;
    }
}
