package br.com.cwi.crescer.lavanderia.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ClienteDAO;
import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class PedidoService {

    private PedidoDAO pedidoDao;
    private ClienteDAO clienteDao;
    private PedidoInclusaoService pedidoInclusaoService;

    @Autowired
    public PedidoService(PedidoDAO pedidoDao,ClienteDAO clienteDao,PedidoInclusaoService pedidoInclusaoService){
        this.pedidoDao = pedidoDao;
        this.clienteDao=clienteDao;
        this.pedidoInclusaoService=pedidoInclusaoService;
    }

    public Pedido findById(Long id){
        return this.pedidoDao.findById(id);
    }

    public void atualizar(PedidoDTO dto) {
        Pedido entity = PedidoMapper.getNewEntity(dto);
        pedidoDao.save(entity);
    }
    
    public Long incluirPedido(PedidoIncluirDTO dto){
    	Pedido pedido = new Pedido();
		pedido.setCliente(clienteDao.findById(dto.getIdCliente()));
		pedido.setDataInclusao(new Date());
		pedido.setValor(new BigDecimal("0"));
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		return pedidoDao.save(pedido).getIdPedido();
    }

	public List<PedidoDTO> listar() {
		List<Pedido> pedidos = pedidoDao.findAll();

        List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();

        for (Pedido pedido : pedidos) {
        	pedidoInclusaoService.valorTotalPedido(pedido);
            dtos.add(PedidoMapper.toDTO(pedido));
        }

        return dtos;
	}
	
	public List<PedidoDTO> findByCpf(String cpf) {
		List<Pedido> pedidos = pedidoDao.findAll();
        List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
        for (Pedido pedido : pedidos) {
        	if(pedido.getCliente().getCpf().equals(cpf)){
        		dtos.add(PedidoMapper.toDTO(pedido));
        	}
        }
        return dtos;
	}
	
	public List<PedidoDTO> findBySituacao(String situacao) {
		List<Pedido> pedidos = pedidoDao.findAll();
        List<PedidoDTO> dtos = new ArrayList<PedidoDTO>();
        for (Pedido pedido : pedidos) {
        	if(pedido.getSituacao().toString().equals(situacao)){
        		dtos.add(PedidoMapper.toDTO(pedido));
        	}
        }
        return dtos;
	}
}
