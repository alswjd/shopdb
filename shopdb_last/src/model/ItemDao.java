package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import commons.DBUtil;
import vo.Item;

public class ItemDao {
	
	//list
	public List<Item> selectItemListAll(){
		//List<Item> list = new ArrayList<Item>();	//List는 인터페이스 , 다형성 이용(누가 부모)
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Item> list = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_item");
			rs = stmt.executeQuery();
			
			list = new ArrayList<Item>();
			while(rs.next()) {
				Item item = new Item();
				item.setItemId(rs.getInt("item_id"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("item_price"));
				item.setItemContents(rs.getString("item_contents"));
				item.setItemImg(rs.getString("item_img"));
				
				list.add(item);
			}
		} catch (Exception e) {
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
	
	//insert
	public void insertItem(Item item) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO shopdb_item(category_id, item_name, item_price, item_contents,item_img) VALUES(?,?,?,?,?)");
			stmt.setInt(1, item.getCategoryId());
			stmt.setString(2, item.getItemName());
			stmt.setInt(3, item.getItemPrice());
			stmt.setString(4, item.getItemContents());
			stmt.setString(5, item.getItemImg());
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(null, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//update form
	public Item selectItemOne(int itemId) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		Item item = new Item();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT item_id, category_id, item_name,item_price,item_contents ,item_img FROM shopdb_item WHERE item_id=?");
			stmt.setInt(1,itemId);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				item.setItemId(rs.getInt("item_id"));
				item.setCategoryId(rs.getInt("category_id"));
				item.setItemName(rs.getString("item_name"));
				item.setItemPrice(rs.getInt("item_price"));
				item.setItemContents(rs.getString("item_contents"));
				item.setItemImg(rs.getString("item_img"));
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
		
		return item;
	}
	
	//update action
		public void updateItem(Item item) {
			
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBUtil.getConnection();
				stmt = conn.prepareStatement("UPDATE shopdb_item SET category_id=?, item_name=?, item_price=?, item_contents=? WHERE item_id=?");
				stmt.setInt(1, item.getCategoryId());
				stmt.setString(2, item.getItemName());
				stmt.setInt(3, item.getItemPrice());
				stmt.setString(4, item.getItemContents());
				stmt.setInt(5, item.getItemId());
				
				rs = stmt.executeQuery();
				
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
	
}
