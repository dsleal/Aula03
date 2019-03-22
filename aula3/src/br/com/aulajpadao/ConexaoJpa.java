package br.com.aulajpadao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexaoJpa {
	private static EntityManagerFactory emf;

	private static EntityManagerFactory criarEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("exemplo");
	}

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = criarEntityManagerFactory();
		}
		return emf.createEntityManager();
	}
}
