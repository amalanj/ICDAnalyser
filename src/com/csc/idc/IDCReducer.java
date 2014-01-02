package com.csc.idc;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class IDCReducer extends MapReduceBase implements
		Reducer<DiagnosisKey, DiagnosisDataPoint, Text, IntWritable> {

	@Override
	public void reduce(DiagnosisKey key, Iterator<DiagnosisDataPoint> values,
			OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {

		int sum = 0;
		while(values.hasNext()){
			sum += values.next().iCount;
		}
		Text diagKey = new Text(key.getDiagnosis()+"\t"+key.getKey());
		output.collect(diagKey, new IntWritable(sum));
		//output.collect(new IntWritable(sum), key);
		
	}

}
