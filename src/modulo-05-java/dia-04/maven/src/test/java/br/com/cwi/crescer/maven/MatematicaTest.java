package br.com.cwi.crescer.maven;

import org.junit.Assert;
import org.junit.Test;

public class MatematicaTest {

    @Test
    public void SomarDoisNumeros() {
        int resultado = new Matematica().somar(2, 2);
        Assert.assertEquals(4, resultado);
    }
}
