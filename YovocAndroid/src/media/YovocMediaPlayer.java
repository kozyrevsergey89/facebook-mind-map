package media;

import java.io.IOException;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class YovocMediaPlayer  {
	MediaPlayer mp;

	
	public YovocMediaPlayer(){
		mp = new MediaPlayer();
		
		
	}	
	
	public void yovocMPStart() {
		try {
	        mp.start();
				} catch (IllegalArgumentException e) {
			        e.printStackTrace();
			    } catch (IllegalStateException e) {
			        e.printStackTrace();
			    } 
	}
	
	public void yovocMPSetURL(final String pathToMedia){
		try {
			mp.reset();
			
			mp.setDataSource(pathToMedia);
			mp.prepare();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void yovocMPStop(){
		mp.stop();
		mp.release();
		
	}
	
	
		

}
