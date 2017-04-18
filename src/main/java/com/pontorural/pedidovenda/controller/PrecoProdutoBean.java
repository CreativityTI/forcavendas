/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.controller;

import com.pontorural.pedidovenda.service.CalculadoraPreco;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Creativity
 */

@Named("meuBean")
public class PrecoProdutoBean {
    
    
	@Inject
	private CalculadoraPreco calculadora;
	
	public double getPreco() {
		return calculadora.calcularPreco(12, 44.55);
	}
	
}