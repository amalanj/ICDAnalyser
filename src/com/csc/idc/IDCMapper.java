package com.csc.idc;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import com.ancientprogramming.fixedformat4j.format.FixedFormatManager;
import com.ancientprogramming.fixedformat4j.format.impl.FixedFormatManagerImpl;

public class IDCMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, DiagnosisKey, DiagnosisDataPoint> {

	OutputCollector<NullWritable, Text> out;

	private JobConf configuration;
	private final DiagnosisKey diagKey = new DiagnosisKey();
	private final DiagnosisDataPoint diagVal = new DiagnosisDataPoint();
	
	private final int NHDS2000 = 85;
	private final int NHDS2001TO2007 = 88;
	private final int NHDS2008TO2009 = 93;
	private final int NHDS2010 = 149;

	@Override
	public void configure(JobConf job) {

		this.configuration = job;
	}

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<DiagnosisKey, DiagnosisDataPoint> output,
			Reporter reporter) throws IOException {

		FixedFormatManager manager = new FixedFormatManagerImpl();
		String parseByDisease = new String();
		String recordKey = new String();

		if (value.toString().length() == NHDS2000) {
			NHDSFileReader2000 record = manager.load(
					NHDSFileReader2000.class, value.toString());
			parseByDisease = ParseByDisease(record.getDiagCodes());
			recordKey = record.getSex();
		} else if (value.toString().length() == NHDS2001TO2007) {
			NHDSFileReader2001To2007 record = manager.load(
					NHDSFileReader2001To2007.class, value.toString());
			parseByDisease = ParseByDisease(record.getDiagCodes());
			recordKey = record.getSex();
		} else if (value.toString().length() == NHDS2008TO2009) {
			NHDSFileReader2008To2009 record = manager.load(
					NHDSFileReader2008To2009.class, value.toString());
			parseByDisease = ParseByDisease(record.getDiagCodes());
			recordKey = record.getSex();
		} else if (value.toString().length() == NHDS2010) {
			NHDSFileReader2010 record = manager.load(NHDSFileReader2010.class,
					value.toString());
			parseByDisease = ParseByDisease(record.getDiagCodes());
			recordKey = record.getSex();
		}

		String searchFor = this.configuration.get("com.csc.idc.search");

		IntWritable one = new IntWritable(1);
		if (parseByDisease.toLowerCase().indexOf(searchFor.toLowerCase()) != -1) {
			String[] diags = parseByDisease.split(":");
			for (String diag : diags) {
				diagKey.set(diag, Integer.parseInt(recordKey));
				diagVal.iKey = Integer.parseInt(recordKey);
				diagVal.iCount = one.get();
				output.collect(diagKey, diagVal);
			}
		}

	}

	private String ParseByDisease(String actualDiagCodes) {

		StringBuilder sb = new StringBuilder();
		String[] diagCodes = actualDiagCodes.split("(?<=\\G.{5})"); 
		Set<String> diagSet = new LinkedHashSet<String>();
		String[] diagArray = null;

		Arrays.sort(diagCodes);
		for (String diagCode : diagCodes) {
			if (null != diagCode && diagCode.trim().length() > 0) {

				diagSet.add(DiagPropertiesUtil.getProperty(diagCode.replaceAll(
						"-", "")));
			}
		}
		for (String diag : diagSet)
			sb.append(diag).append(":");
		sb.append(",");
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();

	}

}
