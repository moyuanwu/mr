package com.myw.cor;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Partitioner;

public class SerPartitioner extends Partitioner<Text, NullWritable> {

	@Override
	public int getPartition(Text arg0, NullWritable arg1, int arg2) {
		String result = arg0.toString().split("[|]")[3];
		System.out.println(result);
		if (Integer.parseInt(result) > 15) {
			return 1;
		} else {
			return 0;
		}
	}
}
