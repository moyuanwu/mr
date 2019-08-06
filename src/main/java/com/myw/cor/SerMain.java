package com.myw.cor;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class SerMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf =new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(SerMain.class);
		job.setMapperClass(SerMapper.class);
		job.setReducerClass(SerReducer.class);
		
		job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        TextInputFormat.addInputPath(job,new Path("hdfs://192.168.119.151:8020/input/a.txt"));
        TextOutputFormat.setOutputPath(job,new Path("hdfs://192.168.119.151:8020/outpartition/"));
	
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setMapOutputValueClass(NullWritable.class);
        
        job.setPartitionerClass(SerPartitioner.class);
        job.setNumReduceTasks(2);
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
	}
}
