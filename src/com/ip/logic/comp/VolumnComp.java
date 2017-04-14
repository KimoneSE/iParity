package com.ip.logic.comp;

import com.ip.model.Product;

public class VolumnComp extends ProductComp{

	public VolumnComp(){}
	
	public VolumnComp(boolean asc){
		super(asc);
	}

	@Override
	protected double getCompValue(Product p) {
		return p.getVolumn();
	}

	
}
