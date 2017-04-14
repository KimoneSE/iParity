package com.ip.logic.comp;

import com.ip.model.Product;

public class PriceComp extends ProductComp{

	
	
	public PriceComp(boolean asc) {
		super(asc);
	}
	
	public PriceComp() {	}

	@Override
	protected double getCompValue(Product p) {
		return Double.parseDouble(extractNumric( p.getPrice()) ) ;
	}
	
	

}
