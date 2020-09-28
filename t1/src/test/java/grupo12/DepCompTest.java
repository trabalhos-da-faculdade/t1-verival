/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author lucas
 */
public class DepCompTest {

    private DepComb dc = null;

    @BeforeEach
    void setUp() {

    }
    
    @ParameterizedTest
    @CsvSource({
        "251,5001,626,626,NORMAL",
        "249,4999,624,624,SOBRAVISO",
        "124,2499,311,311,EMERGENCIA"
    })
    public void getSituacaoTest(int aditivo,int gasolina,int alcool1,int alcool2,DepComb.SITUACAO resultado) {
        dc = new DepComb(aditivo, gasolina, alcool1, alcool2);
        DepComb.SITUACAO aux = dc.getSituacao();
        Assertions.assertEquals( resultado, aux);
    }
    
    
    @Test
    public void gettGasolinaTest() {
        int gasolina = 10000;
        dc = new DepComb(500, gasolina, 1250, 1250);
        int aux = dc.gettGasolina();
        Assertions.assertEquals(gasolina, aux);
    }

    @Test
    public void gettAditivoTest() {
        int aditivo = 500;
        dc = new DepComb(aditivo, 10000, 1250, 1250);
        int aux = dc.gettAditivo();
        Assertions.assertEquals(aditivo, aux);
    }

    @Test
    public void gettAlcool1() {
        int alcool = 1250;
        dc = new DepComb(500, 10000, alcool, 1250);
        int aux = dc.gettAlcool1();
        Assertions.assertEquals(alcool, aux);
    }
    
    
    @Test
    public void gettAlcool2() {
        int alcool = 1250;
        dc = new DepComb(500, 10000, 1250, alcool);
        int aux = dc.gettAlcool2();
        Assertions.assertEquals(alcool, aux);
    }

    @ParameterizedTest
    @CsvSource({
        "500, 1,-1",
        "0,-1,-1"
    })
    public void recebeAditivoTest(int aditivoIni, int aditivoExtra, int retorno) {
        dc = new DepComb(aditivoIni, 10000, 1250, 1250);

        int aux = dc.recebeAditivo(aditivoExtra);

        Assertions.assertEquals(retorno, aux);
    }

    @ParameterizedTest
    @CsvSource({
        "10000, 1,-1",
        "0,-1,-1"
    })
    public void recebeGasolinaTest(int gasolinaIni, int gasolinaExtra, int retorno) {
        dc = new DepComb(500, gasolinaIni, 2500, 2500);
        int aux = dc.recebeGasolina(gasolinaExtra);
        Assertions.assertEquals(retorno, aux);
    }

    @ParameterizedTest
    @CsvSource({
        "1250, 1,-1",
        "0,-1,-1"
    })
    public void recebeAlcoolTest(int alcoolIni, int alcoolExtra, int retorno) {
        dc = new DepComb(500, 10000, alcoolIni, alcoolIni);
        int aux = dc.recebeAlcool(alcoolExtra);
        Assertions.assertEquals(retorno, aux);
    }
    
    @ParameterizedTest
    @CsvSource({
        "251,5001,626,626,-1,COMUM,{-1,null,null,null}",
        "124,2499,311,311,400,COMUM,{-2,null,null,null}",
        "251,5001,626,626,10000,COMUM,{-3,null,null,null}",
        "251,5001,626,626,400,ESTRATEGICO,{20,280,50,50}",
    })
     public void encomendaCombustivel(int aditivo,int gasolina,int alcool1,int alcool2,int qtdade, DepComb.TIPOPOSTO tipoPosto,int [] resultado) { 
         dc = new DepComb(aditivo, gasolina, alcool1, alcool2);
         int[] aux = dc.encomendaCombustivel(qtdade, tipoPosto);
         Assertions.assertEquals(resultado, aux);
     }
}
