package com.csc.idc;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * 
 * NaturalKeyGroupingComparator
 * 
 * This class is used during Hadoop's shuffle phase to group composite Key's by
 * the first part (natural) of their key.
 * 
 * 
 * 
 * @author jpatterson
 * 
 */
public class NaturalKeyGroupingComparator extends WritableComparator {

	protected NaturalKeyGroupingComparator() {
		super(DiagnosisKey.class, true);
	}

	@Override
	public int compare(WritableComparable o1, WritableComparable o2) {

		DiagnosisKey tsK1 = (DiagnosisKey) o1;
		DiagnosisKey tsK2 = (DiagnosisKey) o2;

		return tsK1.getDiagnosis().compareTo(tsK2.getDiagnosis());

	}

}