package com.myw.lpl;

import java.io.IOException;
import java.util.Comparator;
import java.util.TreeMap;

import org.apache.commons.collections.comparators.ComparableComparator;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class WorReduces extends Reducer<Text, IntWritable, Text, IntWritable> {

	TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(new Comparator<Integer>() {

		@Override
		public int compare(Integer arg0, Integer arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
	});

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		// reduce后的结果放入treeMap,而不是向context中记入结果
		int sum = 0;
		for (IntWritable val : values) {
			sum += val.get();
		}
		if (treeMap.containsKey(sum)) { // 具有相同单词数的单词之间用逗号分隔
			String value = treeMap.get(sum) + "," + key.toString();
			treeMap.put(sum, value);
		} else {
			treeMap.put(sum, key.toString());
		}
	}

	@Override
	protected void cleanup(Reducer<Text, IntWritable, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// 将treeMap中的结果,按value-key顺序写入contex中
		for (Integer key : treeMap.keySet()) {
			context.write(new Text(treeMap.get(key)), new IntWritable(key));
		}
	}
}
