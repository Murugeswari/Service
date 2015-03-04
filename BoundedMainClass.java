package com.example.boundedservice;


import java.util.Random;

import com.example.boundedservice.localservice.localBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
//import android.support.v4.widget.SearchViewCompatIcs.MySearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {

Button start,stop,rButton;
localservice mservice;
boolean mbound =false;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
start=(Button) findViewById(R.id.start);
stop=(Button) findViewById(R.id.stop);
rButton=(Button) findViewById(R.id.random);
rButton.setOnClickListener(new OnClickListener() {

@Override
public void onClick(View v) {
// TODO Auto-generated method stub
if(mbound)
{
int num=mservice.number();
Toast.makeText(MainActivity.this, "Number: " + num,Toast.LENGTH_SHORT).show();
}

}
});
start.setOnClickListener(this);
stop.setOnClickListener(this);
}

@Override
protected void onStart() {
// TODO Auto-generated method stub
super.onStart();
Intent i=new Intent(MainActivity.this,localservice.class);
bindService(i, mConnection,BIND_AUTO_CREATE);

}

@Override
protected void onStop() {
// TODO Auto-generated method stub
super.onStop();
if (mbound) {
unbindService(mConnection);
mbound=false;

}
}

private ServiceConnection mConnection=new ServiceConnection() {

@Override
public void onServiceDisconnected(ComponentName name) {
// TODO Auto-generated method stub
mbound=false;
}

@Override
public void onServiceConnected(ComponentName name, IBinder service) {
// TODO Auto-generated method stub
localBinder binder=(localBinder) service;
mservice=binder.getservice();
mbound=true;
}
};
@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
// Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
int id = item.getItemId();
if (id == R.id.action_settings) {
return true;
}
return super.onOptionsItemSelected(item);
}


@Override
public void onClick(View v) {
// TODO Auto-generated method stub
//		//Intent i = new Intent(getApplicationContext(), );
//		if (v==start) {
//			startService(i);
//
//		} else {
//			stopService(i);
//
//		}

}
}

