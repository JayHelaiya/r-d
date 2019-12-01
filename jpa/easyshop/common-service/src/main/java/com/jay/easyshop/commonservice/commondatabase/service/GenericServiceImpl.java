package com.jay.easyshop.commonservice.commondatabase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jay.easyshop.commonservice.commondatabase.dao.GenericDao;
import com.jay.easyshop.commonservice.utility.Model;

@Service
@Transactional
public abstract class GenericServiceImpl< M extends Model> {
	
	 
	@Autowired
	GenericDao<M> dao;
     /**
     * @param id
     * @return
     */
    public M get( Long id ){
        return (M) dao.get(id);
     }
     /**
     * @return
     */
	public List< M > getAll(){
        return  dao.getAll();
     }
   
     /**
     * @param entity
     */
    public void create( M entity ){
    	 dao.create( entity );
     }
   
     /**
     * @param entity
     */
    public void update( M entity ){
    	 dao.update( entity );
     }
   
     /**
     * @param entity
     */
    public void delete( M entity ){
    	 dao.delete( entity );
     }
     /**
     * @param entityId
     */
    public void deleteById( Long entityId ) {
        M entity = get( entityId );
        delete( entity );
     }

}
