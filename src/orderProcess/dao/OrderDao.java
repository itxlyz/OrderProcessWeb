package orderProcess.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import orderProcess.bean.OrderBean;
import orderProcess.utils.StringUtil;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;



public class OrderDao {
	/**
	* ÈÕÖ¾¼ÇÂ¼.
	 */
	private static final Logger logger = Logger.getLogger(OrderDao.class.getName());
	
	/**
	 * jdbcTemplate.
	 */
	private JdbcTemplate jdbcTemplate;
	
	public OrderBean getByID(String id) {
		   StringBuilder sql = new StringBuilder();
			sql.append("select ID,STEP,START_TIME,END_TIME,START_TIME_STEPONE,END_TIME_STEPONE,START_TIME_STEPTWO,END_TIME_STEPTWO,START_TIME_STEPTHREE,START_TIME_STEPTHREE,START_TIME_STEPFORE,END_TIME_STEPFORE ");
			sql.append(" FROM ORDER where id = ?  WITH UR ");
			
			logger.info("ORDER SQL:"+sql.toString().replaceAll("(\t)+", " "));
			logger.info(String.format("ORDER params ID[%s],KEY_NAME[%s]",id));
			
			List<OrderBean> list=(List<OrderBean>)jdbcTemplate.query(sql.toString(), 
					new String[]{id}, new RowMapper(){
				public OrderBean mapRow(ResultSet rs, int paramInt)throws SQLException {
					return stuffEntity(rs,new OrderBean());
				}
			});
			
			return list == null || list.size() != 1 ? null : list.get(0);
		}
	public int update(OrderBean orderbean) {
		final  OrderBean bean = orderbean;
		StringBuilder sql = new StringBuilder();	
		sql.append("update ORDER set STEP = ?,START_TIME = ?,END_TIME = ?,START_TIME_STEPONE = ?,END_TIME_STEPONE = ?,START_TIME_STEPTWO = ?,END_TIME_STEPTWO = ?,START_TIME_STEPTHREE = ?,START_TIME_STEPTHREE = ?,START_TIME_STEPFORE = ?,END_TIME_STEPFORE =?");
		sql.append("where id = ?");
		sql.append("values(?,?,?,?,?,?,?,?,?,?,?,?)");
		
		if (logger.isInfoEnabled()) {
			logger.info(String.format("[%s]",sql));
		}
		int result =jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,bean.getStep());
				ps.setTimestamp(2,bean.getStartTime());
				ps.setTimestamp(3,bean.getEndTime());
				ps.setTimestamp(4,bean.getStartTimeStep1());
				ps.setTimestamp(5,bean.getEndTimeStep1());
				ps.setTimestamp(6,bean.getStartTimeStep2());
				ps.setTimestamp(7,bean.getEndTimeStep2());
				ps.setTimestamp(8,bean.getStartTimeStep3());
				ps.setTimestamp(9, bean.getEndTimeStep3());
				ps.setTimestamp(10, bean.getStartTimeStep4());
				ps.setTimestamp(11 ,bean.getEndTimeStep4());
				ps.setString( 12,bean.getId());
				
			}
		});
		return result;
	}

	public int insert(OrderBean orderbean) {
		final  OrderBean bean = orderbean;
			StringBuilder sql = new StringBuilder();	
			sql.append("insert into ORDER (ID,STEP,START_TIME,END_TIME,START_TIME_STEPONE,END_TIME_STEPONE,START_TIME_STEPTWO,END_TIME_STEPTWO,START_TIME_STEPTHREE,START_TIME_STEPTHREE,START_TIME_STEPFORE,END_TIME_STEPFORE");
			sql.append("values(?,?,?,?,?,?,?,?,?,?,?,?)");
			
			if (logger.isInfoEnabled()) {
				logger.info(String.format("[%s]",sql));
			}
			int result =jdbcTemplate.update(sql.toString(), new PreparedStatementSetter() {
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1,bean.getStep());
					ps.setTimestamp(2,bean.getStartTime());
					ps.setTimestamp(3,bean.getEndTime());
					ps.setTimestamp(4,bean.getStartTimeStep1());
					ps.setTimestamp(5,bean.getEndTimeStep1());
					ps.setTimestamp(6,bean.getStartTimeStep2());
					ps.setTimestamp(7,bean.getEndTimeStep2());
					ps.setTimestamp(8,bean.getStartTimeStep3());
					ps.setTimestamp(9, bean.getEndTimeStep3());
					ps.setTimestamp(10, bean.getStartTimeStep4());
					ps.setTimestamp(11 ,bean.getEndTimeStep4());
					ps.setString( 12,bean.getId());
					
				}
			});
			return result;
	 
	}
	private OrderBean stuffEntity(ResultSet rs,OrderBean orderBean) throws SQLException {
		if (rs != null && orderBean != null) {
			orderBean.setId(StringUtil.trim(rs.getString("ID")));
			orderBean.setStep(StringUtil.trim(rs.getString("STEP")));
			orderBean.setStartTime(rs.getTimestamp("START_TIME"));
			orderBean.setEndTime(rs.getTimestamp("END_TIME"));
			orderBean.setStartTimeStep1(rs.getTimestamp("START_TIME_STEPONE"));
			orderBean.setEndTimeStep1(rs.getTimestamp("END_TIME_STEPONE"));
			orderBean.setStartTimeStep2(rs.getTimestamp("START_TIME_STEPTWO"));
			orderBean.setEndTimeStep2(rs.getTimestamp("END_TIME_STEPTWO"));
			orderBean.setStartTimeStep3(rs.getTimestamp("START_TIME_STEPTHREE"));
			orderBean.setEndTimeStep3(rs.getTimestamp("END_TIME_STEPTHREE"));
			orderBean.setStartTimeStep4(rs.getTimestamp("START_TIME_STEPFORE"));
			orderBean.setEndTimeStep4(rs.getTimestamp("END_TIME_STEPFORE"));
		}
		return orderBean;
	}

	/**
	 * .
	 * @param jdbcTemplate
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


 

}
