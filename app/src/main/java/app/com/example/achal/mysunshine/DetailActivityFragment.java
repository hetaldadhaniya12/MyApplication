package app.com.example.achal.mysunshine;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {
    public static String message;
    private ShareActionProvider mShareActionProvider;

    public DetailActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview= inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();

        if (intent != null && intent.hasExtra("on click list item") ) {
            TextView textView = (TextView) rootview.findViewById(R.id.textView_detailActivity);
            message = intent.getStringExtra("on click list item");
            textView.setText(message);
        }


        return rootview;
    }



    @Override
    public void onCreateOptionsMenu(Menu menu,MenuInflater inflater) {

        inflater.inflate(R.menu.detailfragment, menu);
        MenuItem item = menu.findItem(R.id.action_share);

        // Fetch and store ShareActionProvider
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);

         super.onCreateOptionsMenu(menu,inflater);
    }


    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");

            shareIntent.putExtra(Intent.EXTRA_TEXT,DetailActivityFragment.message );
            mShareActionProvider.setShareIntent(shareIntent);
            //startActivity(shareIntent);
        }
    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
            {
                Intent intent = new Intent(getActivity(), SettingsActivity.class);
                startActivity(intent);
                return true;
            }
            case R.id.action_share:
            {
                shareweatherdata();
                return true;
            }

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    private void shareweatherdata() {
        Intent shareintent=new Intent(Intent.ACTION_SEND);
        setShareIntent(shareintent);
    }

}
