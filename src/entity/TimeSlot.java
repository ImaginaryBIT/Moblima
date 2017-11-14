/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author nyinyithwin
 */
public class TimeSlot implements Serializable  {
        public static final String AVAILABLE = "available";
        public static final String UNAVAILABLE = "unavailable";
        private Date dateTime;
        private String status;

        public TimeSlot(Date dateTime, String status) {
            this.dateTime = dateTime;
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
        public String getTime() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm");
		return dateFormatter.format(dateTime.getTime());
	}

        public String getDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormatter.format(dateTime.getTime());
        }

        public Date getDateTime() {
                return dateTime;
        }
        

}
