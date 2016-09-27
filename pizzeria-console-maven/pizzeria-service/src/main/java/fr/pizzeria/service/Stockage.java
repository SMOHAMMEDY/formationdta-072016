package fr.pizzeria.service;

import java.util.Collection;



// T peux etre client ou Pizza ////et E c'est le type de l'identifiant qui peut etre Integer ou String

public interface Stockage<T, E> {

	Collection<T> findAll();
	//Collection<T> findAllLumbda();// juste pour voir l'évolution de l'ecriture avec des lumda voir stockagePizzaSpringJDBC
	//Collection<T> findAllLumbdaChamp();//juste pour voir l'évolution de l'ecriture avec des lumda voir stockagePizzaSpringJDBC
	
	T find (E code);

	void save(T newElement);

	void update(T editElement, E code);

	void delete(E ancienCode);

	
}
