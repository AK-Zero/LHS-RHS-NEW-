package com.example.lhsrhs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RHSFragment extends Fragment {

    private RHSCustomView rhsCustomView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rhs , container , false);
        rhsCustomView = v.findViewById(R.id.rhscanvas);
        return v;
    }
    public void setreset(){
        rhsCustomView.reset();
    }
    public void seteraser(){
        rhsCustomView.eraser();
    }
    public void setchangecolor(){
        rhsCustomView.changecolor();
    }
}
