package jack.fyndrforgithub;

import package1.function;
import package1.var;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        setContentView(R.layout.activity_main);
    }

    //Start of Jack's Code
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
       		system.out.print(event.latLng);
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
    // Global constants
    /*
     * Define a request code to send to Google Play services
     * This code is returned in Activity.onActivityResult
     */
/*    private final static int
            CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    ...
    // Define a DialogFragment that displays the error dialog
    public static class ErrorDialogFragment extends DialogFragment {
        // Global field to contain the error dialog
        private Dialog mDialog;
        ...
        // Default constructor. Sets the dialog field to null
        public ErrorDialogFragment() {
            super();
            mDialog = null;
        }
        ...
        // Set the dialog to display
        public void setDialog(Dialog dialog) {
            mDialog = dialog;
        }
        ...
        // Return a Dialog to the DialogFragment.
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return mDialog;
        }
        ...
    }
    ...
    /*
     * Handle results returned to the FragmentActivity
     * by Google Play services
     */
   
        /*
        
        @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) { 
    	 
    	 
        // Decide what to do based on the original request code
        switch (requestCode) {
            ...
            case CONNECTION_FAILURE_RESOLUTION_REQUEST :
            /*
             * If the result code is Activity.RESULT_OK, try
             * to connect again
             */
    /*            switch (resultCode) {
                    ...
                    case Activity.RESULT_OK :
                    /*
                     * Try the request again
                     */
              /*      ...
                    break;
                }
            ...
        }
        ...
    }
    ...  
    private boolean servicesConnected() {
        // Check that Google Play services is available
        int resultCode =
                GooglePlayServicesUtil.
                        isGooglePlayServicesAvailable(this);
        // If Google Play services is available
        if (ConnectionResult.SUCCESS == resultCode) {
            // In debug mode, log the status
            Log.d("Geofence Detection",
                    "Google Play services is available.");
            // Continue
            return true;
        // Google Play services was not available for some reason
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
    
    
    ...
    //End Omegar Test Code
    */
      
}
}
