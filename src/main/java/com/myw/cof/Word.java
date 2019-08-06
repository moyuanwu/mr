package com.myw.cof;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class Word extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		// 拿到一行数据转换为 string
		String line = value.toString();
		// 将这一行切分出各个单词
		String[] words = line.split("\\|");
		// 遍历数组，输出<单词，1>
		for (String word : words) {

			context.write(new Text(word), new IntWritable(1));
			
		}
	}
}
