package com.example.consultants.fragments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedFragment extends Fragment {
    public static final String TAG = RedFragment.class.getSimpleName() + "_TAG";

    public static final String ARG_TEXT_VALUE = "param1";

    private String textValue;

    private OnFragmentInteractionListener mListener;
    private TextView tvFragRed;

    public RedFragment() {
        // Required empty public constructor
    }

    public static RedFragment newInstance(String textValue) {
        RedFragment fragment = new RedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT_VALUE, textValue);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            textValue = getArguments().getString(ARG_TEXT_VALUE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_red, container, false);

        tvFragRed = view.findViewById(R.id.tvFragmentRed);
        return view;
    }

    public void updateTextView(String textValue){
        tvFragRed.setText(textValue);
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
