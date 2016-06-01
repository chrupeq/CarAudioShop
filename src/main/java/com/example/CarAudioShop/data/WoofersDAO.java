package com.example.CarAudioShop.data;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.CarAudioShop.model.Woofers;

@Stateless
@LocalBean
public class WoofersDAO {

    @PersistenceContext
    private EntityManager em;
    
	public List<Woofers> getAllWoofers() {
    	Query query=em.createQuery("SELECT w FROM Woofers w");
        return query.getResultList();
    }
	
	public List<Woofers> getWoofersByModel(String model) {
    	Query query=em.createQuery("SELECT w FROM Woofers AS w "+
    								"WHERE w.model LIKE ?1");
    	query.setParameter(1, "%"+model.toUpperCase()+"%");
        return query.getResultList();
    }
	
	public Woofers getWoofer(int id ) {
        return em.find(Woofers.class, id);
    }
	
	public void save(Woofers woofer){
		em.persist(woofer);
	}
	
	public void update(Woofers woofer) {
		em.merge(woofer);
	}
	
	public void delete(int id) {
		em.remove(getWoofer(id));
	}
/*	public void deleteTable(){
		em.createQuery("DELETE FROM Woofers").executeUpdate();
	}*/
      
}
