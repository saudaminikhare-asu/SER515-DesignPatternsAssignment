package edu.asu.ptbs;

//import sun.security.util.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Facade {
	// The type of the user: Buyer: 0, Seller 1
	private int userType;
	// The object that holds the currently selected product
	private Product theSelectedProduct;
	// The selected product category: 0: Meat, 1: Produce.
	private int nProductCategory;

	private ClassProductList theProductList;
	// The current user.
	private Person thePerson;
	// Show login GUI and return the login result.

	// Login
	Login loginHandler;

	@FXML
	private Text actiontarget;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;

	@FXML
	private Button submitButton;

	public void login(Stage stage) throws IOException {
		// Load the db map
		loginHandler = new Login();

		//Read files and create hashmap of users
		FXMLLoader fxmlLoader = new FXMLLoader(PTBSApplication.class.getResource("login.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 320, 240);
		stage.setTitle("PTBS LOGIN");
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	protected void handleLogin(ActionEvent event) throws IOException {
		// Validation
		// Check login
		// Is login successful
		// Set the userType
		// Set the person
		// go to the next scene from here
		Map <String, String> buyerMap = new HashMap<String, String>();
		File buyerObj = new File("./src/main/resources/edu/asu/ptbs/BuyerInfo.txt");
		Scanner buyerReader = new Scanner(buyerObj);
		while (buyerReader.hasNextLine()) {
			String data = buyerReader.nextLine();
			String[] buyerparts = data.split(":");
			//System.out.println(data);
			buyerMap.put(buyerparts[0],buyerparts[1]);
		}
		buyerReader.close();

		Map <String, String> sellerMap = new HashMap<String, String>();
		File sellerObj = new File("./src/main/resources/edu/asu/ptbs/SellerInfo.txt");
		Scanner sellerReader = new Scanner(sellerObj);
		while (sellerReader.hasNextLine()) {
			String data = sellerReader.nextLine();
			String[] sellerparts = data.split(":");
			//System.out.println(data);
			sellerMap.put(sellerparts[0],sellerparts[1]);
		}
		sellerReader.close();

		String usernameImput = userNameField.getText();
		String passwordInput = String.valueOf(passwordField.getText());
		int loginSuccesful = 0;

		for (Map.Entry<String, String> me :
				buyerMap.entrySet()) {

			// Printing keys
			if ( usernameImput.equals(me.getKey()))
			{
				System.out.println("Buyer exists");
				if(passwordInput.equals(me.getValue()))
				{
					System.out.println("Buyer Successfully logged in");
					userType = 0;
					loginSuccesful = 1;
				}
				else
				{
					System.out.println("Invalid Password! Try Again");
				}
			}
		}

		for (Map.Entry<String, String> me :
				sellerMap.entrySet()) {

			// Printing keys
			if ( usernameImput.equals(me.getKey()))
			{
				System.out.println("Seller exists");
				if(passwordInput.equals(me.getValue()))
				{
					System.out.println("Seller Successfully logged in");
					userType = 1;
					loginSuccesful = 1;
				}
				else
				{
					System.out.println("Invalid Password! Try Again");
				}
			}
		}

		FXMLLoader fxmlLoader = new FXMLLoader(PTBSApplication.class.getResource("login.fxml"));
		Scene mainScene = new Scene(fxmlLoader.load(), 320, 240);
		Stage mainStage =(Stage) ((Node)event.getSource()).getScene().getWindow();
		if (loginSuccesful ==1)
		{
			String title = "MENU";
			if (userType == 0)
			{
				title = "BUYER " + title;
			}
			else
			{
				title = "SELLER " + title;
				fxmlLoader = new FXMLLoader(PTBSApplication.class.getResource("seller.fxml"));
				mainScene = new Scene(fxmlLoader.load(), 500, 500);
				mainStage =(Stage) ((Node)event.getSource()).getScene().getWindow();
			}
			mainStage.setTitle(title);
			mainStage.setScene(mainScene);
		}
	}

	/*When clicking the add button of the ProductMenu, call this function.
	This function will add a new trade and fill in the required information.
	This function will be called SellerTradingMenu or BuyerTradingMenu based on the type of the user.
	It will not update the product menu. The product menu needs to be refreshed outside the function.
	 */
	public void addTrading() {

	}

	/*
	When clicking the view button of the ProductMenu, call this function and pass the pointer of the Trading and the person pointer to this function.
	This function will view the trading information.
	This function will call SellerTradingMenu or BuyerTradingMenu according to the type of the user.
	 */
	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	/*
	Show the remind box to remind buyer of the upcoming overdue trading window.
	 */
	public void remind() {

	}

	/*
	Create a user object according to the userinfoitem, the object can be a buyer or a seller.
	 */
	public void createUser(UserInfoItem userinfoitem) {

	}

	/*
	Create the product list of the entire system.
	*/
	public void createProductList() {

	}

	public void attachProductToUser() {

	}

	/*
	Show the Product list in a Dialog and return the selected product.
	 */
	public int selectProduct() {
		return 0;
	}

	public void productOperation() {

	}

}
