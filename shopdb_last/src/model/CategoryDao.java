package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import commons.DBUtil;
import vo.*;
public class CategoryDao {
	//update action
	public void updateCategory(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/alswjdd", "alswjdd", "java1004");
			stmt = conn.prepareStatement("UPDATE shopdb_category set category_name=? WHERE category_id=?");
			stmt.setString(1, category.getCategoryName());
			stmt.setInt(2, category.getCategoryId());
			stmt.executeUpdate();
				
		} catch(Exception e) {
			System.out.println("CategoryDao.updateCategory() 예외");
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
	public Category selectCategoryOne(int categoryId) {
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			
			Category category = null;
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mariadb://localhost/alswjdd", "alswjdd", "java1004");
				stmt = conn.prepareStatement("select category_id, category_name from shopdb_category where category_id=?");
				stmt.setInt(1, categoryId);
				rs = stmt.executeQuery();
				
				category = new Category();
				if(rs.next()) {
					category.setCategoryId(rs.getInt("category_id"));
					category.setCategoryName(rs.getString("category_name"));
					}
			} catch(Exception e) {
				System.out.println("CategoryDao.selectCategory() 예외");
				e.printStackTrace();
			}finally {
				try {
					DBUtil.close(rs, stmt, conn);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return category;
	}
	
	
	//insert
	public void insertCategory(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			//try이 안에서 예외가 발생할 수 있다
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/alswjdd", "alswjdd", "java1004");
			stmt = conn.prepareStatement("INSERT INTO shopdb_category(category_name) VALUES(?)");
			stmt.setString(1, category.getCategoryName());
			stmt.executeUpdate();
			
		}catch (Exception e) {
			//예외 객체를 받아와서 무언가를 함
			e.printStackTrace(); //콘솔창에 예외 메세지를 그대로 출력해줘라
		}finally {
			try{
					//자동으로 가비지 컬렉터가 실행해줌
				DBUtil.close(null, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ArrayList<Category> selectCategoryListAll() {
		
		ArrayList<Category> list = null; //list의 값을 불러오기 위해 블럭 밖으로 꺼내서 값 초기화 시켜줌
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/alswjdd", "alswjdd", "java1004");
			PreparedStatement stmt = conn.prepareStatement("select category_id, category_name from shopdb_category");
			ResultSet rs = stmt.executeQuery();
			
			list = new ArrayList<Category>();
			while(rs.next()) {
				Category category = new Category();
				category.setCategoryId(rs.getInt("category_id"));
				category.setCategoryName(rs.getString("category_name"));
				list.add(category);
				}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
