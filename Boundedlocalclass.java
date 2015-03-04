package com.example.boundedservice;

import java.util.Random;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class localservice extends Service {

public IBinder mBinder=new localBinder();

private final Random mGenerator=new Random();

@Override
public IBinder onBind(Intent intent) {
// TODO Auto-generated method stub
return mBinder;
}

public class localBinder extends Binder{

public  localservice localservicegetservice() {
return localservice.this;
}

public localservice getservice() {
// TODO Auto-generated method stub
return null;
}

}

public int number()
{
return mGenerator.nextInt(342);

}
}

