package com.hadoopexpert;

import java.io.IOException;

import org.apache.pig.FilterFunc;
import org.apache.pig.data.Tuple;

public class GoodQuality extends FilterFunc{

	// (quality == 1 OR quality == 2 OR quality == 3 OR quality == 4 OR quality == 5 OR quality == 7);
	@Override
	public Boolean exec(Tuple column) throws IOException {
		
		if(column == null || column.size() == 0){
			return false;
		}
		
		
		Object o = column.get(0);
		int quality = (int) o;
		
		if(quality == 1 || quality == 2 || quality == 3 || quality == 4 || quality == 5 || quality == 7){
			return true;
		}
		else{
			return false;
		}			
		
	}

}
