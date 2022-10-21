package edu.asu.ptbs;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassProductList extends ArrayList<Product> {

	public ClassProductList() {
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

	//// initialize the list by reading from the file.
	void InitializeFromFile(String productListFile) {
		Scanner scanner;
		try {
			String productInfo = null;
			File file = getFileFromResource(productListFile);
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				productInfo = scanner.nextLine();
				String strProductCategory = GetProductCategory(productInfo);
				String strProductName = GetProductName(productInfo);
				Product theProduct;
				Integer lvl = 0;
				switch(strProductCategory){
					case "Meat":
						lvl=0;
						break;
					case "Produce":
						lvl=1;
						break;
					default:
						break;

				}

				theProduct = new Product(strProductName, lvl);
				add(theProduct);
			}
			scanner.close();
		} catch (Exception ee) {

		}
	}

	private String GetProductCategory(String aline) {
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


	Product FindProductByProductName(String productName) {
		int nProductCount = size();
		for (int i = 0; i < nProductCount; i++) {
			Product theProduct;
			theProduct = (Product) get(i);
			if (theProduct.ProductName == productName)
				return theProduct;
		}
		return null;
	}

}