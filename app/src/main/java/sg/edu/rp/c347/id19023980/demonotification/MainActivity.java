package sg.edu.rp.c347.id19023980.demonotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
int requestCode = 123;
int notificationID = 888;
Button btnNotify1,btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNotify1 = findViewById(R.id.btnNotify1);
        btnNotify2 = findViewById(R.id.btnNotify2);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("default","default Channel",NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                    NotificationChannel channelHigh = new NotificationChannel("high","high Channel",NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("This is for high notification");
                    notificationManager.createNotificationChannel(channelHigh);
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,requestCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"high");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setVibrate(new long[0]);

                 builder.setDefaults(Notification.DEFAULT_VIBRATE);
                  builder.setPriority(NotificationCompat.PRIORITY_MAX);

                Notification n = builder.build();

                notificationManager.notify(notificationID,n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel channel = new NotificationChannel("default","default Channel",NotificationManager.IMPORTANCE_DEFAULT);
                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                    NotificationChannel channelHigh = new NotificationChannel("high","high Channel",NotificationManager.IMPORTANCE_HIGH);
                    channel.setDescription("This is for high notification");
                    notificationManager.createNotificationChannel(channelHigh);
                }
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this,requestCode,intent,PendingIntent.FLAG_CANCEL_CURRENT);


                NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
                bigTextStyle.setBigContentTitle("Big Text - Long Content");
                bigTextStyle.bigText("Birds flying high, you know how I feel"+"\nSun in the sky, you know how I fee"+"\nReeds driftin' on by, you know how I feel"+
                        "\nIt's a new dawn, it's a new day, it's a new life for me"+"\nYeah~"+"\nit's a new dawn, it's a new day, it's a new life for me"+
                        "\nooooooooh..."+"\nAnd I'm feeling good");
                bigTextStyle.setSummaryText("Reflection Journal?");




                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"high");
                builder.setContentTitle("Feeling Good Lyrics");
                builder.setContentText("Birds flying high,you know how i feel...");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pIntent);
                builder.setStyle(bigTextStyle);
                builder.setAutoCancel(true);
                Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setVibrate(new long[0]);

                builder.setDefaults(Notification.DEFAULT_VIBRATE);
                builder.setPriority(NotificationCompat.PRIORITY_MAX);

                Notification n = builder.build();

                notificationManager.notify(notificationID,n);
                finish();
            }
        });
    }
}