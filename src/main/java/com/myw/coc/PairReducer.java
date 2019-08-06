package com.myw.coc;


import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class PairReducer extends Reducer<Pairbean, IntWritable, Text, IntWritable>{

	private Text outPutKey = new Text();
	
	@Override
	protected void reduce(Pairbean arg0, Iterable<IntWritable> arg1,
			Reducer<Pairbean, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {

		for(IntWritable value : arg1) {
            outPutKey.set(arg0.getFirst());
            arg2.write(outPutKey, value);
        }
		
	}
}
