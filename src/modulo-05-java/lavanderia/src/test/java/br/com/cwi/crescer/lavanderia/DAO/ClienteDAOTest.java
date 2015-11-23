package br.com.cwi.crescer.lavanderia.DAO;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;


public class ClienteDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ClienteDAO clienteDao;

    @Test
    public void testFindById() throws Exception {
        Cliente cliente = clienteDao.findById(1L);
        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getCidade());
    }

    @Test
    public void FindByIdReturnPedidos() throws Exception {
        Cliente cliente = clienteDao.findById(1L);
        Assert.assertNotNull(cliente);
        Assert.assertNotNull(cliente.getPedidos());
    }

    @Test
    public void deveBuscarClientesAtivos() throws Exception {
        List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);
        Assert.assertNotNull(clientes);
        Assert.assertFalse(clientes.isEmpty());

        for (Cliente cliente : clientes) {
            Assert.assertEquals(SituacaoCliente.ATIVO, cliente.getSituacao());
        }
    }

}
