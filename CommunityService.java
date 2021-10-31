package project;

import java.util.List;
import java.util.Scanner;

public class CommunityService {
	Scanner scan = new Scanner(System.in);

	// 커뮤니티 글작성
	List<CommunityDTO> CommunityWrite(List<CommunityDTO> communityList, List<MemberDTO> memberList) {

		int result = loginCheckd(memberList);
		if (result >= 0) {
			System.out.print("작성자 : ");
			String writer = scan.next();
			System.out.print("작성내용 : ");
			String Contents = scan.next();
			int writeNumber = communityList.size() + 1;
			CommunityDTO c1 = new CommunityDTO(writer, writeNumber, Contents);
			communityList.add(c1);

		} else {
			System.out.println("아이디 또는 비밀번호가 틀립니다.");
		}

		return communityList;
	}

	// 전체 글조회
	void CommunityView(List<CommunityDTO> communityList) {
		for (CommunityDTO c : communityList) {
			System.out.println(c);
		}
	}

	// 글 상세조회
	List<CommunityDTO> CommunityCheckView(List<CommunityDTO> communityList, List<MemberDTO> memberList) {
		int result = loginChecksd2(memberList);
		if (result >= 0) {
			communityList.get(result).setWriteHits(communityList.get(result).getWriteHits() + 1);
			System.out.println(communityList.get(result));

		} else {
			System.out.println("버킷번호를 다시 입력해주세요.");
		}
		return communityList;
	}

	// 글 수정
	List<CommunityDTO> CommunityUpdate(List<CommunityDTO> communityList, List<MemberDTO> memberList) {
		int result = loginCheckd(memberList);
		if (result >= 0) {
			boolean run = true;
			while (run) {
				System.out.print("삭제는 1, 수정은 2 입력 :");
				int answer = scan.nextInt();
				switch (answer) {
				case 1:
					communityList.remove(result);
					System.out.println("버킷이 삭제되었습니다.");
					run = false;
					break;
				case 2:
					System.out.print("변경할 내용:");
					String modifyco = scan.next();
					communityList.get(result).setContents(modifyco);
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

		return communityList;
	}

	public int loginCheckd(List<MemberDTO> memberList) {
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

	public int loginChecksd2(List<MemberDTO> memberList) {
		System.out.print("글 번호:");
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
