package com.csc.idc;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * CompositeKeyComparator
 * 
 * Purpose: Compares two WriteableComparables
 * 
 * When we are sorting keys, in this case we only want to sort by group ids in
 * that we want all of the same group ids grouped together regardless of the
 * timestamp portion of their key. This functionality is provided by the
 * NaturalKeyGroupingComparator class
 * 
 * Inside the set of k/v pairs in this group, in this secondary sort example we
 * want to sort on the second half of the key (DiagnosisKey) which is the
 * purpose of this class.
 * 
 * 
 * @author jpatterson
 * 
 */
public class CompositeKeyComparator extends WritableComparator {

	protected CompositeKeyComparator() {
		super(DiagnosisKey.class, true);
	}

	@Override
	public int compare(WritableComparable w1, WritableComparable w2) {

		DiagnosisKey ip1 = (DiagnosisKey) w1;
		DiagnosisKey ip2 = (DiagnosisKey) w2;

		int cmp = ip1.getDiagnosis().compareTo(ip2.getDiagnosis());
		if (cmp != 0) {
			return cmp;
		}

		return ip1.getKey() == ip2.getKey() ? 0 : (ip1
				.getKey() < ip2.getKey() ? -1 : 1);

	}

}