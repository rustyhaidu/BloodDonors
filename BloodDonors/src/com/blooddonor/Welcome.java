package com.blooddonor;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.starter.R;

public class Welcome extends Activity {
	
	// Declare Variable
	Button logout;
    Button enter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from singleitemview.xml
		setContentView(R.layout.welcome);
		
		// Retrieve current user from Parse.com
		ParseUser currentUser = ParseUser.getCurrentUser();
		
		// Convert currentUser into String
		String struser = currentUser.getUsername().toString();
		
		// Locate TextView in welcome.xml
		TextView txtuser = (TextView) findViewById(R.id.txtuser);

		// Set the currentUser String into TextView
		txtuser.setText("You are logged in as " + struser);
		
		// Locate Button in welcome.xml
		/*logout = (Button) findViewById(R.id.logout);

		// Logout Button Click Listener
		logout.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// Logout current user
				ParseUser.logOut();
				finish();
				Intent backIntent = new Intent(Welcome.this,LoginSignupActivity.class );
				Welcome.this.startActivity(backIntent);
			}
		}); */

		enter = (Button) findViewById(R.id.enter);
		enter.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// enter in MainActivityS
				Intent myIntent = new Intent(Welcome.this, MainActivityS.class);
		//		myIntent.putExtra("key", value); //Optional parameters
				Welcome.this.startActivity(myIntent);			}
		});

	}

}