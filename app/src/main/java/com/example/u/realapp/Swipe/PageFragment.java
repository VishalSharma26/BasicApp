package com.example.u.realapp.Swipe;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.u.realapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    TextView textView;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.page_fragment,container,false);
        textView = (TextView)view.findViewById(R.id.textViewSwipe);
        Bundle bundle = getArguments();
        String message = Integer.toString(bundle.getInt("count"));
        textView.setText("This is Swipe View Pade "+message);

        return view;
    }

}
