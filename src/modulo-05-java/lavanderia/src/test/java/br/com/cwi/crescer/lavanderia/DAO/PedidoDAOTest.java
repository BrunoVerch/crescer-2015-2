package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;


public class PedidoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private PedidoDAO pedidoDao;

    @Test
    public void testFindById() throws Exception {
        Pedido pedido = pedidoDao.findById(1L);
        Assert.assertNotNull(pedido);
        Assert.assertNotNull(pedido.getItens());
    }

    @Test
    public void deveBuscarPedidoPorIdComCliente() {
        Pedido pedido = pedidoDao.findById(1L);
        Assert.assertNotNull(pedido.getCliente());
    }

    @Test
    public void deveBuscarPedidosPendentes() throws Exception {
        List<Pedido> pedidos = pedidoDao.findBySituacao(SituacaoPedido.PENDENTE);
        Assert.assertNotNull(pedidos);
        Assert.assertFalse(pedidos.isEmpty());

        for (Pedido pedido : pedidos) {
            Assert.assertEquals(SituacaoPedido.PENDENTE, pedido.getSituacao());
        }
    }

}
