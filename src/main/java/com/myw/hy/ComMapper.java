package com.myw.hy;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class ComMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		 String[] split = value.toString().split(":");
         String person = split[0];
         String[] friends = split[1].split(",");
         for (String friend : friends) {
             context.write(new Text(friend),new Text(person));
         }
     }
}
