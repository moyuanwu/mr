package com.myw.top;

import org.apache.hadoop.io.*;

public class BiaoGroup extends WritableComparator{

	public BiaoGroup() {
		
        super(BiaoBean.class,true);
    }
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
    	BiaoBean first = (BiaoBean) a;
        BiaoBean second = (BiaoBean) b;
        return first.getOrderId().compareTo(second.getOrderId());
    }
}
