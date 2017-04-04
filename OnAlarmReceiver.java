package com.benoitletondor.easybudgetapp.reminder;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ComponentInfo;
import android.util.Log;

public class OnAlarmReceiver extends BroadcastReceiver {

	private static final String TAG = ComponentInfo.class.getCanonicalName();
	
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d(TAG, "Received wake up from alarm manager.");
		
		//long rowid = intent.getExtras().getLong(RemindersDbAdapter.KEY_ROWID);
		String desc = intent.getExtras().getString("Desc");
		
		WakeReminderIntentService.acquireStaticLock(context);
		
		Intent i = new Intent(context, ReminderService.class);
		i.putExtra("Desc", desc);
		context.startService(i);
		 
	}
}
