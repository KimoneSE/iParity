package com.ip.logic.comp;

import java.util.Comparator;

import com.ip.model.Product;

public abstract class ProductComp implements Comparator<Product> {

	private boolean asc = true;
	
	public ProductComp() {}
	
	public ProductComp(boolean asc) {
		this.asc = asc;
	}
	
	
	
	public static String extractNumric(String str) {
		int start = 0;
		int endindex = 0;
		for(start=0; start< str.length(); start++) {
			char temp = str.charAt(start);
			if(temp=='.'||(temp<='9'&&temp>='0')){
				break;
			}
		}
		
		for(endindex=start+1; endindex<str.length(); endindex++) {
			char temp = str.charAt(endindex);
			if(temp=='.'||(temp<='9'&&temp>='0')){
				continue;
			}else{
				break;
			}
		}
		return str.substring(start, endindex);
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
