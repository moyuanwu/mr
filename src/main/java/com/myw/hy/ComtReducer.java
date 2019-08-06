package com.myw.hy;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class ComtReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {

		StringBuffer buffer = new StringBuffer();
		for (Text value : arg1) {
			buffer.append(value.toString() + "\t");
		}
		arg2.write(arg0, new Text(buffer.toString()));
	}
}
