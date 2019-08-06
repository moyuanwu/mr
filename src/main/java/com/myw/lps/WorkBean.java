package com.myw.lps;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class WorkBean implements WritableComparable<WorkBean>{

	private String name;
	private int age;
	private String sal;
	public WorkBean(String name, int age, String sal) {
		super();
		this.name = name;
		this.age = age;
		this.sal = sal;
	}
	public WorkBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "WorkBean [name=" + name + ", age=" + age + ", sal=" + sal + "]";
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.name = in.readUTF();
		this.age = in.readInt();
		this.sal = in.readUTF();
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(name);
		out.writeInt(age);
		out.writeUTF(sal);
	}
	@Override
	public int compareTo(WorkBean o) {
		// TODO Auto-generated method stub
		int ab = this.sal.compareTo(o.sal);
		if (ab!=0) {
			return ab;
		}else {
			return Integer.valueOf(this.name).compareTo(
                    Integer.valueOf(o.getName()));
		}
	}
	
	
}
