package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Or;

import commons.DBUtil;
import vo.Orders;

public class OrdersDao {
	//myOrders Insert
	public void myOrdersList(Orders orders) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO shopdb_orders(item_id,orders_state, item_count,user_name, user_phone ,user_address, orders_date,orders_price) "
					+ "VALUES(?,1,?,?,?,?,now(),?)");
			stmt.setInt(1,orders.getItemId());
			stmt.setInt(2, orders.getItemCount());
			stmt.setString(3, orders.getUserName());
			stmt.setString(4,orders.getUserPhone());
			stmt.setString(5, orders.getUserAddress());
			stmt.setInt(6, orders.getOrdersPrice());
			
			rs = stmt.executeQuery();
			Orders o = new Orders();
			if(rs.next()) {
				o.setItemId(rs.getInt("item_id"));
				o.setOrdersState(rs.getString("orders_state"));
				o.setItemCount(rs.getInt("item_count"));
				o.setUserName(rs.getString("user_name"));
				o.setUserPhone(rs.getString("user_phone"));
				o.setUserAddress(rs.getString("user_address"));
				o.setOrdersDate(rs.getString("orders_date"));
				o.setOrdersPrice(rs.getInt("orders_price"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(rs, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//insert
	public void insertOrders(Orders orders) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO shopdb_orders(item_count, user_name, user_phone ,user_address) VALUES(?,?,?,?) WHERE orders_id=?");
			stmt.setInt(1,orders.getItemCount());
			stmt.setString(2, orders.getUserName());
			stmt.setString(3, orders.getUserPhone());
			stmt.setString(4, orders.getUserAddress());
			stmt.setInt(5,orders.getItemId());
			rs = stmt.executeQuery();
			Orders o = new Orders();
			if(rs.next()) {
				o.setOrdersId(rs.getInt("orders_id"));
				o.setItemId(rs.getInt("item_id"));
				o.setItemCount(rs.getInt("item_count"));
				o.setOrdersDate(rs.getString("orders_date"));
				o.setOrdersPrice(rs.getInt("orders_price"));
				o.setOrdersState(rs.getString("orders_state"));
				o.setUserName(rs.getString("user_name"));
				o.setUserPhone(rs.getString("user_phone"));
				o.setUserAddress(rs.getString("user_address"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(rs, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Orders> selectOrdersListAll(){
		//SELECT orders_id, item_id, item_count, orders_date, orders_price, orders_state, user_name, user_phone ,user_address FROM orders
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Orders> list = null;
		try{
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT orders_id, item_id, item_count, orders_date, orders_price, "
					+ "orders_state, user_name, user_phone ,user_address FROM shopdb_orders");
			rs = stmt.executeQuery();
			
			list = new ArrayList<Orders>();
			
			while(rs.next()) {
				Orders o = new Orders();
				o.setOrdersId(rs.getInt("orders_id"));
				o.setItemId(rs.getInt("item_id"));
				o.setItemCount(rs.getInt("item_count"));
				o.setOrdersDate(rs.getString("orders_date"));
				o.setOrdersPrice(rs.getInt("orders_price"));
				o.setOrdersState(rs.getString("orders_state"));
				o.setUserName(rs.getString("user_name"));
				o.setUserPhone(rs.getString("user_phone"));
				o.setUserAddress(rs.getString("user_address"));
				
				list.add(o);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(rs, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	//admin update - orders_state만 업데이트 가능
	public void updateOrdersState(int ordersId,String ordersState, int itemCount) {
		//UPDATE orders SET orders_state=? WHERE orders_id=?
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE shopdb_orders SET orders_state=?,item_count=? WHERE orders_id=?");
			stmt.setString(1, ordersState);
			stmt.setInt(2, itemCount);
			stmt.setInt(3, ordersId);
			stmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(null, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//guest update - select
	public Orders updateOrdersOne(int ordersId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Orders o=null;
		
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT orders_id, item_id, item_count, orders_date, orders_price," + 
									" orders_state, user_name, user_phone ,user_address FROM shopdb_orders WHERE orders_id=?");
			stmt.setInt(1, ordersId);
			rs =stmt.executeQuery();
			
			if(rs.next()) {
				o = new Orders();
				o.setOrdersId(rs.getInt("orders_id"));
				o.setItemId(rs.getInt("item_id"));
				o.setItemCount(rs.getInt("item_count"));
				o.setOrdersDate(rs.getString("orders_date"));
				o.setOrdersPrice(rs.getInt("orders_price"));
				o.setOrdersState(rs.getString("orders_state"));
				o.setUserName(rs.getString("user_name"));
				o.setUserPhone(rs.getString("user_phone"));
				o.setUserAddress(rs.getString("user_address"));
				
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(null, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return o;
	}
}
