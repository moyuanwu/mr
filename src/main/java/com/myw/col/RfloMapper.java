package com.myw.col;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class RfloMapper extends Mapper<LongWritable, Text, Text, RfloBean>{

	Text k =new Text();
	RfloBean fb =new RfloBean();

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, RfloBean>.Context context)
			throws IOException, InterruptedException {
		
		String valStr = value.toString();
        String[] strs = valStr.split("\t");
        System.out.println("strs.length:"+strs[1]);
        String phoneNum = strs[1];
        k.set(phoneNum);
        fb.set(Long.parseLong(strs[(strs.length-3)]),Long.parseLong(strs[(strs.length-2)]));

        context.write(k,fb);
	}
}
