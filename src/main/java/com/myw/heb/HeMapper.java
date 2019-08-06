package com.myw.heb;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class HeMapper extends Mapper<NullWritable, BytesWritable, Text, BytesWritable>{

	private Text kesys;
	
	@Override
	protected void setup(Mapper<NullWritable, BytesWritable, Text, BytesWritable>.Context context)
			throws IOException, InterruptedException {

		InputSplit split = context.getInputSplit();
        Path path = ((FileSplit) split).getPath();
        kesys = new Text(path.toString());
	}
	
	@Override
	protected void map(NullWritable key, BytesWritable value,
			Mapper<NullWritable, BytesWritable, Text, BytesWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		context.write(kesys, value);
	}
	
	
}
