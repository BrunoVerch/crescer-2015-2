package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;

public class PedidoMapper {

    public static Pedido getNewEntity(PedidoIncluirDTO dto) {
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(dto.getIdCliente());
    	
        Pedido entity = new Pedido();
        entity.setCliente(cliente);
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

    public static PedidoIncluirDTO toDTO2(Pedido entity) {
    	PedidoIncluirDTO dto = new PedidoIncluirDTO();
        dto.setIdCliente(entity.getCliente().getIdCliente());
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
