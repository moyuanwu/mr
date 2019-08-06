package com.myw.coc;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class PairMapper extends Mapper<LongWritable, Text, Pairbean, IntWritable>{

	private Pairbean mapOutKey = new Pairbean();
    private IntWritable mapOutValue = new IntWritable();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Pairbean, IntWritable>.Context context)
			throws IOException, InterruptedException {
		
		 String lineValue = value.toString();
	        String[] strs = lineValue.split("\\|");

	        //设置组合key和value ==> <(key,value),value>
	        mapOutKey.set(strs[0], Integer.valueOf(strs[1]));
	        mapOutValue.set(Integer.valueOf(strs[1]));
	        context.write(mapOutKey, mapOutValue);
	}
}
