package com.roostera.test.metrodftest;

public class Link implements Cloneable{
	private Node from;
	private Node to;
	private int linkID;
	private String train;
	
	public Link(int ID, Node from, Node to,String train ){
	
		linkID=ID;		
		//train=name;
		this.from=from;
		this.to=to;
		this.train=train;
		//timeTable=timeList;
	}
	public Node getFrom() {
		return from;
	}
	public void setFrom(Node from) {
		this.from = from;
	}
	public Node getTo() {
		return to;
	}
	public void setTo(Node to) {
		this.to = to;
	}
	public int getLinkID() {
		return linkID;
	}
	public void setLinkID(int linkID) {
		this.linkID = linkID;
	}
	public String getTrain() {
		return train;
	}
	public void setTrain(String train) {
		this.train = train;
	}
	public Link clone() throws CloneNotSupportedException{
		Link cloned=(Link)super.clone();
		cloned.from=from;
		cloned.linkID=linkID;
		cloned.train=train;
		cloned.to=to;
		return cloned;
	}

}
