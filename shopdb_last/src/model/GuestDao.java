package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import vo.Guest;
import vo.Member;

public class GuestDao {
	//login
	public Guest login(Guest guest) {
		Guest returnGuest = null;
		Connection conn = null;
		PreparedStatement stmt = null;
ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_guest WHERE guest_id=? AND guest_pw=?");
			stmt.setString(1, guest.getGuestId());
			stmt.setString(2, guest.getGuestPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnGuest = new Guest();
				returnGuest.setGuestId(rs.getString("guest_id"));
				returnGuest.setGuestPw(rs.getString("guest_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
			// insert/update/delete 일 경우 - DBUtil.close(null, stmt, conn);
		}
		
		return returnGuest;
	}
	

	//회원가입
	public void insertGuest(Guest guest) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO shopdb_guest(guest_id,guest_pw) VALUES(?,?)");
			stmt.setString(1, guest.getGuestId());
			stmt.setString(2, guest.getGuestPw());
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, conn);
		}
	}
	
	//listAll
	public List<Guest> selectGuestAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Guest> guest = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_guest");
			rs = stmt.executeQuery();
			
			guest = new ArrayList<Guest>();
			
			while(rs.next()) {
				Guest g = new Guest();
				g.setGuestId(rs.getString("guest_id"));
				g.setGuestPw(rs.getString("guest_pw"));
				guest.add(g);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(rs, stmt, conn);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		return guest;
	}
	
	//update form
	public Guest selectGuestOne(String guestId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Guest guest = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_guest WHERE guest_id=?");
			stmt.setString(1,guestId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				guest = new Guest();
				guest.setGuestId(rs.getString("guest_id"));
				guest.setGuestPw(rs.getString("guest_pw"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		
		return guest;
	}
	
	//update action
	public void updateGuest(Guest guest) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE shopdb_guest SET guest_id=?, guest_pw=? WHERE guest_id=?");
			stmt.setString(1, guest.getGuestId());
			stmt.setString(2, guest.getGuestPw());
			stmt.setString(3, guest.getGuestId());
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				DBUtil.close(null, stmt, conn);
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
}
