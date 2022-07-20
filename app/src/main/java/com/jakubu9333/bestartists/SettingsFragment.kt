package com.jakubu9333.bestartists

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        val shared :SharedPreferences.Editor = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()


        shared.apply()
    }
}