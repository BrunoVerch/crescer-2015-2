package br.com.cwi.crescer.lavanderia.DAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.cwi.crescer.lavanderia.domain.Servico;


public class ServicoDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private ServicoDAO servicoDao;

    @Test
    public void testFindById() throws Exception {
        Servico servico = servicoDao.findById(1L);
        Assert.notNull(servico);
    }

}
