package edu.asu.ptbs;

public class PTBSMain {

	static Facade theFacade = new Facade();

	public PTBSMain() {
	}

	public static void main(String[] args) {
//		String strUsername;
//		String strUserType = null;
		UserInfoItem userinfoitem = new UserInfoItem();
		theFacade.CreateProductList();
		while (true) {
			boolean bExit = false;
			bExit = Facade.Login(userinfoitem);
			if (bExit)
				break;
			theFacade.CreateUser(userinfoitem);
			theFacade.AttachProductToUser();
			if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer) // if is a buyer remind of the due date
				theFacade.Remind();
			boolean bLogout = false;
			while (!bLogout) {
				bLogout = theFacade.SelectProduct();
				if (bLogout)
					break;
				bLogout = theFacade.ProductOperation();
			}
		}
//    System.out.println(userinfoitem.strUserName +userinfoitem.UserType );
	}
}