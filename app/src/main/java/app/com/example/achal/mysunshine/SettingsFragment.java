package app.com.example.achal.mysunshine;


import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_general);
        Preference preference=findPreference(getString(R.string.pref_cityId_key));
        preference.setOnPreferenceChangeListener(this);
      // bindPreferenceSummaryToValue(findPreference(getString(R.string.pref_cityId_key)));
        Preference preference1=findPreference(getString(R.string.pref_units_key));
        preference1.setOnPreferenceChangeListener(this);
    }

   /* private void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(this);

        // Trigger the listener immediately with the preference's
        // current value.
        onPreferenceChange(preference, PreferenceManager
                .getDefaultSharedPreferences(preference.getContext())
                .getString(preference.getKey(), ""));
    }*/


    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if(preference instanceof EditTextPreference)
        {String strval=newValue.toString();
        preference.setSummary(strval);}
        else if(preference instanceof ListPreference)
        {   String strval1=newValue.toString();
            preference.setSummary(strval1);}
        return true;
    }
}
