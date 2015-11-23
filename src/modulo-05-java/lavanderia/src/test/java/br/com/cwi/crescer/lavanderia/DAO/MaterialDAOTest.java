package br.com.cwi.crescer.lavanderia.DAO;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import br.com.cwi.crescer.lavanderia.domain.Material;


public class MaterialDAOTest extends AbstractInfrastructureTest {

    @Autowired
    private MaterialDAO materialDao;

    @Test
    public void testFindById() throws Exception {
        Material material = materialDao.findById(1L);
        Assert.notNull(material);
    }

}
