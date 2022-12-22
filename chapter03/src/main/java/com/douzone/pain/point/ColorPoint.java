package com.douzone.pain.point;

public class ColorPoint extends Point {
	private String color;

	public ColorPoint(int x, int y, String color ) {
		super(x ,y);
//		setX(x);
//		setX(y);
	
		this.color=color;
	}
	public String getColor() {
		
		return color;
	}

	@Override  //override를 알려줘 검사
	public void show() {
		//super.show();  부모기능을 두고 구현한다면 부분 구현 부모 없애면 재구현
		System.out.println("점(x="+ getX() + ",y=" + getY() + ","+color+")을 그렸습니다." );
	}

	public void setColor(String color) {
		this.color = color;
	}
	
}
