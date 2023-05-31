package lab.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lab.web.model.UserVO;

public class UserDAO {
	
	Connection con = null;
	PreparedStatement stat = null;
	
	public Connection connect() {
		try {
			Context ctx = new InitialContext();
			Context tomcatCtx = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)tomcatCtx.lookup("jdbc/oracle");
			con = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, Statement stat, ResultSet rs) {
		try {
			
			if(con != null)con.close();
			if(stat != null)stat.close();
			if(rs != null)rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int insertUser(UserVO vo) {
		int rows = 0;
		String sql = "insert into userinfo (userid, userpw, username, email, phone, address) values(?,?,?,?,?,?)";
		try {
			
			con = connect();
			stat = con.prepareStatement(sql);
			stat.setString(1, vo.getUserid());
			stat.setString(2, vo.getUserpwd());
			stat.setString(3, vo.getUsername());
			stat.setString(4, vo.getEmail());
			stat.setString(5, vo.getPhone());
			stat.setString(6, vo.getAddress());
			rows = stat.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, null);
		}
		return rows;
		
	}//insertUser() end
	
	
	public UserVO login(String uid, String pwd) {
		String sql ="select * from userinfo where userid=? and userpw=?";
		ResultSet rs = null;
		UserVO vo = null;
		try {
			con = connect();
			stat = con.prepareStatement(sql);
			stat.setString(1, uid);
			stat.setString(2, pwd);
			rs=stat.executeQuery();
			while(rs.next()) {
				vo = new UserVO();
				vo.setUserid(uid);
				vo.setUserpwd(pwd);
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, rs);
		}
		return vo;
	}
	
	
	public UserVO getUser(String uid) {
		String sql ="select * from userinfo where userid=?";
		ResultSet rs = null;
		UserVO vo = null;
		try {
			con = connect();
			stat = con.prepareStatement(sql);
			stat.setString(1, uid);
			rs=stat.executeQuery();
			while(rs.next()) {
				vo = new UserVO();
				vo.setUserid(uid);
				vo.setUserpwd(rs.getString("userpw"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, rs);
		}
		return vo;
	}
	
	
	public boolean updateUser(UserVO vo) {
		boolean bool = false;
		String sql = "update userinfo set username=?, email=?, phone=?, address=? where userid = ? ";
		try {
		con = connect();
		stat = con.prepareStatement(sql);
		stat.setString(1, vo.getUsername());
		stat.setString(2, vo.getEmail());
		stat.setString(3, vo.getPhone());
		stat.setString(4, vo.getAddress());
		stat.setString(5, vo.getUserid());
		if(stat.executeUpdate() > 0) {
			System.out.println("update 성공!!!");
			bool = true;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, null);
		}
		return bool;
	}
	
	
	public int removeUser(String uid) {
		String sql = "delete from userinfo where userid = ? ";
		int row=0;
		
		try {
		con = connect();
		stat = con.prepareStatement(sql);
		stat.setString(1, uid);
		row = stat.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return row;
	}
	
	
	public ArrayList<UserVO> getUserList() {
		String sql ="select * from userinfo";
		ResultSet rs = null;
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			con = connect();
			stat = con.prepareStatement(sql);
			rs=stat.executeQuery();
			while(rs.next()) {
				UserVO vo = new UserVO();
				vo.setUserid(rs.getString("userid"));
				vo.setUserpwd(rs.getString("userpw"));
				vo.setUsername(rs.getString("username"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAddress(rs.getString("address"));
				list.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, rs);
		}
		return list;
	}
	
}
