package com.myw.cob;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class FloMain {

	public static void main(String[] args) throws Exception{
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(FloMain.class);
		job.setMapperClass(FloMapper.class);
		job.setReducerClass(FloReduce.class);

		TextInputFormat.addInputPath(job, new Path("hdfs://192.168.119.151:8020/input/e.txt"));
		TextOutputFormat.setOutputPath(job, new Path("hdfs://192.168.119.151:8020/op/"));


		job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FloBean.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(FloBean.class);

		boolean b = job.waitForCompletion(true);
		System.exit(b ? 0 : 1);
	}
}
