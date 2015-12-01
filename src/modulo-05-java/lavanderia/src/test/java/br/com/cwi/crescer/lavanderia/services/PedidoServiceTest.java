package br.com.cwi.crescer.lavanderia.services;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.lavanderia.DAO.ClienteDAO;
import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;

public class PedidoServiceTest {

	@InjectMocks
	private PedidoService pedidoService;
	
	@Mock
	private PedidoDAO pedidoDao;
	
	@Mock
    private ClienteDAO clienteDao;
	
    
    @Before
    public void setup(){
    	MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void findByCpf(){
    	List<Pedido> lista = new ArrayList<Pedido>();
    	Pedido pedido1 = new Pedido();
    	Pedido pedido2 = new Pedido();
    	Pedido pedido3 = new Pedido();
    	Cliente cliente1 = new Cliente();
    	Cliente cliente2 = new Cliente();
    	Cliente cliente3 = new Cliente();
    	cliente1.setCpf("123");
    	cliente2.setCpf("456");
    	cliente3.setCpf("789");
    	pedido1.setCliente(cliente1);
    	pedido2.setCliente(cliente2);
    	pedido3.setCliente(cliente3);
    	lista.add(pedido1);
    	lista.add(pedido2);
    	lista.add(pedido3);
    	Mockito.when(pedidoDao.findAll()).thenReturn(lista);
    	
    	List<PedidoDTO> resultado = pedidoService.findByCpf("123");
    	
    	assertEquals(resultado.get(0).getCliente().getCpf(),"123");
    }
    
    @Test
    public void findBySituacao(){
    	List<Pedido> lista = new ArrayList<Pedido>();
    	Pedido pedido1 = new Pedido();
    	Pedido pedido2 = new Pedido();
    	Pedido pedido3 = new Pedido();
    	pedido1.setSituacao(SituacaoPedido.PENDENTE);
    	pedido2.setSituacao(SituacaoPedido.PENDENTE);
    	pedido3.setSituacao(SituacaoPedido.PENDENTE);
    	lista.add(pedido1);
    	lista.add(pedido2);
    	lista.add(pedido3);
    	Mockito.when(pedidoDao.findAll()).thenReturn(lista);
    	
    	List<PedidoDTO> resultado = pedidoService.findBySituacao("pendente");
    	
    	assertEquals(3,resultado.size());
    }
    
    @Test
    public void incluirPedido(){
    	PedidoIncluirDTO pedidoDto = new PedidoIncluirDTO();
    	pedidoDto.setIdCliente(1L);
    	Pedido pedidoMock = new Pedido();
    	pedidoMock.setIdPedido(1L);
    	Mockito.when(pedidoDao.save(new Pedido())).thenReturn(pedidoMock);
    	
    	Long id = pedidoService.incluirPedido(pedidoDto);
    	
    	assertEquals(pedidoDto.getIdPedido(),id);
    }
}
