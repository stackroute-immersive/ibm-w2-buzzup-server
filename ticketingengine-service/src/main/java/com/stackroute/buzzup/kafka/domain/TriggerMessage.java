package com.stackroute.buzzup.kafka.domain;

public class TriggerMessage {

	private String TheatreName;
	private String DateToStop;
	private String SlotToStop;
	private String City;

	public TriggerMessage() {
	}

	public TriggerMessage(String theatreName, String dateToStop, String slotToStop, String city) {
		TheatreName = theatreName;
		DateToStop = dateToStop;
		SlotToStop = slotToStop;
		City = city;
	}
	
	public String getTheatreName() {
		return TheatreName;
	}

	public void setTheatreName(String theatreName) {
		TheatreName = theatreName;
	}

	public String getDateToStop() {
		return DateToStop;
	}

	public void setDateToStop(String dateToStop) {
		DateToStop = dateToStop;
	}

	public String getSlotToStop() {
		return SlotToStop;
	}

	public void setSlotToStop(String slotToStop) {
		SlotToStop = slotToStop;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "ShowSheduler [TheatreName=" + TheatreName + ", DateToStop=" + DateToStop + ", SlotToStop=" + SlotToStop
				+ ", City=" + City + "]";
	}

}
