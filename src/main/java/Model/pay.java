package Model;

import java.sql.Date;

public class pay {
	
	
	private int id;
	    private Date startDate;
	    private Date endDate;
	    private int detailHomeId;
	    private int userId;
	   
	    
	    public pay() {
			super();
		}


		public pay(int id, Date startDate, Date endDate, int detailHomeId, int userId) {
			super();
			this.id = id;
			this.startDate = startDate;
			this.endDate = endDate;
			this.detailHomeId = detailHomeId;
			this.userId = userId;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public Date getStartDate() {
			return startDate;
		}


		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}


		public Date getEndDate() {
			return endDate;
		}


		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}


		public int getDetailHomeId() {
			return detailHomeId;
		}


		public void setDetailHomeId(int detailHomeId) {
			this.detailHomeId = detailHomeId;
		}


		public int getUserId() {
			return userId;
		}


		public void setUserId(int userId) {
			this.userId = userId;
		}
		
		
	    
}
