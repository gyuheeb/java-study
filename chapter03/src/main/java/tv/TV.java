package tv;

public class TV {
	private int volume;  //0~100
	private int channel; // 1~255 
	private boolean power;

public TV(int channel, int volume, boolean power) {
	this.channel = channel;
	this.volume = volume;
	this.power = power;
}
	
	public void power(boolean on) {
		power = on;
		
	}
	public void channel(int channel) {
		if(channel>=256) {
			channel=1;
		}
		else if(channel<1) {
			channel=255;
		}
	}
	public void channel(boolean up) {
		if(up) {
			channel++;
			}
		else {
			channel--;
				
			}
			
			
		}
	public void volume(boolean up) {
		if(up) {
			volume++;
			}
		else {
			volume--;
				
			}
		
	}
	public void volume(int volume) {
		if(volume>=100) {
			volume=0;
		}
		else if(volume<1) {
			volume=100;
		}
		
	}
	
	public void status() {
		System.out.println("TV[power="+(power?"on":"off")+","+ 
				"channel ="+ channel +","+ "volume="+ volume +"]");
	}
}
