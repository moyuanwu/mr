package com.myw.top;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class BiaoPartition extends Partitioner<BiaoBean, NullWritable>{

	@Override
	public int getPartition(BiaoBean arg0, NullWritable arg1, int arg2) {
		// TODO Auto-generated method stub
		return (arg0.getOrderId().hashCode() & Integer.MAX_VALUE);
	}

}
