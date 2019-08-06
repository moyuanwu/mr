package com.myw.hy;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class ComtMapper extends Mapper<LongWritable,Text,Text,Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		String[] split = value.toString().split("\t");
        String friends = split[0];
        String[] persons = split[1].split("-");
        //排序，避免c-b  与b-c  这样的情况出现
        Arrays.sort(persons);
        for(int i =0;i< persons.length -1 ;i++){
            for(int j = i+1;j<persons.length;j++){
                context.write(new Text(persons[i]+"-"+persons[j]),new Text(friends));
            }

        }
	}
}
