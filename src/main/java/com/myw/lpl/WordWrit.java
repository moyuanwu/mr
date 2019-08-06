package com.myw.lpl;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.*;

public class WordWrit implements WritableComparable<WordWrit>{

	private String word;
	private long count;
	
	
	@Override
	public String toString() {
		return "WordWrit [word=" + word + ", count=" + count + "]";
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public WordWrit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WordWrit(String word, long count) {
		super();
		this.word = word;
		this.count = count;
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(WordWrit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
