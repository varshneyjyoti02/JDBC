package com.capi.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.HashMap;


import com.capi.beans.Product;
import com.capi.util.ConnectionUtil;

public class ProductRepoImpl implements ProductRepo {
	//HashMap<Integer,Product> hm=new HashMap<>();
	Connection con = ConnectionUtil.toConnect();
	
	@Override
	public Product insertSaleDetails(Product sale) {
		// TODO Auto-generated method stub
//		hm.put(sale.getSaleId(), sale);
//		return hm;
		//		 Product product=new Product();
//		 product.setCategory(sale.getCategory());
//		 product.setLineTotal(sale.getLineTotal());
//		 product.setPrice(sale.getPrice());
//		 product.setProdCode(sale.getProdCode());
//		 product.setProdName(sale.getProdName());
//		 product.setQuantity(sale.getQuantity());
//		 product.setSaleDate(sale.getSaleDate());
//		 product.setSaleId(sale.getSaleId());
		
		
		
		
		
		
		
		
	
		
		
		
		try {

			PreparedStatement stmt = con.prepareStatement("insert into Product values(?,?,?,?,?,?,?)");
			stmt.setString(1, sale.getProdName());
			stmt.setString(2, sale.getCategory());
			stmt.setInt(3, sale.getPrice());
			stmt.setInt(4, sale.getProdCode());
			stmt.setInt(5, sale.getSaleId());
		    stmt.setInt(6, sale.getQuantity());
		    stmt.setFloat(7, sale.getLineTotal());
			stmt.executeQuery();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		 
		
				return sale;
	}

}
