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
* CT1		         ""                                         CE1	               Válido
* CT2	          944.475.758-76	 com sinais                 CE2,CE4	           Inválido
* CT3	          53140776047	     cpf válido                 CE3,CE4	           Válido
* CT5	          alfanumerico	     alfanuméricos              CE3,CE4	           Inválido
* CT6	          11478adfa54	     misturado                  CE3,CE4	           Inválido
* CT7	          01234567890	     cpf inválido               CE3,CE4	           Válido
* CT8	          de (0 à 9) x 11 	 numeros repetidos          CE3,CE4            Inválido
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
        Assert.assertFalse(app.isCPF(""));
    }

    @Test
    public void cT2() {
        Assert.assertTrue(app.isCPF("944.475.758-76"));
    }

    @Test
    public void cT3() {
        Assert.assertTrue(app.isCPF("33462461168"));
    }

    @Test
    public void cT5() {
        Assert.assertFalse(app.isCPF("alfanumerico"));
    }

    @Test
    public void cT6() {
        Assert.assertFalse(app.isCPF("11478adfa54"));
    }

    @Test
    public void cT7() {
        Assert.assertTrue(app.isCPF("01234567890"));
    }

    @Test
    public void cT8() {
        for (int i = 0; i <= 9; i++) {
            char z = (char)i;
            String rep = StringUtils.leftPad("", 11, z);
            Assert.assertFalse(app.isCPF(rep));
        }
    }
}
