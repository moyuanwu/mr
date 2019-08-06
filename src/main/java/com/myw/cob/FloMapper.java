package com.myw.cob;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class FloMapper extends Mapper<LongWritable, Text, Text, FloBean>{

	Text k =new Text();
	FloBean fb =new FloBean();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FloBean>.Context context)
			throws IOException, InterruptedException {
		
		String valStr = value.toString();
        String[] strs = valStr.split("\t");
        System.out.println("strs.length:"+strs.length);
        k.set(strs[0]);
        fb.set(Long.parseLong(strs[(strs.length-3)]),Long.parseLong(strs[(strs.length-2)]));

        context.write(k,fb);
	}
}
