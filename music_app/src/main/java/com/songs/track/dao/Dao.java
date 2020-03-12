package com.songs.track.dao;

import java.util.List;
import java.util.Optional;


public interface Dao<T> {
	 
	   T get(long id);
	     
	    List<T> getAll();
	     
	   T save(T t);
	     
	    boolean delete(T t);
	    
}
