/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.util.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

/**
 *
 * @author Creativity
 */
@ApplicationScoped
public class EntityManagerProducer {

	private  EntityManagerFactory factory;
	
	public EntityManagerProducer() {
		factory = Persistence.createEntityManagerFactory("PedidoPU");
	}
	
	@Produces @RequestScoped
	public Session createEntityManager() {
		return (Session) this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes Session manager) {
		manager.close();
	}
	
}
