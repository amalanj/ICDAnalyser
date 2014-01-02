package com.csc.idc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class IDCJob extends Configured implements Tool {

	@Override
	public int run(String[] arg0) throws Exception {

		JobConf conf = new JobConf(getConf(), IDCJob.class);
		conf.setJobName("IDCJob");

		conf.setMapOutputKeyClass(DiagnosisKey.class);
		conf.setMapOutputValueClass(DiagnosisDataPoint.class);

		conf.setMapperClass(IDCMapper.class);
		conf.setReducerClass(IDCReducer.class);

		conf.setPartitionerClass(NaturalKeyPartitioner.class);
		conf.setOutputKeyComparatorClass(CompositeKeyComparator.class);
		conf.setOutputValueGroupingComparator(NaturalKeyGroupingComparator.class);
		
		conf.setInputFormat(TextInputFormat.class);

		conf.setOutputFormat(TextOutputFormat.class);
		conf.setCompressMapOutput(true);

		FileInputFormat.setInputPaths(conf, arg0[0]);
		FileOutputFormat.setOutputPath(conf, new Path(arg0[1]));
		
		conf.set("com.csc.idc.search", arg0[2]);

		JobClient.runJob(conf);

		return 0;

		
	}

	public static void main(String[] args) throws Exception {

		System.out.println("Start of job");
		System.exit(ToolRunner.run(new Configuration(), new IDCJob(), args));
	}
}
