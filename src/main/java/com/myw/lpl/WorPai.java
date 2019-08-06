package com.myw.lpl;

import org.apache.hadoop.io.RawComparator;

public class WorPai implements RawComparator<WordWrit>{

	@Override
	public int compare(WordWrit arg0, WordWrit arg1) {
		// TODO Auto-generated method stub
		arg0.getCount();
		return 0;
	}

	@Override
	public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
