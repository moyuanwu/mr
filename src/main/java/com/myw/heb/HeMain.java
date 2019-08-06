package com.myw.heb;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;


public class HeMain {

	public static void main(String[] args) throws Exception {
		
		Configuration con =new Configuration();
		Job job = Job.getInstance(con);
		
		job.setJarByClass(HeMain.class);
		job.setInputFormatClass(HeInputFormat.class);
		job.setMapperClass(HeMapper.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(BytesWritable.class);
		
		HeInputFormat.addInputPath(job, new Path(""));
		TextOutputFormat.setOutputPath(job, new Path(""));
		
		boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
	}
	
}
