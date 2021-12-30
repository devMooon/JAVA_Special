package hw;

public class PhoneCompanyInfo extends PhoneInfo {
	private String companyName;
	
	public PhoneCompanyInfo(String name, String birthDay, String phoneNum, String companyName) {
		super(name, birthDay, phoneNum);
		
		this.companyName = companyName;
	}
}
