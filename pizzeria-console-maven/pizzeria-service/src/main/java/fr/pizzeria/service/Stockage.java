package fr.pizzeria.service;

import java.util.Collection;



// T peux etre client ou Pizza ////et E c'est le type de l'identifiant qui peut etre Integer ou String

public interface Stockage<T, E> {

	Collection<T> findAll();
	
	T find (E code);

	void save(T newElement);

	void update(T editElement, E code);

	void delete(E ancienCode);
	
}
