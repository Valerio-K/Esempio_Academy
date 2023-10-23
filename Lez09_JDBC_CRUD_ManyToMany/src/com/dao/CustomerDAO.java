package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.CustomerDTO;
import com.vo.CustomerVO;

public interface CustomerDAO {

	void addCustomer(String sql, Connection con, CustomerDTO customerDTO) throws ClassNotFoundException, SQLException;

	ArrayList<CustomerVO> findCustomersNameByProduct(String sql, Connection con, int productID)
			throws ClassNotFoundException, SQLException;

}
