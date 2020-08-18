package com.xmltocfdi_3_3.beans;

import java.util.ArrayList;
import java.util.Collection;

public class MercanciaFactory {
	
	public static Collection<Mercancia> generateCollection() {
		Collection<Mercancia> collection = new ArrayList<Mercancia>();
		collection.add(new Mercancia());
		collection.add(new Mercancia());

		return collection;
	}
	
}