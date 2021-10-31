package project;

import java.util.Comparator;

public class BucketDTO implements Comparable<BucketDTO> {

	// 필드선언
	private String bucket;
	private String bucketContents;
	private int bucketNumber;
	private int bucketHits = 0;
	private int bucketselect = 0;

	@Override
	public int compareTo(BucketDTO o) {
		if (o.bucketHits < bucketHits) {
			return 1;
		} else if (o.bucketHits > bucketHits) {
			return -1;
		}
		return 0;
	}

	BucketDTO() {

	}

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getBucketContents() {
		return bucketContents;
	}

	public void setBucketContents(String bucketContents) {
		this.bucketContents = bucketContents;
	}

	public int getBucketNumber() {
		return bucketNumber;
	}

	public void setBucketNumber(int bucketNumber) {
		this.bucketNumber = bucketNumber;
	}

	public int getBucketHits() {
		return bucketHits;
	}

	public void setBucketHits(int bucketHits) {
		this.bucketHits = bucketHits;
	}

	public int getBucketselect() {
		return bucketselect;
	}

	public void setBucketselect(int bucketselect) {
		this.bucketselect = bucketselect;
	}

	@Override
	public String toString() {
		return "BucketDTO [bucket=" + bucket + ", bucketContents=" + bucketContents
				+ ", bucketNumber=" + bucketNumber + ", bucketHits=" + bucketHits + ", bucketselect=" + bucketselect
				+ "]";
	}

}

class SelectCompare implements Comparator<BucketDTO> {

	@Override
	public int compare(BucketDTO o1, BucketDTO o2) {

		if (o1.getBucketselect() < o2.getBucketselect()) {
			return 1;
		} else if (o1.getBucketselect() > o2.getBucketselect()) {
			return -1;
		}
		return 0;

	}

}
