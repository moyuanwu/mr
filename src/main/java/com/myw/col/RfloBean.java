package com.myw.col;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class RfloBean implements Writable{

	//上行流量
    private long upFlow;
    //下行流量
    private long downFlow;
    //总流量
    private long sumFlow;
    
    public void set(long upFlow, long downFlow) {
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow+downFlow;
    }
    
	@Override
	public String toString() {
		return "FloBean [上行流量=" + upFlow + ", 下行流量=" + downFlow + ", 总流量=" + sumFlow + "]";
	}


	public long getUpFlow() {
		return upFlow;
	}


	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}


	public long getDownFlow() {
		return downFlow;
	}


	public void setDownFlow(long downFlow) {
		this.downFlow = downFlow;
	}


	public long getSumFlow() {
		return sumFlow;
	}


	public void setSumFlow(long sumFlow) {
		this.sumFlow = sumFlow;
	}


	public RfloBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RfloBean(long upFlow, long downFlow, long sumFlow) {
		super();
		this.upFlow = upFlow;
		this.downFlow = downFlow;
		this.sumFlow = sumFlow;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.upFlow = in.readLong();
		this.downFlow=in.readLong();
        this.sumFlow=in.readLong();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeLong(upFlow);
		out.writeLong(downFlow);
		out.writeLong(sumFlow);
		
	}
    
    
}
