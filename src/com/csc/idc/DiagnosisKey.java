package com.csc.idc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class DiagnosisKey implements WritableComparable<DiagnosisKey> {

	private String diagnosis = "";
	private long key = 0;

	public void set(String strGroup, long lTS) {

		this.diagnosis = strGroup;
		this.key = lTS;

	}

	public String getDiagnosis() {
		return this.diagnosis;
	}

	public long getKey() {
		return this.key;
	}

	@Override
	public void readFields(DataInput in) throws IOException {

		this.diagnosis = in.readUTF();
		this.key = in.readLong();

	}

	@Override
	public void write(DataOutput out) throws IOException {

		out.writeUTF(diagnosis);
		out.writeLong(this.key);
	}

	@Override
	public int compareTo(DiagnosisKey other) {

		if (this.diagnosis.compareTo(other.diagnosis) != 0) {
			return this.diagnosis.compareTo(other.diagnosis);
		} else if (this.key != other.key) {
			return key < other.key ? -1 : 1;
		} else {
			return 0;
		}

	}

	public static class DiagnosisKeyComparator extends WritableComparator {
		public DiagnosisKeyComparator() {
			super(DiagnosisKey.class);
		}

		public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
			return compareBytes(b1, s1, l1, b2, s2, l2);
		}
	}

	static { // register this comparator
		WritableComparator.define(DiagnosisKey.class,
				new DiagnosisKeyComparator());
	}

}
