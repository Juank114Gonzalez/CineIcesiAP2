package model;
/**
 * This class is a room that contains an amount of chairs depending on the type of room
 *
 */
public class Room {
	private RoomType type;
	private StatusChair[][] chairs;
	
	/**
	 * This is the constructor method of the class Room
	 * @param type, type of the room, it can be MINI or NORMAL
	 */
	public Room (String type) {
		if(type.toUpperCase().equals("MINISALA")) {
			this.type = RoomType.MINI;
			this.chairs = new StatusChair[4][6];
		}else if(type.toUpperCase().equals("SALA MEDIA")) {
			this.type = RoomType.NORMAL;
			this.chairs = new StatusChair[7][6];
		}
	}

	/**
	 * Gets the type of the room 
	 * @return type, RoomType, type of the room
	 */
	public RoomType getType() {
		return type;
	}

	/**
	 * Sets the type of the room 
	 * @param type, RoomType, type of the room
	 */
	public void setType(RoomType type) {
		this.type = type;
	}

	/**
	 * Gets the matrix of chair status
	 * @return chairs, matrix of chair status that represents every single chair 
	 */
	public StatusChair[][] getChairs() {
		return chairs;
	}

	/**
	 * Sets the matrix of chair status
	 * @param chairs, matrix of chair status that represents every single chair 
	 */
	public void setChairs(StatusChair[][] chairs) {
		this.chairs = chairs;
	}
	
	
}
