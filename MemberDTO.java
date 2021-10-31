package project;

public class MemberDTO {

	// 필드선언
	private int MemberNumber;
	private String name;
	private int age;
	private String id;
	private String password;

	MemberDTO() {

	}

	MemberDTO(int memberNumber, String name, int age, String id, String password) {
		super();
		MemberNumber = memberNumber;
		this.name = name;
		this.age = age;
		this.id = id;
		this.password = password;
	}

	public int getMemberNumber() {
		return MemberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		MemberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberDTO [MemberNumber=" + MemberNumber + ", name=" + name + ", age=" + age + ", id=" + id
				+ ", password=" + password + "]";
	}

}
