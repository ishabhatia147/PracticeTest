import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.logging.Logger;

public class ParkingLot

{
	private static ArrayList<Slot> totalSlots;
	private int noOfSlots;
	private HashMap<Slot, Car> occupiedSlots = new LinkedHashMap<Slot, Car>();
	private ArrayList<Slot> freeSlots=new ArrayList<Slot>();
	

	Logger log = Logger.getLogger("ParkingLot");

	public ArrayList<Slot> createParkingLot(int n) {
		totalSlots = new ArrayList<Slot>(n);
		noOfSlots = n;
		for (int i = 0; i < n; i++) {
			Slot slot1 = new Slot();
			slot1.setSlotNo(i + 1);
			totalSlots.add(slot1);
			freeSlots.add(slot1);
			
		}
		log.info("Created a parking lot with "+n+" slots");
		return totalSlots;
	}

	public void parkACar(String regNo, String color) throws Exception {
		Car car = new Car();
		car.setColor(color);
		car.setRegistrationNumber(regNo);
		if (freeSlots.size() > 0) {
			occupiedSlots.put(freeSlots.get(0), car);
			log.info("Allocated slot number :" + freeSlots.get(0).getSlotNo());
			freeSlots.remove(freeSlots.get(0));
		} else {
			throw new Exception("Sorry, parking lot is full");
		}

	}
	
	public void vacateASlot(int n) throws Exception
	{
		if(occupiedSlots.containsKey(totalSlots.get(n-1)))
		{
			synchronized (totalSlots.get(n-1)) {
				
			
			occupiedSlots.remove(totalSlots.get(n-1));
				freeSlots.add(totalSlots.get(n-1));
			}	
				log.info("Slot "+(n)+" is freed");}
		else
		{
			throw new Exception("Cannot vacate already empty slot");
		}
	}
	
	public void getOccupiedSlotsStatus()
	{
		log.info("SlotNo\t"+"Registration\t"+"Color");
			
		for (Entry<Slot, Car> entry : occupiedSlots.entrySet()) {
		   log.info(entry.getKey().getSlotNo()+"\t"+entry.getValue().getRegistrationNumber()+"\t"+entry.getValue().getColor());
   
		}
	}
	
	public void getFreeStatus()
	{
		log.info("Slots");
		for(int i=0;i<freeSlots.size();i++)
		{
			log.info(""+freeSlots.get(i).getSlotNo());
		}
	}

	
}
