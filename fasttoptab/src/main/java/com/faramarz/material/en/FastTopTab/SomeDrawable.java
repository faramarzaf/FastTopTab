package com.faramarz.material.en.FastTopTab;

import android.graphics.drawable.GradientDrawable;

public class SomeDrawable extends GradientDrawable {


    public SomeDrawable(  int pStrokeWidth, int pStrokeColor, float cornerRadius) {

        setStroke(pStrokeWidth,pStrokeColor);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }
}


/*
public class SomeDrawable extends GradientDrawable {

    public SomeDrawable(int pStartColor, int pCenterColor, int pEndColor, int pStrokeWidth, int pStrokeColor, float cornerRadius) {
        super(Orientation.BOTTOM_TOP,new int[]{pStartColor,pCenterColor,pEndColor});
        setStroke(pStrokeWidth,pStrokeColor);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }
}*/
