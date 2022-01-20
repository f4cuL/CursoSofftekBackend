package com.utnsofftek.interfaces;

import java.util.List;

public interface DAOInterface<T> {
	    
	    T findById(int id);
	    
	    List<T> findAll();
	    
	    void agregar(T t);
	    
	    void editar(T t, int id);
	    
	    void eliminar(int id);
}
