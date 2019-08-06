package com.myw.col;

import java.util.HashMap;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Partitioner;

public class RfloPartitioner extends Partitioner<Text, RfloBean>{

	public static HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	static {
		
		hm.put("134", 0);
		hm.put("135", 1);
		hm.put("136", 2);
		hm.put("137", 3);
		hm.put("138", 4);
	}
	@Override
	public int getPartition(Text key, RfloBean value, int arg2) {

		Integer code = hm.get(key.toString().substring(0, 3));
		 if (code != null) {
	            return code;
	        }
	        
	        return 5;
	}

	
}
