package project;

import java.util.List;

public interface BucketInterface {

	
	
	List<BucketDTO> BucketWrite(List<BucketDTO> bucketList, List<MemberDTO> memberList);
	
	
	void BucketView(List<BucketDTO> bucketList);
	
	List<BucketDTO> BucketChoice(List<BucketDTO> bucketList);

	void BucketLike(List<BucketDTO> bucketList);
	
	List<BucketDTO> BucketCheckView(List<BucketDTO> bucketList, List<MemberDTO> memberList);
	
	void BesttView(List<BucketDTO> bucketList);
	
	List<BucketDTO> BucketUpdate(List<BucketDTO> bucketList, List<MemberDTO> memberList);
	
	public int loginChecks(List<MemberDTO> memberList);
	
	public int loginChecks2(List<MemberDTO> memberList);
	
}
