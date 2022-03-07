package model;

public class Viewer {

	private String name;
	
	private String id;
	
	public Viewer(String name, String id, ViewerStatus status) {
		this.name = name;
		this.id = id;
		this.status = status;
	}
	
	private ViewerStatus status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ViewerStatus getStatus() {
		return status;
	}

	public void setStatus(ViewerStatus status) {
		this.status = status;
	}
}
