package com.ip.logic.comp;

import java.util.Comparator;

import com.ip.model.Product;

public abstract class ProductComp implements Comparator<Product> {

	private boolean asc = true;
	
	public ProductComp() {}
	
	public ProductComp(boolean asc) {
		this.asc = asc;
	}
	
	protected abstract double getCompValue(Product p);
	
	@Override
	public int compare(Product o1, Product o2) {
		double d1;
		double d2;
		int result;
		
		try{
			d1 = getCompValue(o1);
		}catch(Exception e){
			d1 = asc?Double.MAX_VALUE:Double.MIN_VALUE;
		}
		try{
			d2 = getCompValue(o2);
		}catch(Exception e){
			d2 = asc?Double.MAX_VALUE:Double.MIN_VALUE;;
		}
		result = d1==d2? 0 : ((d1>d2)? 1 : -1);
		return asc? result : 0-result;
	}

}
