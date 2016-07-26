package com.support.android.implicitintent;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMap(View v)
    {
        // Build the intent
        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        // Verify it resolves
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size() > 0;
        
        //Start an activity if it's safe
        if (isIntentSafe) {
            startActivity(mapIntent);
        }


    }

    public void showMapChooser(View v) {

        Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");

        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setData(location);


        // Always use string resources for UI text.
        // This says something like "Share this photo with"
        String title = getResources().getString(R.string.choose);
        // Create intent to show chooser
        Intent chooser = Intent.createChooser(mapIntent, title);
        // Verify the intent will resolve to at least one activity
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            System.out.println("Reached inside");
            startActivity(chooser);
        }
        else
            System.out.println("Reached outside");

    }

    /**  to open Phone dialer
    /* Uri number = Uri.parse("tel:5551234");
    /* Intent callIntent = new Intent(Intent.ACTION_DIAL, number);*/


    /** To open Map Apps
     * Map point based on address
     *  Uri location = Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California");
     *   // Or map point based on latitude/longitude
     * Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
     * Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);*/

    /** To open Web Browsers
     * Uri webpage = Uri.parse("http://www.android.com");
     Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
     */


     /** To open Email Apps
     Intent emailIntent = new Intent(Intent.ACTION_SEND);
     // The intent does not have a URI, so declare the "text/plain" MIME type
     emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
     emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"jon@example.com"}); // recipients
     emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
     emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
     emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
     // You can also attach multiple items by passing an ArrayList of Uris
     */

    /** To open Calendar Apps
     Intent calendarIntent = new Intent(Intent.ACTION_INSERT, Events.CONTENT_URI);
     Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
     Calendar endTime = Calendar.getInstance().set(2012, 0, 19, 10, 30);
     calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
     calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
     calendarIntent.putExtra(Events.TITLE, "Ninja class");
     calendarIntent.putExtra(Events.EVENT_LOCATION, "Secret dojo");
      */





}
