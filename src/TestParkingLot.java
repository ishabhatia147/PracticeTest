import java.util.Scanner;

public class TestParkingLot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ParkingLot parkingLot = new ParkingLot();
		parkingLot.createParkingLot(n);
		try {
			while (sc.hasNext()) {
				String[] op = sc.nextLine().split(" ");
				if (op[0].equals("park")) {
					parkingLot.parkACar(op[1], op[2]);
				}
				
				else if (op[0].equals("leave")) {
					parkingLot.vacateASlot(Integer.parseInt(op[1]));
				} 
				
				else if (op[0].equals("status")) {
					if(op[1].equals("allocated"))
					{
						parkingLot.getOccupiedSlotsStatus();
					}
					else
					{
						parkingLot.getFreeStatus();
					}
				}
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
