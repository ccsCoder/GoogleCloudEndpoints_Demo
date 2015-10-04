package com.tfl.entity;

import com.tfl.entity.PMF;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JDOCursorHelper;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;


@Api(name = "ratesendpoint", namespace = @ApiNamespace(ownerDomain = "tfl.com", ownerName = "tfl.com", packagePath = "entity"))
public class RatesEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listRates")
	public CollectionResponse<Rates> listRates(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		PersistenceManager mgr = null;
		Cursor cursor = null;
		List<Rates> execute = null;

		try {
			mgr = getPersistenceManager();
			Query query = mgr.newQuery(Rates.class);
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				HashMap<String, Object> extensionMap = new HashMap<String, Object>();
				extensionMap.put(JDOCursorHelper.CURSOR_EXTENSION, cursor);
				query.setExtensions(extensionMap);
			}

			if (limit != null) {
				query.setRange(0, limit);
			}

			execute = (List<Rates>) query.execute();
			cursor = JDOCursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Rates obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Rates> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getRates")
	public Rates getRates(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		Rates rates = null;
		try {
			rates = mgr.getObjectById(Rates.class, id);
		} finally {
			mgr.close();
		}
		return rates;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param rates the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertRates")
	public Rates insertRates(Rates rates) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (containsRates(rates)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.makePersistent(rates);
		} finally {
			mgr.close();
		}
		return rates;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param rates the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateRates")
	public Rates updateRates(Rates rates) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			if (!containsRates(rates)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.makePersistent(rates);
		} finally {
			mgr.close();
		}
		return rates;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeRates")
	public void removeRates(@Named("id") String id) {
		PersistenceManager mgr = getPersistenceManager();
		try {
			Rates rates = mgr.getObjectById(Rates.class, id);
			mgr.deletePersistent(rates);
		} finally {
			mgr.close();
		}
	}

	private boolean containsRates(Rates rates) {
		PersistenceManager mgr = getPersistenceManager();
		boolean contains = true;
		try {
			mgr.getObjectById(Rates.class, rates.getRateType());
		} catch (javax.jdo.JDOObjectNotFoundException ex) {
			contains = false;
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static PersistenceManager getPersistenceManager() {
		return PMF.get().getPersistenceManager();
	}

}
