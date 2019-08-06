package com.myw.hy;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Comt {

	public static void main(String[] args) throws Exception {
		
		Configuration conf =new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(Comt.class);
		job.setMapperClass(ComtMapper.class);
		job.setReducerClass(ComtReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        TextInputFormat.addInputPath(job,new Path("hdfs://192.168.119.151:8020/input/y.txt"));
        TextOutputFormat.setOutputPath(job,new Path("hdfs://192.168.119.151:8020/output/"));
        
        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
	}
	
	
}
