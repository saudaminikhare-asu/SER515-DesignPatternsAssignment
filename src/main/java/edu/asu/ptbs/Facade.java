package edu.asu.ptbs;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Facade {
	public int UserType;
	private Product theSelectedProduct = null;
	private int nProductCategory = 0;
	ClassProductList theProductList;
	Person thePerson;

	public Facade() {
	}

	private File getFileFromResource(String fileName) throws URISyntaxException {

		ClassLoader classLoader = getClass().getClassLoader();
		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("file not found! " + fileName);
		} else {

			// failed if files have whitespaces or special characters
			//return new File(resource.getFile());

			return new File(resource.toURI());
		}

	}

	static public boolean Login(UserInfoItem userinfoItem) {
		Login login = new Login();
		login.setModal(true);
		login.setVisible(true);
		userinfoItem.strUserName = login.GetUserName();
		userinfoItem.UserType = login.GetUserType();
		return login.isExit();
	}

/////////////////////////
//functions for CourseMenu
	/*
	 * When click the add button of the CourseMenu , call this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user it will not update the course menu. the coursemenu need to
	 * refreshed outside the function
	 */

	void AddTrade(Product theProduct) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)/// student
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}
		Trade theTrade = new Trade();
		theTradingMenu.ShowMenu(theTrade, thePerson);
		theProduct.addTrade(theTrade);
	}

	/*
	 * When click the view button of the CourseMenu , call this function and pass
	 * the pointer of the Assignment and the person pointer to this function this
	 * function will new an assignment fill the required infomation this function
	 * will call InstructorAssignmentMenu or StudentAssignmentMenu according to the
	 * type of the user
	 */
	void ViewTrade(Trade theTrade) {
		TradingMenu theTradingMenu;
		if (thePerson.type == 0)/// student
		{
			theTradingMenu = new BuyerTradingMenu();
		} else {
			theTradingMenu = new SellerTradingMenu();
		}

		theTradingMenu.ShowMenu(theTrade, thePerson);
	}

//functions for InstructorAssignmentMenu
	/*
	 * this function will grade the give Solution: theSolution this function calls
	 */

	void GradeOffering(Offering theOffering) {
		OfferingMenu offeringMenu = new OfferingMenu();
		offeringMenu.ShowMenu(theOffering);
	}

	void ReportOfferings(Trade theTrade) {
		Offering theOffering;
		OfferingIterator theOfferingIterator;
		theOfferingIterator = theTrade.getOfferingIterator();
		theOffering = (Offering) theOfferingIterator.next();
		while (theOffering != null) {
			theOffering.setReported(true);
			theOffering = (Offering) theOfferingIterator.next();
		}
	}
////////////////////

//functions for StudentAssignmentMenu
	void SubmitOffering(Trade theTrade, Offering theOffering) {
		theTrade.addOffering(theOffering);
	}

//////////
	void Remind() {
		Reminder theReminder = new Reminder();
		theReminder.showReminder(thePerson.GetProductList());
	}

	void CreateUser(UserInfoItem userinfoitem) {
		if (userinfoitem.UserType == UserInfoItem.USER_TYPE.Buyer) /// student
		{
			thePerson = new Buyer();
		} else /// instructor
		{
			thePerson = new Seller();
		}
		thePerson.UserName = userinfoitem.strUserName;
	}

	/*
	 * create a course list and intitialize it with the file CourseInfo.txt
	 */
	void CreateProductList() {
		theProductList = new ClassProductList();
		theProductList.InitializeFromFile("ProductInfo.txt");
	}

	/*
	 * call this function after create user, create courselist read the
	 * UserCourse.txt file match the coursename with theCouresList attach the
	 * Matched course object to the new create user Facade.thePerson.CourseList
	 */
	void AttachProductToUser() {
		Scanner scanner;
		File file;
		try {
			file = getFileFromResource("UserProduct.txt");
			scanner = new Scanner(file);
			String strUserName, strProductName, user;
			while (scanner.hasNextLine()) // not the EOF
			{
				user = scanner.nextLine();
				strUserName = GetUserName(user);
				strProductName = GetProductName(user);
				if (strUserName.compareTo(thePerson.UserName) == 0) /// the UserName matches
				{
					theSelectedProduct = FindProductByProductName(strProductName);
					if (theSelectedProduct != null) /// Find the Course in the CourseList--->attach
					{
						thePerson.AddProduct(theSelectedProduct);
					}
				}
			}
		} catch (Exception ee) {
			;
		}
	}

	/*
	 * get the user name from aline UserName:CourseName
	 */
	private String GetUserName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(0, Sep);
	}

	/*
	 * get the CourseName from aline UserName:CourseName
	 */
	private String GetProductName(String aline) {
		int Sep = aline.lastIndexOf(':');
		return aline.substring(Sep + 1, aline.length());
	}

	/*
	 * show the course selection dlg, show the course attatched to theperson and
	 * return the selected course and assign the course to the class member
	 * theSelectedCourse, the Course Level to CourseLevel CourseLeve=0 High,
	 * CourseLeve=1 Low
	 */
	public boolean SelectProduct() {
		ProductSelectDlg theDlg = new ProductSelectDlg();
		theSelectedProduct = theDlg.ShowDlg(thePerson.ProductList);
		thePerson.CurrentProduct = theSelectedProduct;
		nProductCategory = theDlg.nProductCategory;
		return theDlg.isLogout();
	}

	/*
	 * call the thePerson.CreateCourseMenu according to the really object(student or
	 * instructor) and the nCourseLevel it will call different menu creater and show
	 * the menu;
	 */

	public boolean ProductOperation() {
		thePerson.CreateProductMenu(theSelectedProduct, nProductCategory);
		return thePerson.ShowMenu();//// 0: logout 1 select an other course
	}

	/*
	 * find the course in theCourseList that matches strCourseName 1 create a
	 * CourseIterator for the List 2 Find the Course with the Iterator return the
	 * pointer of the Course if not fine, return null;
	 */
	private Product FindProductByProductName(String strProductName) {
		ProductIterator Iterator = new ProductIterator(theProductList);
		return (Product) Iterator.next(strProductName);
	}

}