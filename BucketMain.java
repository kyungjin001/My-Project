package project;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BucketMain {

	public static void main(String[] args) {

		List<BucketDTO> bucketList = new ArrayList<BucketDTO>();
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		List<CommunityDTO> communityList = new ArrayList<CommunityDTO>();

		BucketService call1 = new BucketService();
		MemberService call2 = new MemberService();
		CommunityService call3 = new CommunityService();

		boolean run = true;
		Scanner scan = new Scanner(System.in);

		System.out.println("아무거나 누르세요!");
		while (run) {
			scan.nextLine();
			System.out.println("---------------------------------");
			System.out.println("1.회원 | 2.버킷 | 3.커뮤니티 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택>");
			
			try {
			int select = scan.nextInt();
			switch (select) {

			case 1:
				System.out.println("------------------------------------------------------");
				System.out.println("1.회원등록 | 2.전체회원목록 |  3.회원 상세조회  | 4.회원 수정 및 탈퇴");
				System.out.println("------------------------------------------------------");
				System.out.print("기능 선택>");
				int selects = scan.nextInt();
				if (selects == 1) {
					memberList = call2.memberjoin(memberList);
				}
				if (selects == 2) {
					call2.MemberView(memberList);
				}
				if (selects == 3) {
					memberList = call2.MemberCheckView(memberList);
				}
				if (selects == 4) {
					memberList = call2.memberUpdate(memberList);
				}
				break;
			case 2:
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("1.버킷작성 | 2.전체버킷조회 | 3.버킷상세조회 | 4.버킷 수정 및 삭제 | 5.좋아요순 보기 | 6.좋아요 하기 | 7.조회수 순보기  ");
				System.out.println("----------------------------------------------------------------------------------------------");
				System.out.print("기능 선택>");
				selects = scan.nextInt();
				if (selects == 1) {
					bucketList = call1.BucketWrite(bucketList, memberList);
				}
				if (selects == 2) {
					call1.BucketView(bucketList);
				}
				if (selects == 3) {
					bucketList = call1.BucketCheckView(bucketList, memberList);
				}
				if (selects == 4) {
					bucketList = call1.BucketUpdate(bucketList, memberList);
				}
				if (selects == 5) {
					call1.BucketLike(bucketList);
				}
				if (selects == 6) {
					bucketList = call1.BucketChoice(bucketList);
				}
				if (selects == 7) {
					call1.BesttView(bucketList);
				}
				break;
			case 3:
				System.out.println("------------------------------------------------------");
				System.out.println("1.커뮤니티 글작성 | 2.전체글조회 | 3.글상세조회 | 4.글 수정 및 삭제");
				System.out.println("------------------------------------------------------");
				System.out.print("기능 선택>");
				selects = scan.nextInt();
				if (selects == 1) {
					communityList = call3.CommunityWrite(communityList, memberList);
				}
				if (selects == 2) {
					call3.CommunityView(communityList);
				}
				if (selects == 3) {
					communityList = call3.CommunityCheckView(communityList, memberList);
				}
				if (selects == 4) {
					communityList = call3.CommunityUpdate(communityList, memberList);
				}
				break;
			case 4:
				// 종료
				System.out.println("종료합니다.");
				run = false;
				break;
			default:
				// 잘못된 선택
				System.out.println("다시 선택해주세요.");
				break;
			}

		}catch(InputMismatchException e) {
			System.out.println("숫자를 입력하세요.");
		}

	}

	}
}
