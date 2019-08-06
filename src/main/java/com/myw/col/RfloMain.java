package com.myw.col;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class RfloMain {

	public static void main(String[] args) throws Exception{
		
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(RfloMain.class);
		job.setMapperClass(RfloMapper.class);
		job.setReducerClass(RfloReduce.class);

		TextInputFormat.addInputPath(job, new Path("hdfs://192.168.119.151:8020/input/e.txt"));
		TextOutputFormat.setOutputPath(job, new Path("hdfs://192.168.119.151:8020/ops/"));


		job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(RfloBean.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(RfloBean.class);

		job.setNumReduceTasks(6);
        job.setPartitionerClass(RfloPartitioner.class);
		
		boolean b = job.waitForCompletion(true);
		System.exit(b ? 0 : 1);
	}
}
