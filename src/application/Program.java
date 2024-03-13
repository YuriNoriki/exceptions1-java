package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserrvation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		
		System.out.print("Check-out date (dd/MM/yyyy)");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) { 
			// FAZ COM QUE O CHECKout TEM QUE SER DEPOIS(DIAS) DE CHECKin
			// AFTER É UM METODO DE DATA
			System.out.println("ERROR IN RESERVATION: CHEC-OUT DATE MUST BE AFTER CHECK-IN DATE");
		}
		else {
			Reserrvation reservation = new Reserrvation(number, checkIn, checkOut);
			System.out.println("Reservation " + reservation);
			System.out.println();
			
			System.out.println("Enter update data:");
			System.out.print("Check-in date (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			
			System.out.print("Check-out date (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reservation.updateDate(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
			System.out.println("Reservation " + reservation);
			}
		}
		sc.close();
	}
}



