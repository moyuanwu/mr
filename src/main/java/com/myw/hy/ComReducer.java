package com.myw.hy;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class ComReducer extends Reducer<Text, Text, Text, Text>{

	@Override
	protected void reduce(Text arg0, Iterable<Text> arg1, Reducer<Text, Text, Text, Text>.Context arg2)
			throws IOException, InterruptedException {

		StringBuffer buffer = new StringBuffer();
		for (Text person : arg1) {
            buffer.append(person).append("-");
        }
        arg2.write(arg0,new Text(buffer.toString()));
    }
}
