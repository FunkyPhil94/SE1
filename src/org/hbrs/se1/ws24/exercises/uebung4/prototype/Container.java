package org.hbrs.se1.ws24.exercises.uebung4.prototype;

import org.hbrs.se1.ws24.solutions.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws24.solutions.uebung3.persistence.PersistenceStrategy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Container <E extends UserStory> {

	private static Container<UserStory> instance;
	private List<E> itemList = new ArrayList<>();
	private PersistenceStrategy<E> persistenceStrategy;


	private Container() {};

	/**
	 * Liefert ein Singleton zurück.
	 * @return
	 */

	public static Container<UserStory> getInstance() {
		if (instance == null) {
			synchronized (Container.class) {
				if (instance == null) {
					instance = new Container<>();
				}
			}
		}
		return instance;
	}

	public void setPersistenceStrategyUserStroies(PersistenceStrategy<E> strategy) {
		this.persistenceStrategy = strategy;
	}

	public String deleteItems(Integer id) {
		if(itemList.isEmpty()) {
			return "Liste ist leer";
		}
		for (E item: itemList) {
			if (item.getId().equals(id)) {
				itemList.remove(item);
				return "Item entfernt";
			}
		}
		return "Item nicht vorhanden";
	}

	/*
	 * Methode zum Speichern der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte gespeichert.
	 * 
	 */
	public void store() throws PersistenceException {
		if(persistenceStrategy == null) throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie festgelegt");
		try {
			persistenceStrategy.save(itemList);
		} catch (UnsupportedOperationException e) {
			throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Strategie nicht implementiert");
		}	}

	/*
	 * Methode zum Laden der Liste. Es wird die komplette Liste
	 * inklusive ihrer gespeicherten UserStory-Objekte geladen.
	 * 
	 */
	public void load() throws PersistenceException {
		if(persistenceStrategy == null) throw new PersistenceException(PersistenceException.ExceptionType.NoStrategyIsSet, "Keine Strategie festgelegt");
		try {
			itemList = persistenceStrategy.load();
		} catch (UnsupportedOperationException e) {
			throw new PersistenceException(PersistenceException.ExceptionType.ImplementationNotAvailable, "Strategie nicht implementiert");
		}


	}

	/**
	 * Methode zum Hinzufügen eines Mitarbeiters unter Wahrung der Schlüsseleigenschaft
	 * @param item
	 * @throws ContainerException
	 */
	public void addItems(E item ) throws ContainerException {
		if ( contains(item) == true ) {
			ContainerException ex = new ContainerException("ID bereits vorhanden!");
			throw ex;
		}
		itemList.add(item);
	}

	/**
	 * Prüft, ob eine UserStory bereits vorhanden ist
	 * @param item
	 * @return
	 */
	private boolean contains(E item) {
		int ID = item.getId();
		for (E search : itemList) {
			if ( search.getId() == ID ) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Ermittlung der Anzahl von internen UserStory
	 * -Objekten
	 * @return
	 */
	public int size() {
		return itemList.size();
	}

	public List<E> getItemList() {
		return this.itemList;
	}

}
