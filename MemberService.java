package project;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	Scanner scan = new Scanner(System.in);

	// 회원등록 메서드
	List<MemberDTO> memberjoin(List<MemberDTO> memberList) {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("나이 : ");
		int age = scan.nextInt();
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String password = scan.next();
		int MemberNumber = memberList.size() + 1;
		MemberDTO m1 = new MemberDTO(MemberNumber, name, age, id, password);
		memberList.add(m1);
		return memberList;
	}

	// 전체 회원조회
	void MemberView(List<MemberDTO> memberList) {
		for (MemberDTO m : memberList) {
			System.out.println(m);
		}
	}

	// 회원 상세조회
	List<MemberDTO> MemberCheckView(List<MemberDTO> memberList) {
		int result = loginCheck2(memberList);
		if (result >= 0) {
			System.out.println(memberList.get(result));

		} else {
			System.out.println("글번호를 다시 입력해주세요.");
		}
		return memberList;
	}

	// 회원수정
	List<MemberDTO> memberUpdate(List<MemberDTO> memberList) {
		int result = loginCheck(memberList);
		if (result >= 0) {
			boolean run = true;
			while (run) {
				System.out.print("탈퇴는 1, 수정은 2 입력 :");
				int answer = scan.nextInt();
				switch (answer) {
				case 1:
					memberList.remove(result);
					System.out.println("회원탈퇴 완료");
					run = false;
					break;
				case 2:
					System.out.print("변경 비밀번호:");
					String modifyps = scan.next();
					memberList.get(result).setPassword(modifyps);
					System.out.println("변경완료");
					run = false;
					break;
				default:
					System.out.println("다시 입력바랍니다.");
					break;
				}
			}
		}

		else {
			System.out.println("아이디 또는 비밀번호가 틀립니다.");
		}

		return memberList;
	}

	public int loginCheck(List<MemberDTO> memberList) {
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

	public int loginCheck2(List<MemberDTO> memberList) {
		System.out.print("회원번호:");
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
