package lab.web.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import lab.web.model.SnackVO;

public class SnackDAO {
	
	public Connection connect() {
		Connection con = null;
		try {
			
			Context ctx = new InitialContext();
			Context tomcatCtx = (Context)ctx.lookup("java:/comp/env");
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
	
	public List<SnackVO> getSnackList(){
		Connection con = null;
		Statement stat = null;
		String sql = "select * from snack";
		ResultSet rs = null;
		List<SnackVO> snacks = null;
		
		try {
			con = connect();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			snacks = new ArrayList<SnackVO>();
			while(rs.next()) {
				SnackVO vo = new SnackVO();
				vo.setPid(rs.getString("pid"));
				vo.setPname(rs.getString("pname"));
				vo.setPrice(rs.getInt("price"));
				vo.setPimg(rs.getString("pimg"));
				snacks.add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con, stat, rs);
		}
		return snacks;
	}
	
	
	
}
