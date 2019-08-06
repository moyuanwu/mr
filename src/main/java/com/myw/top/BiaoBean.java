package com.myw.top;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class BiaoBean implements WritableComparable<BiaoBean>{

	private String orderId;
    private Double price;
	public BiaoBean(String orderId, Double price) {
		super();
		this.orderId = orderId;
		this.price = price;
	}
	public BiaoBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BiaoBean [orderId=" + orderId + ", price=" + price + "]";
	}
	@Override
	public void readFields(DataInput in) throws IOException {
		// TODO Auto-generated method stub
		this.orderId = in.readUTF();
		this.price = in.readDouble();
		
	}
	@Override
	public void write(DataOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeUTF(orderId);
		out.writeDouble(price);
		
	}
	@Override
	public int compareTo(BiaoBean o) {
		
		//比较订单id的排序顺序
        int i = this.orderId.compareTo(o.orderId);
        if(i==0){
          //如果订单id相同，则比较金额，金额大的排在前面
           i = - this.price.compareTo(o.price);
        }
        return i;
	}
    
    
}
