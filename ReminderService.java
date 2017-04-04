package com.benoitletondor.easybudgetapp.reminder;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import com.benoitletondor.easybudgetapp.R;
import com.benoitletondor.easybudgetapp.view.MainActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

public class ReminderService extends WakeReminderIntentService {

	public ReminderService() {
		super("ReminderService");
			}

	@Override
	void doReminderWork(Intent intent) {
		Log.d("ReminderService", "Doing work.");
		//Long rowId = intent.getExtras().getLong(RemindersDbAdapter.KEY_ROWID);
		String desc = intent.getExtras().getString("Desc");
		 
		/*NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
						
		Intent notificationIntent = new Intent(this, ReminderEditActivity.class); 
		notificationIntent.putExtra(RemindersDbAdapter.KEY_ROWID, rowId); 
		
		PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT); 
		
		Notification note=new Notification(android.R.drawable.stat_sys_warning, getString(R.string.notify_new_task_message), System.currentTimeMillis());
		note.setLatestEventInfo(this, getString(R.string.notify_new_task_title), getString(R.string.notify_new_task_message), pi);
		note.defaults |= Notification.DEFAULT_SOUND; 
		note.flags |= Notification.FLAG_AUTO_CANCEL; 
		
		// An issue could occur if user ever enters over 2,147,483,647 tasks. (Max int value). 
		// I highly doubt this will ever happen. But is good to note. 
		int id = (int)((long)rowId);
		mgr.notify(id, note); */

		NotificationManager mgr = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

		Intent notificationIntent = new Intent(this, MainActivity.class);
		//notificationIntent.putExtra(RemindersDbAdapter.KEY_ROWID, rowId);

		PendingIntent pi = PendingIntent.getActivity(this, 0, notificationIntent, PendingIntent.FLAG_ONE_SHOT);
		Notification.Builder builder = new Notification.Builder(ReminderService.this);
		builder.setSmallIcon(android.R.drawable.stat_sys_warning)
				.setContentTitle("Expense Alert")
				.setContentText("You need to pay for "+ desc)
		.setContentIntent(pi);


		/*Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
		builder.setSound(alarmSound);*/

		Uri alarmSound = Uri.parse("android.resource://"+ReminderService.this.getPackageName()+"/"+R.raw.alert_tone);//Here is FILE_NAME is the name of file that you want to play
		builder.setSound(alarmSound);

		Notification notification = builder.getNotification();
		mgr.notify(android.R.drawable.stat_sys_warning, notification);
	}
}
