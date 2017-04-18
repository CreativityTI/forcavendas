/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.service;

/**
 *
 * @author Creativity
 */
public class CalculadoraPreco {

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}
	
}
