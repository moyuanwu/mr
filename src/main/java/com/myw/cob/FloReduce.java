package com.myw.cob;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FloReduce extends Reducer<Text, FloBean, Text, FloBean>{

	FloBean fb =new FloBean();
	@Override
	protected void reduce(Text arg0, Iterable<FloBean> arg1, Reducer<Text, FloBean, Text, FloBean>.Context arg2)
			throws IOException, InterruptedException {
		
		long upFlowCount=0;
        long downFlowCount=0;
		
		for (FloBean value : arg1) {
			upFlowCount += value.getUpFlow();
			downFlowCount += value.getDownFlow();
		}
		fb.set(upFlowCount, downFlowCount);
		arg2.write(arg0, fb);
	}
}
