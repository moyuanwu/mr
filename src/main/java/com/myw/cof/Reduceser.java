package com.myw.cof;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduceser extends Reducer<Text,IntWritable,Text,LongWritable> {
    
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        long count = 0;
        System.out.println(key);
        for (IntWritable value : values) {
            count += value.get();
        }
        context.write(key,new LongWritable(count));
    }
}
