package com.example.lhsrhs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LHSFragment extends Fragment {

    private LHSCustomView lhsCustomView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lhs , container , false);
        lhsCustomView = v.findViewById(R.id.lhscanvas);
        return v;
    }
    public void setreset(){
        lhsCustomView.reset();
    }
    public void seteraser(){
        lhsCustomView.eraser();
    }
    public void setchangecolor(){
        lhsCustomView.changecolor();
    }
}
