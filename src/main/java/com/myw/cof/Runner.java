package com.myw.cof;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Runner {

	// 把这个描述好的 job 提交给集群去运行
	public static void main(String[] args) throws Exception {
		
		Configuration conf = new Configuration();
		Job wcjob = Job.getInstance(conf);
		// 指定我这个 job 所在的 jar 包
		wcjob.setJarByClass(Runner.class);
		wcjob.setMapperClass(Word.class);
		wcjob.setReducerClass(Reduceser.class);
		// 设置我们的业务逻辑 Mapper 类的输出 key 和 value 的数据类型
		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(IntWritable.class);
		// 设置我们的业务逻辑 Reducer 类的输出 key 和 value 的数据类型
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(IntWritable.class);
		// 指定要处理的数据所在的位置
		FileInputFormat.setInputPaths(wcjob, "hdfs://192.168.119.151:8020/input/c.txt");
		// 指定处理完成之后的结果所保存的位置
		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.119.151:8020/outpt/"));
		// 向 yarn 集群提交这个 job
		boolean res = wcjob.waitForCompletion(true);
		System.exit(res ? 0 : 1);
	}
}
