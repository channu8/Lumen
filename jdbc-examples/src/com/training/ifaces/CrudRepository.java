package com.training.ifaces;

import java.util.*;

public interface CrudRepository <T,E>{
	
	
	public boolean add(T t);
	public List<T> findAll();
	public int update (T t);
	public boolean remove(T t);
	public T findById(E e);

}
