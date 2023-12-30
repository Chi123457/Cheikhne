package dao.liu.projet2024;

import java.util.List;

import metier.liu.projet2024.Bibliotheque;
import metier.liu.projet2024.Telephone;

public interface dao<T> { 
	    
	T get(long id);
	List<T> getAll();
	void save(T t);
	void update(T t,String[]params);
	void delete(T t);
	Bibliotheque getByID(long id);
}
