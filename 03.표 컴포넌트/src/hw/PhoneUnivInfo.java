package hw;

public class PhoneUnivInfo extends PhoneInfo {
	private String major;
	private String grade;

	public PhoneUnivInfo(String name, String birthDay, String phoneNum, String major, String grade) {
		super(name, birthDay, phoneNum);
		
		this.major = major;
		this.grade = grade;
	}
}
