package edu.asu.ptbs;

public class UserInfoItem {

	public enum USER_TYPE {
		Buyer, Seller
	}

	String strUserName;
	USER_TYPE UserType; // 0 : Student, 1: Instructor
}