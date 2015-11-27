package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDao;

    @Autowired
    public PedidoService(PedidoDAO pedidoDao){
        super();
        this.pedidoDao = pedidoDao;
    }

    public Pedido findById(Long id){
        return this.pedidoDao.findById(id);
    }

    public void atualizar(PedidoDTO dto) {
        Pedido entity = pedidoDao.findById(dto.getIdPedido());
        PedidoMapper.merge(dto, entity);
        pedidoDao.save(entity);
    }

    public void criar(PedidoDTO dto) {
        Pedido entity = PedidoMapper.getNewEntity(dto);
        entity.setSituacao(SituacaoPedido.PENDENTE);
        pedidoDao.save(entity);
    }
}
