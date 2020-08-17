package com.xmltocfdi_3_3.beans;

import java.util.ArrayList;
import java.util.Collection;

public class TestFactory {
 
  public static Collection<Producto> generateCollection() {
	  Collection<Producto> collection = new ArrayList<Producto>();
	  collection.add(new Producto("1819588013100", 
			  						  "50202200 - Bebidas alcohólicas Tequila Tesoro Number 5\n" + 
			  						  "Blanco 100% Agave 12/750 ML 40% Alc. Vol. (80 Proof)", 
			  						  "XBX - Caja",
			  						  "$81.50",
			  						  "",
			  						  "630.00", 
			  						  "$51,345.00") );
	  
	  collection.add(new Producto("1819588013117", 
				  					  "50202200 - Bebidas alcohólicas Tequila Tesoro Number 5\n" + 
				  					  "Reposado 100% Agave 12/750 ML 40% Alc. Vol. (80 Proof)", 
				  					  "XBX - Caja",
				  					  "$81.50",
				  					  "",
				  					  "560.00", 
				  					  "$45,640.00") );
 
    return collection;
  }
}