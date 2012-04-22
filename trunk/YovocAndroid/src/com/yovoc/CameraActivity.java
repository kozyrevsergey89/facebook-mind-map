package com.yovoc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class CameraActivity extends BasicActivity {

	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST = 100;
	private Uri uri;
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		uri = getFilesUri(MEDIA_TYPE_IMAGE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST);
	}

	private Uri getFilesUri(final int type){
			return Uri.fromFile(getOutputMediaFile(type));
	}
	
	private File getOutputMediaFile(final int type) {
		File mediaStorage = new File(Environment.getExternalStorageDirectory(), "YovocCam");
		
		if(!mediaStorage.exists()) {
			if(!mediaStorage.mkdirs()){
				Log.e("CAMERA:", "Cannot create directory");
				return null;
			}
		}
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		File mediaFile;
		
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorage.getPath() + File.separator 
														 + "IMG_" + timeStamp 
														 + ".jpg");
		} else if (type == MEDIA_TYPE_VIDEO) {
			mediaFile = new File(mediaStorage.getPath() + File.separator 
														 + "VID_" + timeStamp
														 + ".mp4"); 
		} else {
			return null;
		}
		
		return mediaFile;
	}
}
