package models;

public enum RoomType {
	SINGLE(1, "1 single bed", "no parking", null, null, "BeadAndBreakfast", 100.00, 10.00),
	SINGLEDELUXE(2, "1 double bed", "no parking", null, null, "BeadAndBreakfast", 140.00, 10.00),
	TWIN(2, "2 single beds", "no parking", null, null, "BeadAndBreakfast", 120.00, 10.00),
	DOUBLE(2, "1 double bed", "free parking", null, null, "BeadAndBreakfast", 180.00, 15.00),
	APARTMENT(4, "2 double beds", "free parking", "kitchen", null, "All inclusive", 220.00, 20.00),
	HONEYMOON(2, "1 king bed", "free parking", "SPA bath", "dining room", "Newly weds menu", 300.00, 30.00),
	PRESIDENTIAL(2, "1 king bed", "free parking", "SPA bath", "dining room", "Business menu", 300.00, 30.00);

	private int maxGuests;
	private String beds;
	private String amenity1;
	private String amenity2;
	private String amenity3;
	private String menu;
	private double pricePerNight;
	private double cancellationFee;

	RoomType(int maxGuests, String beds, String amenity1, String amenity2, String amenity3, String menu, double pricePerNight, double cancellationFee){
		this.maxGuests = maxGuests;
		this.beds = beds;
		this.amenity1 = amenity1;
		this.amenity2 = amenity2;
		this.amenity3 = amenity3;
		this.menu = menu;
		this.pricePerNight = pricePerNight;
		this.cancellationFee = cancellationFee;
	}

	public int getMaxGuests() {
		return maxGuests;
	}

	public String getBeds() {
		return beds;
	}

	public String getAmenity1() {
		return amenity1;
	}

	public String getAmenity2() {
		return amenity2;
	}

	public String getAmenity3() {
		return amenity3;
	}

	public String getMenu() {
		return menu;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public double getCancellationFee() {
		return cancellationFee;
	}
}



