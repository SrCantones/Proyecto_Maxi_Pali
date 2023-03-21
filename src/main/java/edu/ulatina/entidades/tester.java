package edu.ulatina.entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class tester {

	private static EntityManagerFactory entityManagerFactory = null;
	private static EntityManager em = null;

	public static void main(String[] args) {

		try {
			System.out.println("INICIANDO");

			startEntityManagerFactory("Proyecto_MaxiPali");

			em = entityManagerFactory.createEntityManager();

			// Aqui iniciamos....

			em.getTransaction().commit();

			stopEntityManagerFactory();
			System.out.println("FINALIZANDO");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void startEntityManagerFactory(String persistenceUnit) throws Exception {

		if (entityManagerFactory == null) {

			try {

				entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnit);

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	public static void stopEntityManagerFactory() throws Exception {

		if (entityManagerFactory != null) {

			if (entityManagerFactory.isOpen()) {

				try {

					entityManagerFactory.close();

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

			entityManagerFactory = null;

		}

	}

	public static void insertarProveedor(Proveedor proveedor, EntityManager entity) {

		entity.persist(proveedor);// insert
		entity.flush();
		entity.refresh(proveedor);

	}

}
