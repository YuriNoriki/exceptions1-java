package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainExcception;

public class Reserrvation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserrvation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)){
			throw new DomainExcception("CHECk-OUT DATE MUST BE AFTER CHECK-IN DATE");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //MILISEGUNDOS 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // CONVERTENDO MILISEGUNDOS PARA DIAS 
	}
	
	public void updateDate(Date checkIn, Date checkOut){
		
		Date now = new Date();
		if(checkIn.before(now) ||  checkOut.before(now)) {
			throw new DomainExcception( "Reservation dates for update must be future.");
		}
		if(!checkOut.after(checkIn)){
			throw new DomainExcception("CHECk-OUT DATE MUST BE AFTER CHECK-IN DATE");
		}
		
		this.checkIn = checkIn; //CHECKIN DO OBJETO RECEBER CHECKIN DO ARGUMENTO
		this.checkOut = checkOut; //CHECKout DO OBJETO RECEBER CHECKout DO ARGUMENTO
		
	}
	
	@Override
	public String toString() {
		return "Room "
				+roomNumber
				+", checkin: "
				+ sdf.format(checkIn)
				+ ", checkout: "
				+ sdf.format(checkOut)
				+", "
				+ duration()
				+" nights";
	}

}
