package com.myw.coc;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class PairMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(PairMain.class);
		job.setMapperClass(PairMapper.class);
		job.setReducerClass(PairReducer.class);

		TextInputFormat.addInputPath(job, new Path("hdfs://192.168.119.151:8020/input/b.txt"));
		TextOutputFormat.setOutputPath(job, new Path("hdfs://192.168.119.151:8020/outpat/"));

		job.setInputFormatClass(TextInputFormat.class);
		
		job.setMapOutputKeyClass(Pairbean.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		boolean b = job.waitForCompletion(true);
		System.exit(b ? 0 : 1);
	}

}
