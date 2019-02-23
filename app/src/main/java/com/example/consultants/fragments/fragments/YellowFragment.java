package com.example.consultants.fragments.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link YellowFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link YellowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YellowFragment extends Fragment implements View.OnClickListener {
    public static final String TAG = YellowFragment.class.getSimpleName() + "_TAG";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String FIRST_NAME_PARAM = "param1";
    private static final String LAST_NAME_PARAM = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private TextView tvFirstName;
    private TextView tvLastName;
    private Button btnSendData;
    private Button btnSendToRed;
    private EditText etToRed;

    public YellowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param firstName Parameter 1.
     * @param lastName Parameter 2.
     * @return A new instance of fragment YellowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YellowFragment newInstance(String firstName, String lastName) {
        YellowFragment fragment = new YellowFragment();
        Bundle args = new Bundle();
        args.putString(FIRST_NAME_PARAM, firstName);
        args.putString(LAST_NAME_PARAM, lastName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //avoid fragment from getting destroyed
        setRetainInstance(true);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(FIRST_NAME_PARAM);
            mParam2 = getArguments().getString(LAST_NAME_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_yellow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFirstName = view.findViewById(R.id.tvFirstName);
        tvLastName = view.findViewById(R.id.tvLastName);
        btnSendData = view.findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(this);
        //button to send to red
        btnSendToRed = view.findViewById(R.id.btnSendToRed);
        btnSendToRed.setOnClickListener(this);
        etToRed = view.findViewById(R.id.etTextValue);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String data) {
        if (mListener != null) {
            mListener.onFragmentInteraction(data);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvFirstName.setText(mParam1);
        tvLastName.setText(mParam2);
    }

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

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btnSendData:
                //set the textview in the main
                onButtonPressed("Some Data");

                //show toast
                mListener.showToast("From Yellow");
                break;
            case R.id.btnSendToRed:

                mListener.sendDataToRed(etToRed.getText().toString());

        }

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
        void onFragmentInteraction(String data);
        void showToast(String message);
        void sendDataToRed(String textValue);
    }
}
