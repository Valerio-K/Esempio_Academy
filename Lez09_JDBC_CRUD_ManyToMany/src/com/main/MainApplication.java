package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dao.*;
import com.dto.*;
import com.sql.SqlScript;
import com.vo.CustomerVO;
import com.bean.CustomerProduct;

public class MainApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		CustomerProductDAO customerProductDAO = new CustomerProductDAOImpl();
		
		/* Vogliamo inserire due record a customer e due record a product 
		 * collegate insieme con 4 inserimenti nella tabella join customer_product. */
		CustomerDAO customerDAO = new CustomerDAOImpl();
		CustomerDTO customerDTO1 = new CustomerDTO("Cappa","France");
		CustomerDTO customerDTO2 = new CustomerDTO("Pasco","Spain");
		customerDAO.addCustomer(SqlScript.sqlCustomerInsert, con, customerDTO1);
		int customerMaxID = customerProductDAO.findMaxID(SqlScript.sqlCustomerMaxID, con);
		customerDAO.addCustomer(SqlScript.sqlCustomerInsert, con, customerDTO2);
		
		ProductDAO productDAO = new ProductDAOImpl();
		ProductDTO productDTO1 = new ProductDTO("Tablet","China");
		ProductDTO productDTO2 = new ProductDTO("Smartphone","Japan");
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO1);
		int productMaxID = customerProductDAO.findMaxID(SqlScript.sqlProductMaxID, con);
		productDAO.addProduct(SqlScript.sqlProductInsert, con, productDTO2);
		
		CustomerProduct customerProduct1 = new CustomerProduct(customerMaxID,productMaxID);
		CustomerProduct customerProduct2 = new CustomerProduct(customerMaxID,productMaxID+1);
		CustomerProduct customerProduct3 = new CustomerProduct(customerMaxID+1,productMaxID);
		CustomerProduct customerProduct4 = new CustomerProduct(customerMaxID+1,productMaxID+1);
		customerProductDAO.addCustomerProduct(SqlScript.sqlCustomerProductInsert, con, customerProduct1);
		customerProductDAO.addCustomerProduct(SqlScript.sqlCustomerProductInsert, con, customerProduct2);
		customerProductDAO.addCustomerProduct(SqlScript.sqlCustomerProductInsert, con, customerProduct3);
		customerProductDAO.addCustomerProduct(SqlScript.sqlCustomerProductInsert, con, customerProduct4);
		
		ArrayList<CustomerVO> customers = customerDAO.findCustomersNameByProduct
				(SqlScript.sqlCustomersNameByProduct, con, productMaxID);
		customers.forEach(name -> System.out.println(name.getName()));	
	}
}