package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import commons.DBUtil;
import vo.Member;

public class MemberDao {
	//login
	public Member login(Member member) {
		Member returnMember = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_member WHERE member_id=? AND member_pw=?");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnMember = new Member();
				returnMember.setMemberId(rs.getString("member_id"));
				returnMember.setMemberPw(rs.getString("member_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
			// insert/update/delete 일 경우 - DBUtil.close(null, stmt, conn);
		}
		
		return returnMember;
	}
	
	//insert
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("INSERT INTO shopdb_member(member_id,member_pw) VALUES(?,?)");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(null, stmt, conn);
		}
	}
	
	//listAll
	public List<Member> selectMemberAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Member> mem = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_member");
			rs = stmt.executeQuery();
			
			mem = new ArrayList<Member>();
			
			while(rs.next()) {
				Member m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPw(rs.getString("member_pw"));
				mem.add(m);
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
		
		return mem;
	}
	
	//update form
	public Member selectMemberOne(String memberId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member mem = null;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("SELECT * FROM shopdb_member WHERE member_id=?");
			stmt.setString(1, memberId);
			rs = stmt.executeQuery();
			if(rs.next()) {
				mem = new Member();
				mem.setMemberId(rs.getString("member_id"));
				mem.setMemberPw(rs.getString("member_pw"));
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, stmt, conn);
		}
		
		return mem;
	}
	
	//update action
	public void updateMember(Member mem) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("UPDATE shopdb_member SET member_id=?, member_pw=? WHERE member_id=?");
			stmt.setString(1, mem.getMemberId());
			stmt.setString(2, mem.getMemberPw());
			stmt.setString(3, mem.getMemberId());
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
