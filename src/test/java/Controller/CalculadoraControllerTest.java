/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author talita
 */
public class CalculadoraControllerTest {
    
    private CalculadoraController calculo;
    
    public CalculadoraControllerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        calculo = new CalculadoraController();
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }    

    /**
     * Test of anuncioOriginal method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testAnuncioOriginal() {
        assertEquals(45, calculo.visualizaOriginal(1.50));
    }

    /**
     * Test of clicksAnuncio method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testClicksAnuncio() {
        assertEquals(12, calculo.clicksAnuncio(100));
    }

    /**
     * Test of compartilhados method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testCompartilhados() {
        assertEquals(1, calculo.compartilhados(100));
    }

    /**
     * Test of engajamento method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testEngajamento() {
        assertEquals(40, calculo.engajamento(1));
    }

    /**
     * Test of visualizacaoTotal method, of class Calculadora.
     */
    @org.junit.jupiter.api.Test
    public void testVisualizacaoTotal() {
        assertEquals(130, calculo.visualizacaoTotal(3.0));
    }
    
}
