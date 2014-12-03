package jack.fyndrforgithub;

import package1.function;
import package1.var;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


//Omegar test

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
      //START OF ABHI's CODE
        Firebase.setAndroidContext(this);
        /*possible problems with this: 
         Has firebase been loaded although libs file contains firebase.jar in Eclipse?
         */
       /* Firebase ref = new Firebase("https://fiery-fire-1683.firebaseio.com/"); //this initializes the unique Firebase url, where data can be viewed
        Map<String,String> map1 = new HashMap <String, String> (); //creates a Map
    	
		String itemLost = "ab"; //This string serves as the key 
		String location = "cd"; //This string serves as the value 
		//int [] Location = new int [2];
		//Location[0] = 1;
		//Location[1] = 2;
		//puts the keys and strings into Map. This will need to be played with, to receive any entered string.
		//Ideally we will need UserName/Password thus introducing the User Class  
		map1.put(itemLost, location); 
		System.out.println("Output");
		//this creates a Firebase reference called "map1"	
		Firebase map1Ref = ref.child("map1"); 
		//When we call map1Ref, using the setValue function, we create a Child on the unique Firebase URL.
		//the argument to setValue calls the informatio in map1 to be passed onto our URL.  
		map1Ref.setValue(map1);
		//END OF ABHI's CODE!
        
        */
        setContentView(R.layout.activity_main);
        
        button = (Button) findViewById(R.id.button);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {

					Intent smsIntent = new Intent(Intent.ACTION_VIEW);
					smsIntent.putExtra("sms_body", "HelloWorld");
					smsIntent.setType("vnd.android-dir/mms-sms");
					startActivity(smsIntent);

				} catch (Exception e) {
					Toast.makeText(getApplicationContext(), "SMS failed!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}
			}
		});
	}
}
        
    }

    //Start of Jack's Code    
    public static string returnLocation()  {
    
    var map;
    function initialize() {
      var myLatLng = new google.maps.LatLng(-25.363882,131.044922);
      
      //sets up the default map with a zoom of 4, center of myLatLng (the middle of Old Campus) 
      var mapOptions = {
        zoom: 4,
        center: myLatLng
        mapTypeId: google.maps.MapTypeId.ROADMAP
      }
      
      //creates a container (a <div> element) for the map with a given height and width
      <div id="googleMap" style="width:500px;height:380px;"></div>
      
      //creates the map inside the <div> element, to the parameters set up by mapOptions
       map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);          
     
    	}
    	//Executes the initialize() function
       google.maps.event.addDomListener(window, 'load', initialize);    
       
       google.maps.event.addListener(map, 'click', function(event) { 	
    	   new Point location = Point (event.latLng);   
    	   string location2 = new string location.toString();       	
    	   return location2;
       }	   
       });
       
       //End of Jack's Code

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
    
    
    //Omegar Test Code
    
    public class SimpleGeofence {
            // Instance variables
            private final String mId;
            private final double mLatitude;
            private final double mLongitude;
            private final float mRadius;
            private long mExpirationDuration;
            private int mTransitionType;

        /*
         * @param geofenceId The Geofence's request ID
         * @param latitude Latitude of the Geofence's center.
         * @param longitude Longitude of the Geofence's center.
         * @param radius Radius of the geofence circle.
         * @param expiration Geofence expiration duration
         * @param transition Type of Geofence transition.
         */
        public SimpleGeofence(
                String geofenceId,
                double latitude,
                double longitude,
                float radius,
                long expiration,
                int transition) {
            // Set the instance fields from the constructor
            this.mId = geofenceId;
            this.mLatitude = latitude;
            this.mLongitude = longitude;
            this.mRadius = radius;
            this.mExpirationDuration = expiration;
            this.mTransitionType = transition;
        }
        // Instance field getters
        public String getId() {
            return mId;
        }
        public double getLatitude() {
            return mLatitude;
        }
        public double getLongitude() {
            return mLongitude;
        }
        public float getRadius() {
            return mRadius;
        }
        public long getExpirationDuration() {
            return mExpirationDuration;
        }
        public int getTransitionType() {
            return mTransitionType;
        }
        /*
         * Creates a Location Services Geofence object from a
         * SimpleGeofence.
         *
         * @return A Geofence object
         */
        public Geofence toGeofence() {
            // Build a new Geofence object
            return new Geofence.Builder()
                    .setRequestId(getId())
                    .setTransitionTypes(mTransitionType)
                    .setCircularRegion(
                            getLatitude(), getLongitude(), getRadius())
                    .setExpirationDuration(mExpirationDuration)
                    .build();
        }
    }
    ...
    /*
     * Storage for geofence values, implemented in SharedPreferences.
     */
    public class SimpleGeofenceStore {
        // Keys for flattened geofences stored in SharedPreferences
        public static final String KEY_LATITUDE =
                "com.example.android.geofence.KEY_LATITUDE";
        public static final String KEY_LONGITUDE =
                "com.example.android.geofence.KEY_LONGITUDE";
        public static final String KEY_RADIUS =
                "com.example.android.geofence.KEY_RADIUS";
        public static final String KEY_EXPIRATION_DURATION =
                "com.example.android.geofence.KEY_EXPIRATION_DURATION";
        public static final String KEY_TRANSITION_TYPE =
                "com.example.android.geofence.KEY_TRANSITION_TYPE";
        // The prefix for flattened geofence keys
        public static final String KEY_PREFIX =
                "com.example.android.geofence.KEY";
        /*
         * Invalid values, used to test geofence storage when
         * retrieving geofences
         */
        public static final long INVALID_LONG_VALUE = -999l;
        public static final float INVALID_FLOAT_VALUE = -999.0f;
        public static final int INVALID_INT_VALUE = -999;
        // The SharedPreferences object in which geofences are stored
        private final SharedPreferences mPrefs;
        // The name of the SharedPreferences
        private static final String SHARED_PREFERENCES =
                "SharedPreferences";
        // Create the SharedPreferences storage with private access only
        public SimpleGeofenceStore(Context context) {
            mPrefs =
                    context.getSharedPreferences(
                            SHARED_PREFERENCES,
                            Context.MODE_PRIVATE);
        }
        /*
         * Returns a stored geofence by its id, or returns null
         * if it's not found.
         *
         * @param id The ID of a stored geofence
         * @return A geofence defined by its center and radius. See
         */
        public SimpleGeofence getGeofence(String id) {
            /*
             * Get the latitude for the geofence identified by id, or
             * INVALID_FLOAT_VALUE if it doesn't exist
             */
            double lat = mPrefs.getFloat(
                    getGeofenceFieldKey(id, KEY_LATITUDE),
                    INVALID_FLOAT_VALUE);
            /*
             * Get the longitude for the geofence identified by id, or
             * INVALID_FLOAT_VALUE if it doesn't exist
             */
            double lng = mPrefs.getFloat(
                    getGeofenceFieldKey(id, KEY_LONGITUDE),
                    INVALID_FLOAT_VALUE);
            /*
             * Get the radius for the geofence identified by id, or
             * INVALID_FLOAT_VALUE if it doesn't exist
             */
            float radius = mPrefs.getFloat(
                    getGeofenceFieldKey(id, KEY_RADIUS),
                    INVALID_FLOAT_VALUE);
            /*
             * Get the expiration duration for the geofence identified
             * by id, or INVALID_LONG_VALUE if it doesn't exist
             */
            long expirationDuration = mPrefs.getLong(
                    getGeofenceFieldKey(id, KEY_EXPIRATION_DURATION),
                    INVALID_LONG_VALUE);
            /*
             * Get the transition type for the geofence identified by
             * id, or INVALID_INT_VALUE if it doesn't exist
             */
            int transitionType = mPrefs.getInt(
                    getGeofenceFieldKey(id, KEY_TRANSITION_TYPE),
                    INVALID_INT_VALUE);
            // If none of the values is incorrect, return the object
            if (
                lat != GeofenceUtils.INVALID_FLOAT_VALUE &&
                lng != GeofenceUtils.INVALID_FLOAT_VALUE &&
                radius != GeofenceUtils.INVALID_FLOAT_VALUE &&
                expirationDuration !=
                        GeofenceUtils.INVALID_LONG_VALUE &&
                transitionType != GeofenceUtils.INVALID_INT_VALUE) {

                // Return a true Geofence object
                return new SimpleGeofence(
                        id, lat, lng, radius, expirationDuration,
                        transitionType);
            // Otherwise, return null.
            } else {
                return null;
            }
        }
        /*
         * Save a geofence.
         * @param geofence The SimpleGeofence containing the
         * values you want to save in SharedPreferences
         */
        public void setGeofence(String id, SimpleGeofence geofence) {
            /*
             * Get a SharedPreferences editor instance. Among other
             * things, SharedPreferences ensures that updates are atomic
             * and non-concurrent
             */
            Editor editor = mPrefs.edit();
            // Write the Geofence values to SharedPreferences
            editor.putFloat(
                    getGeofenceFieldKey(id, KEY_LATITUDE),
                    (float) geofence.getLatitude());
            editor.putFloat(
                    getGeofenceFieldKey(id, KEY_LONGITUDE),
                    (float) geofence.getLongitude());
            editor.putFloat(
                    getGeofenceFieldKey(id, KEY_RADIUS),
                    geofence.getRadius());
            editor.putLong(
                    getGeofenceFieldKey(id, KEY_EXPIRATION_DURATION),
                    geofence.getExpirationDuration());
            editor.putInt(
                    getGeofenceFieldKey(id, KEY_TRANSITION_TYPE),
                    geofence.getTransitionType());
            // Commit the changes
            editor.commit();
        }
        public void clearGeofence(String id) {
            /*
             * Remove a flattened geofence object from storage by
             * removing all of its keys
             */
            Editor editor = mPrefs.edit();
            editor.remove(getGeofenceFieldKey(id, KEY_LATITUDE));
            editor.remove(getGeofenceFieldKey(id, KEY_LONGITUDE));
            editor.remove(getGeofenceFieldKey(id, KEY_RADIUS));
            editor.remove(getGeofenceFieldKey(id,
                    KEY_EXPIRATION_DURATION));
            editor.remove(getGeofenceFieldKey(id, KEY_TRANSITION_TYPE));
            editor.commit();
        }
        /*
         * Given a Geofence object's ID and the name of a field
         * (for example, KEY_LATITUDE), return the key name of the
         * object's values in SharedPreferences.
         *
         * @param id The ID of a Geofence object
         * @param fieldName The field represented by the key
         * @return The full key name of a value in SharedPreferences
         */
        private String getGeofenceFieldKey(String id,
                String fieldName) {
            return KEY_PREFIX + "_" + id + "_" + fieldName;
        }
    }


 	/*
     * Use to set an expiration time for a geofence. After this amount
     * of time Location Services will stop tracking the geofence.
     */
    private static final long SECONDS_PER_HOUR = 60;
    private static final long MILLISECONDS_PER_SECOND = 1000;
    private static final long GEOFENCE_EXPIRATION_IN_HOURS = 12;
    private static final long GEOFENCE_EXPIRATION_TIME =
            GEOFENCE_EXPIRATION_IN_HOURS *
            SECONDS_PER_HOUR *
            MILLISECONDS_PER_SECOND;
    ...
    /*
     * Handles to UI views containing geofence data
     */
    // Handle to geofence 1 latitude in the UI
    private EditText mLatitude1;
    // Handle to geofence 1 longitude in the UI
    private EditText mLongitude1;
    // Handle to geofence 1 radius in the UI
    private EditText mRadius1;
    // Handle to geofence 2 latitude in the UI
    private EditText mLatitude2;
    // Handle to geofence 2 longitude in the UI
    private EditText mLongitude2;
    // Handle to geofence 2 radius in the UI
    private EditText mRadius2;
    /*
     * Internal geofence objects for geofence 1 and 2
     */
    private SimpleGeofence mUIGeofence1;
    private SimpleGeofence mUIGeofence2;
    ...
    // Internal List of Geofence objects
    List<Geofence> mGeofenceList;
    // Persistent storage for geofences
    private SimpleGeofenceStore mGeofenceStorage;
    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...
        // Instantiate a new geofence storage area
        mGeofenceStorage = new SimpleGeofenceStore(this);

        // Instantiate the current List of geofences
        mCurrentGeofences = new ArrayList<Geofence>();
    }
    ...
    /*
     * Get the geofence parameters for each geofence from the UI
     * and add them to a List.
     */
    public void createGeofences() {
        /*
         * Create an internal object to store the data. Set its
         * ID to "1". This is a "flattened" object that contains
         * a set of strings
         */
        mUIGeofence1 = new SimpleGeofence(
                "1",
                Double.valueOf(mLatitude1.getText().toString()),
                Double.valueOf(mLongitude1.getText().toString()),
                Float.valueOf(mRadius1.getText().toString()),
                GEOFENCE_EXPIRATION_TIME,
                // This geofence records only entry transitions
                Geofence.GEOFENCE_TRANSITION_ENTER);
        // Store this flat version
        mGeofenceStorage.setGeofence("1", mUIGeofence1);
        // Create another internal object. Set its ID to "2"
        mUIGeofence2 = new SimpleGeofence(
                "2",
                Double.valueOf(mLatitude2.getText().toString()),
                Double.valueOf(mLongitude2.getText().toString()),
                Float.valueOf(mRadius2.getText().toString()),
                GEOFENCE_EXPIRATION_TIME,
                // This geofence records both entry and exit transitions
                Geofence.GEOFENCE_TRANSITION_ENTER |
                Geofence.GEOFENCE_TRANSITION_EXIT);
        // Store this flat version
        mGeofenceStorage.setGeofence(2, mUIGeofence2);
        mGeofenceList.add(mUIGeofence1.toGeofence());
        mGeofenceList.add(mUIGeofence2.toGeofence());
    }

	/*
     * Create a PendingIntent that triggers an IntentService in your
     * app when a geofence transition occurs.
     */
    private PendingIntent getTransitionPendingIntent() {
        // Create an explicit Intent
        Intent intent = new Intent(this,
                ReceiveTransitionsIntentService.class);
        /*
         * Return the PendingIntent
         */
        return PendingIntent.getService(
                this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

// Holds the location client
    private LocationClient mLocationClient;
    // Stores the PendingIntent used to request geofence monitoring
    private PendingIntent mGeofenceRequestIntent;
    // Defines the allowable request types.
    public enum REQUEST_TYPE = {ADD}
    private REQUEST_TYPE mRequestType;
    // Flag that indicates if a request is underway.
    private boolean mInProgress;
    ...
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ...
        // Start with the request flag set to false
        mInProgress = false;
        ...
    }
    ...
    /**
     * Start a request for geofence monitoring by calling
     * LocationClient.connect().
     */
    public void addGeofences() {
        // Start a request to add geofences
        mRequestType = ADD;
        /*
         * Test for Google Play services after setting the request type.
         * If Google Play services isn't present, the proper request
         * can be restarted.
         */
        if (!servicesConnected()) {
            return;
        }
        /*
         * Create a new location client object. Since the current
         * activity class implements ConnectionCallbacks and
         * OnConnectionFailedListener, pass the current activity object
         * as the listener for both parameters
         */
        mLocationClient = new LocationClient(this, this, this)
        // If a request is not already underway
        if (!mInProgress) {
            // Indicate that a request is underway
            mInProgress = true;
            // Request a connection from the client to Location Services
            mLocationClient.connect();
        } else {
            /*
             * A request is already underway. You can handle
             * this situation by disconnecting the client,
             * re-setting the flag, and then re-trying the
             * request.
             */
        }
    }

	/*
     * Provide the implementation of ConnectionCallbacks.onConnected()
     * Once the connection is available, send a request to add the
     * Geofences
     */
    @Override
    private void onConnected(Bundle dataBundle) {
        ...
        switch (mRequestType) {
            case ADD :
                // Get the PendingIntent for the request
                mTransitionPendingIntent =
                        getTransitionPendingIntent();
                // Send a request to add the current geofences
                mLocationClient.addGeofences(
                        mCurrentGeofences, pendingIntent, this);
            ...
        }
    }

 	/*
     * Provide the implementation of
     * OnAddGeofencesResultListener.onAddGeofencesResult.
     * Handle the result of adding the geofences
     *
     */
    @Override
    public void onAddGeofencesResult(
            int statusCode, String[] geofenceRequestIds) {
        // If adding the geofences was successful
        if (LocationStatusCodes.SUCCESS == statusCode) {
            /*
             * Handle successful addition of geofences here.
             * You can send out a broadcast intent or update the UI.
             * geofences into the Intent's extended data.
             */
        } else {
        // If adding the geofences failed
            /*
             * Report errors here.
             * You can log the error using Log.e() or update
             * the UI.
             */
        }
        // Turn off the in progress flag and disconnect the client
        mInProgress = false;
        mLocationClient.disconnect();
    }

  	/*
     * Implement ConnectionCallbacks.onDisconnected()
     * Called by Location Services once the location client is
     * disconnected.
     */
    @Override
    public void onDisconnected() {
        // Turn off the request flag
        mInProgress = false;
        // Destroy the current location client
        mLocationClient = null;
    }

 // Implementation of OnConnectionFailedListener.onConnectionFailed
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Turn off the request flag
        mInProgress = false;
        /*
         * If the error has a resolution, start a Google Play services
         * activity to resolve it.
         */
        if (connectionResult.hasResolution()) {
            try {
                connectionResult.startResolutionForResult(
                        this,
                        CONNECTION_FAILURE_RESOLUTION_REQUEST);
            } catch (SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        // If no resolution is available, display an error dialog
        } else {
            // Get the error code
            int errorCode = connectionResult.getErrorCode();
            // Get the error dialog from Google Play services
            Dialog errorDialog = GooglePlayServicesUtil.getErrorDialog(
                    errorCode,
                    this,
                    CONNECTION_FAILURE_RESOLUTION_REQUEST);
            // If Google Play services can provide an error dialog
            if (errorDialog != null) {
                // Create a new DialogFragment for the error dialog
                ErrorDialogFragment errorFragment =
                        new ErrorDialogFragment();
                // Set the dialog in the DialogFragment
                errorFragment.setDialog(errorDialog);
                // Show the error dialog in the DialogFragment
                errorFragment.show(
                        getSupportFragmentManager(),
                        "Geofence Detection");
            }
        }
    }

	/*
     * Sets an identifier for the service
     */
    public ReceiveTransitionsIntentService() {
        super("ReceiveTransitionsIntentService");
    }
    /*
     * Handles incoming intents
     *@param intent The Intent sent by Location Services. This
     * Intent is provided
     * to Location Services (inside a PendingIntent) when you call
     * addGeofences()
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        // First check for errors
        if (LocationClient.hasError(intent)) {
            // Get the error code with a static method
            int errorCode = LocationClient.getErrorCode(intent);
            // Log the error
            Log.e("ReceiveTransitionsIntentService",
                    "Location Services error: " +
                    Integer.toString(errorCode));
            /*
             * You can also send the error code to an Activity or
             * Fragment with a broadcast Intent
             */
        /*
         * If there's no error, get the transition type and the IDs
         * of the geofence or geofences that triggered the transition
         */
        } else {
            // Get the type of transition (entry or exit)
            int transitionType =
                    LocationClient.getGeofenceTransition(intent);
            // Test that a valid transition was reported
            if (
                (transitionType == Geofence.GEOFENCE_TRANSITION_ENTER)
                 ||
                (transitionType == Geofence.GEOFENCE_TRANSITION_EXIT)
               ) {
                List <Geofence> triggerList =
                        getTriggeringGeofences(intent);

                String[] triggerIds = new String[geofenceList.size()];

                for (int i = 0; i < triggerIds.length; i++) {
                    // Store the Id of each geofence
                    triggerIds[i] = triggerList.get(i).getRequestId();
                }
                /*
                 * At this point, you can store the IDs for further use
                 * display them, or display the details associated with
                 * them.
                 */
            }
        // An invalid transition was reported
        } else {
            Log.e("ReceiveTransitionsIntentService",
                    "Geofence transition error: " +
                    Integer.toString()transitionType));
        }
	//lostLocation = getLostLocation();
	//currentLocation = getLocation();
	//if (withinDistance(currentLocation, lostLocation))
	//{
	//	System.out.println("There is a lost item here!");
    //}

	//Add geofence removal functionality?
	

    //End Omegar Test Code
      
}
}
