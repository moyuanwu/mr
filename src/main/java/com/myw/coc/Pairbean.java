package com.myw.coc;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class Pairbean implements WritableComparable<Pairbean>{

	private String first;
	private int second;
	
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void set(String first, int second) {
		
		this.first = first;
		this.second = second;
	}
	
	public Pairbean() {
		super();
	}

	public Pairbean(String first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.first = in.readUTF();
		this.second = in.readInt();
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(first);
		out.writeInt(second);
	}

	@Override
	public int compareTo(Pairbean o) {
		 System.out.println(o.toString());
	        System.out.println(this.toString());
	        int comp = this.first.compareTo(o.first);
	        if (comp != 0) {
	            return comp;
	        } else { // 若第一个字段相等，则比较第二个字段
	            return Integer.valueOf(this.second).compareTo(
	                    Integer.valueOf(o.getSecond()));
	        }
	}

	@Override
	public String toString() {
		return "Pairbean [first=" + first + ", second=" + second + "]";
	}

}
