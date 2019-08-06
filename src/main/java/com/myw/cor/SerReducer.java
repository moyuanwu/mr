package com.myw.cor;

import java.io.IOException;

import org.apache.hadoop.io.*;

import org.apache.hadoop.mapreduce.Reducer;

public class SerReducer extends Reducer<Text, NullWritable,Text, NullWritable>{

	@Override
	protected void reduce(Text arg0, Iterable<NullWritable> arg1,
			Reducer<Text, NullWritable, Text, NullWritable>.Context arg2) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		arg2.write(arg0, NullWritable.get());
	}
}
