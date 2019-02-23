package com.example.consultants.fragments;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.consultants.fragments.fragments.RedFragment;
import com.example.consultants.fragments.fragments.YellowFragment;

public class MainActivity extends AppCompatActivity implements YellowFragment.OnFragmentInteractionListener,
    RedFragment.OnFragmentInteractionListener {

    public static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private TextView tvMain;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        tvMain = findViewById(R.id.tvMain);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public void onAddingYellow(View view) {

        //YellowFragment yellowFragment = (YellowFragment) getSupportFragmentManager().findFragmentByTag(YellowFragment.TAG);

        //if(yellowFragment == null){
        fm.beginTransaction()
                .add(R.id.fragmentHolder1,
                        YellowFragment.newInstance("af", "Asdf"),
                        YellowFragment.TAG)
                .addToBackStack(YellowFragment.TAG)
                .commit();

        //}
    }

    //yellow interface
    @Override
    public void onFragmentInteraction(String data)
    {
        tvMain.setText(data);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, "From Yellow", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sendDataToRed(String textValue) {
        RedFragment redFragment = (RedFragment) fm.findFragmentById(R.id.fragmentHolder2);

        if (redFragment == null) addRedFragment(textValue);
        else redFragment.updateTextView(textValue);
    }

    public void onRemovingYellow(View view) {
        YellowFragment yellowFragment = (YellowFragment) fm.findFragmentByTag(YellowFragment.TAG);
        fm.beginTransaction().remove(yellowFragment).commit();

        //removes all fragments with yellow TAG
        fm.popBackStack(YellowFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    public void onAddingRed(View view) {
        addRedFragment("Default Text");
    }

    private void addRedFragment(String textValue) {
        fm.beginTransaction()
                .replace(R.id.fragmentHolder2,
                        RedFragment.newInstance(textValue), RedFragment.TAG)
                .addToBackStack(RedFragment.TAG)
                .commit();
    }

    public void onRemovingRed(View view) {
        RedFragment redFragment = (RedFragment) fm.findFragmentByTag(RedFragment.TAG);
        fm.beginTransaction().remove(redFragment).commit();

    }

    public void onRemovingFragment(View view) {
        //fm.popBackStackImmediate();

        //remove all fragments until and including the first yellow it finds, from the backstack
        //does it inside the call and returns boolean
        fm.popBackStackImmediate(YellowFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        //remove all fragments until and including the first yellow it finds, from the backstack
        //does this async, does not have a return type
        fm.popBackStack(YellowFragment.TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        //removes top fragment async, does not return anything
        fm.popBackStack();

        //removes top fragment from back stack, inside the call and return boolean
        fm.popBackStackImmediate();
    }

    //red interface
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
