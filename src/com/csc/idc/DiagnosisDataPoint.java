package com.csc.idc;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.hadoop.io.Writable;

/**
 * 
 * DiagnosisDataPoint
 * 
 * The basic value or point type in the Map Reduce application.
 * 
 * @author jpatterson
 * 
 */
public class DiagnosisDataPoint implements Writable,
		Comparable<DiagnosisDataPoint> {
	// , Comparable
	public int iCount;
	public int iKey;

	//private static final String DATE_FORMAT = "yyyy-MM-dd";
	//private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	/**
	 * Deserializes the point from the underlying data.
	 * 
	 * @param in
	 *            A DataInput object to read the point from.
	 * @see java.io.DataInput
	 * @see org.apache.hadoop.io.Writable#readFields(java.io.DataInput)
	 * 
	 */
	public void readFields(DataInput in) throws IOException {

		this.iCount = in.readInt();
		this.iKey = in.readInt();
	}

	/**
	 * This is a static method that deserializes a point from the underlying
	 * binary representation.
	 * 
	 * @param in
	 *            A DataInput object that represents the underlying stream to
	 *            read from.
	 * @return A DiagnosisDataPoint
	 * @throws IOException
	 */
	public static DiagnosisDataPoint read(DataInput in) throws IOException {

		DiagnosisDataPoint p = new DiagnosisDataPoint();
		p.readFields(in);
		return p;

	}

/*	public String getDate() {

		return sdf.format(this.lDateTime);

	}*/

	public void copy(DiagnosisDataPoint source) {

		this.iCount = source.iCount;
		this.iKey = source.iKey;

	}

	@Override
	public void write(DataOutput out) throws IOException {

		out.writeInt(this.iCount);
		out.writeInt(this.iKey);

	}

	/**
	 * This is only used in the case of manually sorting the data in the reducer
	 * 
	 * Map Reduce itself does not use this method for sorting the data.
	 * 
	 */
	@Override
	public int compareTo(DiagnosisDataPoint oOther) {
		if (this.iKey < oOther.iKey) {
			return -1;
		} else if (this.iKey > oOther.iKey) {
			return 1;
		}

		// default -- they are equal
		return 0;
	}

}
