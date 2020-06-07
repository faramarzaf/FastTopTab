package com.faramarz.material.en.fasttoptab;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

public class SomeDrawable extends GradientDrawable {


    public SomeDrawable(  int pStrokeWidth, int pStrokeColor, float cornerRadius) {

        setStroke(pStrokeWidth,pStrokeColor);
        setShape(GradientDrawable.RECTANGLE);
        setCornerRadius(cornerRadius);
    }
}