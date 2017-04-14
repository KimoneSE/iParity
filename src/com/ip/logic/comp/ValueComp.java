package com.ip.logic.comp;

import com.ip.model.Product;

public class ValueComp extends ProductComp {

	public ValueComp(){}
	
	public ValueComp(boolean asc) {super(asc);}

	@Override
	protected double getCompValue(Product p) {
		return Double.parseDouble(p.getValue());
	}
}
