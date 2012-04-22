package com.yovoc;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class SetterActivity extends BasicActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri uri = (Uri)getIntent().getExtras().get("path");
		Log.i("Yovoc", uri.getPath());
	}
	
}
