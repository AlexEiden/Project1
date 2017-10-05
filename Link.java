package project1;

public class Link {
	public String songName;
	public Link node;
	
	public Link() {
		
	}
	public Link(String name) {
		songName = name;
		node = null;
	}
	public Link(String name, Link next) {
		songName = name;
		node = next;
	}
	
	public void setInfo(String name) {
		songName = name;
	}
	public String getInfo() {
		return songName;
	}
	public void setLink(Link node) {
		this.node = node;
	}
	public Link getLink() {
		return node;
	}
}
