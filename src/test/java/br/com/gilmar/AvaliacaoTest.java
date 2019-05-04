package br.com.gilmar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AvaliacaoTest {

    private Avaliacao avaliacao;

    @Before
    public void setup() {
        avaliacao = new Avaliacao();
    }

    //CT03
    @Test(expected = ValoresInvalidosException.class)
    public void testeNota1MenorZero() throws ValoresInvalidosException {
        avaliacao.avalia(-7.0, 6.0, 5, 96);
    }

    //CT04    
    @Test(expected = ValoresInvalidosException.class)
    public void testeNota1MaiorDez() throws ValoresInvalidosException {
        avaliacao.avalia(11.0, 6.0, 5, 96);
    }

    //CT05
    @Test(expected = ValoresInvalidosException.class)
    public void testeNota2MenorZero() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, -1.0, 5, 96);
    }

    //CT06
    @Test(expected = ValoresInvalidosException.class)
    public void testeNota2MaiorDez() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, 12.0, 5, 96);
    }

    //CT07
    @Test(expected = ValoresInvalidosException.class)
    public void testeFaltasMenorZero() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, 7.0, -3, 96);
    }

    //CT08
    @Test(expected = ValoresInvalidosException.class)
    public void testeFaltasMenorCargaHoraria() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, 7.0, 97, 96);
    }

    //CT09
    @Test(expected = ValoresInvalidosException.class)
    public void testeFaltasMaiorCargaHoraria() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, 7.0, 97, -1);
    }

    //CT10
    @Test(expected = ValoresInvalidosException.class)
    public void testeCT10() throws ValoresInvalidosException {
        avaliacao.avalia(8.0, 7.0, 16, -1);
    }

     //CT11
     @Test
     public void testeReprovadoFalta() throws ValoresInvalidosException {
         String resultado = avaliacao.avalia(8.0, 7.0, 28, 96);
         Assert.assertTrue(resultado == "Reprovado por Falta.");
     }

     //CT12
     @Test
     public void testeReprovadoMedia() throws ValoresInvalidosException {
         String resultado = avaliacao.avalia(2.0, 3.0, 15, 96);
         Assert.assertTrue(resultado == "Reprovado por Média.");
     }

     //CT13
     @Test
     public void testeProvaExtra() throws ValoresInvalidosException {
         String resultado = avaliacao.avalia(4.0, 5.0, 15, 96);
         Assert.assertTrue(resultado == "Prova Extra.");
     }

      //CT14
      @Test
      public void testeAprovado() throws ValoresInvalidosException {
          String resultado = avaliacao.avalia(7.0, 8.0, 15, 96);
          Assert.assertTrue(resultado == "Aprovado.");
      }



   
}
