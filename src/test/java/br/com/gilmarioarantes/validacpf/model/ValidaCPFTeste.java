package br.com.gilmarioarantes.validacpf.model;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
*
* Diretrizes para conduzir a cenários de testes
*
* CE -> Classe de Equivalência
* CT -> Caso de Teste
*
* Equivalências
*
* CE1 - Cpf == 0
* CE2 - Cpf > 11
* CE3 - Cpf  == 11
* CE4 – Cpf  >  0
*
*
* ID	        Valor de Entrada	 Tipo Erro                Equivalencia        Resultado
* CT1	          de (0 à 9) x 11 	 numeros repetidos          CE3,CE4            Inválido
* CT2	          01234567890	     cpf inválido               CE3,CE4	           Válido
* CT3	          11478adfa54	     misturado                  CE3,CE4	           Inválido
* CT4	          alfanumerico	     alfanuméricos              CE3,CE4	           Inválido
* CT5	          53140776047	     cpf válido                 CE3,CE4	           Válido
* CT6	          944.475.758-76	 com sinais                 CE2,CE4	           Inválido
* CT7		         ""                                         CE1	               Válido
*
* */


public class ValidaCPFTeste {
    ValidaCPF app;

    @Before
    public void setup() {
        app = new ValidaCPF();
    }

    @Test
    public void cT1() {
        for (int i = 0; i <= 9; i++) {
            char z = (char)i;
            String rep = StringUtils.leftPad("", 11, z);
            Assert.assertFalse(app.isCPF(rep));
        }
    }

    @Test
    public void cT2() {
        Assert.assertTrue(app.isCPF("01234567890"));
    }

    @Test
    public void cT3() {
        Assert.assertFalse(app.isCPF("11478adfa54"));
    }

    @Test
    public void cT4() {
        Assert.assertFalse(app.isCPF("alfanumerico"));
    }

    @Test
    public void cT5() {
        Assert.assertTrue(app.isCPF("33462461168"));
    }

    @Test
    public void cT6() {
        Assert.assertTrue(app.isCPF("944.475.758-76"));
    }

    @Test
    public void cT7() {
        Assert.assertFalse(app.isCPF(""));
    }

}
