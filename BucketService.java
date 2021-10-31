package project;

import java.util.*;

public class BucketService implements BucketInterface {
	Scanner scan = new Scanner(System.in);

	@Override
	// 버킷작성 메서드
	public List<BucketDTO> BucketWrite(List<BucketDTO> bucketList, List<MemberDTO> memberList) {

		int result = loginChecks(memberList);
		if (result >= 0) {
			BucketDTO b1 = new BucketDTO();
			System.out.print("나의 버킷 : ");
			b1.setBucket(scan.next());
			System.out.print("버킷 상세내용: ");
			b1.setBucketContents(scan.next());
			int bucketNumber = bucketList.size() + 1;
			b1.setBucketNumber(bucketNumber);
			bucketList.add(b1);

		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다.");
		}

		return bucketList;
	}

	@Override
	// 전체 버킷조회
	public void BucketView(List<BucketDTO> bucketList) {
		for (BucketDTO b : bucketList) {

			System.out.println(b);
		}
	}

	@Override
	// 버킷 좋아요,싫어요
	public List<BucketDTO> BucketChoice(List<BucketDTO> bucketList) {
		System.out.print("버킷번호를 선택하시오 : ");
		int bucketNumber = scan.nextInt();
		bucketNumber -= 1;
		if (bucketNumber < bucketList.size()) {
			BucketDTO bucket = bucketList.get(bucketNumber);
			System.out.print("좋아요는 1번, 싫어요는 2번 입력 : ");
			int bucketNumbers = scan.nextInt();
			if (bucketNumbers == 1) {
				bucket.setBucketselect(bucket.getBucketselect() + 1);
			}
			if (bucketNumbers == 2) {
				bucket.setBucketselect(bucket.getBucketselect() - 1);
			}
			bucketList.set(bucketNumber, bucket);
		} else {
			System.out.println("올바른 숫자를 입력하세요.");
		}

		return bucketList;
	}

	@Override
	// 좋아요 순으로 보기
	public void BucketLike(List<BucketDTO> bucketList) {
		Collections.sort(bucketList, new SelectCompare());// 좋아요순

		for (BucketDTO b : bucketList) {

			System.out.println(b);
		}
	}

	@Override
	// 버킷 상세조회
	public List<BucketDTO> BucketCheckView(List<BucketDTO> bucketList, List<MemberDTO> memberList) {
		int result = loginChecks2(memberList);
		if (result >= 0) {
			bucketList.get(result).setBucketHits(bucketList.get(result).getBucketHits() + 1);
			System.out.println(bucketList.get(result));

		} else {
			System.out.println("버킷번호를 다시 입력해주세요.");
		}
		return bucketList;
	}

	@Override
	// 전체 버킷조회
	public void BesttView(List<BucketDTO> bucketList) {

		Collections.sort(bucketList, Collections.reverseOrder());// 조회수순
		for (BucketDTO b : bucketList) {

			System.out.println(b);
		}
	}

	@Override
	// 버킷 수정
	public List<BucketDTO> BucketUpdate(List<BucketDTO> bucketList, List<MemberDTO> memberList) {
		int result = loginChecks(memberList);
		if (result >= 0) {
			boolean run = true;
			while (run) {
				System.out.print("삭제는 1, 수정은 2 입력 :");
				int answer = scan.nextInt();
				switch (answer) {
				case 1:
					bucketList.remove(result);
					System.out.println("버킷이 삭제되었습니다.");
					run = false;
					break;
				case 2:
					System.out.print("변경할 버킷:");
					String modifybk = scan.next();
					bucketList.get(result).setBucket(modifybk);
					scan.nextLine();
					System.out.print("변경할 내용:");
					String modifyct = scan.next();
					bucketList.get(result).setBucketContents(modifyct);
					System.out.println("변경완료");
					run = false;
					break;
				default:
					System.out.println("다시 입력바랍니다.");
					break;
				}
			}

		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다.");
		}

		return bucketList;
	}

	@Override
	public int loginChecks(List<MemberDTO> memberList) {
		System.out.print("아이디:");
		String id = scan.next();
		System.out.print("비밀번호:");
		String password = scan.next();
		int indexnumber = -1;
		for (int i = 0; i < memberList.size(); i++) {
			if (id.equals(memberList.get(i).getId()) && password.equals(memberList.get(i).getPassword())) {
				indexnumber = i;
			}
		}
		return indexnumber;
	}

	@Override
	public int loginChecks2(List<MemberDTO> memberList) {
		System.out.print("버킷번호:");
		int MemberNumber = scan.nextInt();
		int indexnumber = -1;
		for (int i = 0; i < memberList.size(); i++) {
			if (MemberNumber == memberList.get(i).getMemberNumber()) {
				indexnumber = i;
			}
		}
		return indexnumber;
	}

}
