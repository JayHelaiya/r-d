package com.jay.easyshop.commonservice.commondatabase.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.jay.easyshop.commonservice.utility.Model;



/**
 * This is abstract service class used to provide implementation or definition of basic services used to perform
 * database related activities.
 * @author Mobifin Core team.
 * @version 1.0
 * @since	17/06/2016
 */
/**
 * @author jay
 *
 * @param <M>
 */
public abstract class GenericDaoImpl< M extends Model> {
	
	private final Class< M > clazz;
	 
	@Autowired
	private SessionFactory sessionFactory;

 	@SuppressWarnings("unchecked")
 	public GenericDaoImpl() {
			this.clazz = (Class<M>) ((ParameterizedType) this.getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}
	 
    /**
     * Setter method to set session factory object of hibernate.
     * @param sessionFactory
     */
   
    public void setSessionFactory(SessionFactory sessionFactory) {
    	this.sessionFactory = sessionFactory;
    }
    
    /**
     * it returns current session bound with transaction boundary.
     * @return Session hibernate session
     */
    protected Session getSession() {
    	return sessionFactory.getCurrentSession();
    }
    
     /**
     * @param id
     * @return
     */
    public M get(Long id ){
        return (M) getSession().get( clazz, id );
     }
     /**
     * @return
     */
    @SuppressWarnings("unchecked")
	public List< M > getAll(){
        return getSession().createQuery( "from " + clazz.getName() ).list();
     }
   
     /**
     * @param entity
     */
    public void create( M entity ){
    	 getSession().persist( entity );
     }
   
     /**
     * @param entity
     */
    public void update( M entity ){
    	 getSession().merge( entity );
     }
   
     /**
     * @param entity
     */
    public void delete( M entity ){
    	 getSession().delete( entity );
     }
     /**
     * @param entityId
     */
    public void deleteById( Long entityId ) {
        M entity = get( entityId );
        delete( entity );
     }

}
