package com.gojabz;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class GojabzAndroidActivity extends Activity {

	Facebook facebook = new Facebook("402822329748904");

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		facebook.authorize(this, new Facebook.DialogListener() {
			@Override
			public void onComplete(Bundle values) {
			}

			@Override
			public void onFacebookError(FacebookError error) {
			}

			@Override
			public void onError(DialogError e) {
			}

			@Override
			public void onCancel() {
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		facebook.authorizeCallback(requestCode, resultCode, data);
	}
}
