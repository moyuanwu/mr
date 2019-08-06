package com.myw.col;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class RfloReduce extends Reducer<Text, RfloBean, Text, RfloBean>{

	RfloBean fb =new RfloBean();
	@Override
	protected void reduce(Text arg0, Iterable<RfloBean> arg1, Reducer<Text, RfloBean, Text, RfloBean>.Context arg2)
			throws IOException, InterruptedException {
		
		long upFlowCount=0;
        long downFlowCount=0;
		
		for (RfloBean value : arg1) {
			upFlowCount += value.getUpFlow();
			downFlowCount += value.getDownFlow();
		}
		fb.set(upFlowCount, downFlowCount);
		arg2.write(arg0, fb);
	}
}
