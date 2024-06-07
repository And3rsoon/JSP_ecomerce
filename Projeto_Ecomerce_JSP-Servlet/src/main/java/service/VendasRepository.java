package service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dao.Vendas;

public class VendasRepository {

	
	public EntityManager getEM() {
		EntityManagerFactory etf=Persistence.createEntityManagerFactory("usuario");
		EntityManager em=etf.createEntityManager();
		return em;
	}
	
	public String gavar(Vendas vendas) {
		EntityManager etm=this.getEM();
		try{
			etm.getTransaction().begin();
			etm.persist(vendas);
			etm.getTransaction().commit();
			etm.close();
			return "ok";
		}
		catch(Exception e) {
			return "erro";
		}
	}
	
	public String deletar(Vendas vendas) {
		EntityManager etm=this.getEM();
		try{
			etm.getTransaction().begin();
			etm.remove(vendas);
			etm.getTransaction().commit();
			etm.close();
			return "ok";
		}
		catch(Exception e) {
			return "erro";
		}		
	}
	
	public List<Vendas> ListarTodos(String cod_produto) {
		EntityManager etm=this.getEM();
		try{
				List<Vendas> query = etm.createQuery("SELECT * FROM user WHERE cod_produto=?1", Vendas.class)
						.setParameter(0, cod_produto)
						.getResultList();
				return query;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public List<Vendas>  consultar(Vendas cod_cliente) {
		EntityManager etm=this.getEM();
		try{
			String sqlString = "SELECT * From user WHERE cod_produto="+cod_cliente;
			etm.getTransaction().begin();
            Query query = etm.createNativeQuery(sqlString);
            List<Vendas> results = query.getResultList();
			etm.close();
			return results;
		}
		catch(Exception e) {
			return null;
		}		
		
		
	}
	
	
	
	

}
