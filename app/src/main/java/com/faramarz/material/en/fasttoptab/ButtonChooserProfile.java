package com.faramarz.material.en.fasttoptab;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;

public class ButtonChooserProfile extends RelativeLayout implements RadioCheckable {
    // Views
    private TextView mValueTextView;

    // Constants
    public static final int DEFAULT_TEXT_COLOR = Color.TRANSPARENT;

    // Attribute Variables
    private String mValue;
    private int mValueTextColor;
    private int mPressedTextColor;
    private int strokeWidth;
    private int strokeColor;
    private int selectedTabColor;
    private GradientDrawable gd = new GradientDrawable();

    // Variables
    private Drawable mInitialBackgroundDrawable;
    private OnClickListener mOnClickListener;
    private OnTouchListener mOnTouchListener;
    private boolean mChecked;
    private ArrayList<OnCheckedChangeListener> mOnCheckedChangeListeners = new ArrayList<>();

    //================================================================================
    // Constructors
    //================================================================================

    public ButtonChooserProfile(Context context) {
        super(context);
        setupView();
    }

    public ButtonChooserProfile(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttributes(attrs);
        setupView();
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public ButtonChooserProfile(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        parseAttributes(attrs);
        setupView();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ButtonChooserProfile(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        parseAttributes(attrs);
        setupView();
    }

    //================================================================================
    // Init & inflate methods
    //================================================================================

    private void parseAttributes(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ButtonChooserProfile, 0, 0);
        Resources resources = getContext().getResources();
        try {
            mValue = a.getString(R.styleable.ButtonChooserProfile_ftt_ButtonValueText);
            mValueTextColor = a.getColor(R.styleable.ButtonChooserProfile_ftt_ButtonValueTextColor, resources.getColor(R.color.black));
            mPressedTextColor = a.getColor(R.styleable.ButtonChooserProfile_ftt_ButtonPressedTextColor, Color.WHITE);
            strokeWidth = a.getInteger(R.styleable.ButtonChooserProfile_ftt_StrokeWidth, 0);
            strokeColor = a.getColor(R.styleable.ButtonChooserProfile_ftt_StrokeColor, Color.BLACK);
            selectedTabColor = a.getColor(R.styleable.ButtonChooserProfile_ftt_SelectedTabColor, Color.WHITE);
        } finally {
            a.recycle();
        }
    }

    private void setStrokeWidth() {
/*        Drawable view = ContextCompat.getDrawable(getContext(), R.drawable.background_shape_preset_button__pressed);
        GradientDrawable drawable = (GradientDrawable)view.getBackground();
        drawable.setStroke(3, Color.RED);*/

    /*    Drawable v = mInitialBackgroundDrawable;
        GradientDrawable drawable = (GradientDrawable) v;
        drawable.setStroke(strokeWidth, Color.BLACK);*/

        SomeDrawable drawable = new SomeDrawable( strokeWidth, strokeColor, 0);
        setBackgroundDrawable(drawable);
    }

    // Template method
    private void setupView() {
        inflateView();
        bindView();
        setCustomTouchListener();
        setStrokeWidth();
    }

    protected void inflateView() {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        inflater.inflate(R.layout.custom_preset_button, this, true);
        mValueTextView = findViewById(R.id.text_view_value);
        mInitialBackgroundDrawable = getBackground();
    }

    protected void bindView() {
        if (mValueTextColor != DEFAULT_TEXT_COLOR) {
            mValueTextView.setTextColor(mValueTextColor);
        }
        mValueTextView.setText(mValue);
    }

    //================================================================================
    // Overriding default behavior
    //================================================================================

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mOnClickListener = l;
    }

    protected void setCustomTouchListener() {
        super.setOnTouchListener(new TouchListener());
    }

    @Override
    public void setOnTouchListener(OnTouchListener onTouchListener) {
        mOnTouchListener = onTouchListener;
    }

    public OnTouchListener getOnTouchListener() {
        return mOnTouchListener;
    }

    private void onTouchDown(MotionEvent motionEvent) {
        setChecked(true);
    }

    private void onTouchUp(MotionEvent motionEvent) {
        // Handle user defined click listeners
        if (mOnClickListener != null) {
            mOnClickListener.onClick(this);
        }
    }
    //================================================================================
    // Public methods
    //================================================================================

    public void setCheckedState() {
        setBackgroundResource(R.drawable.background_shape_preset_button__pressed);
        setBackgroundColor(selectedTabColor);
        mValueTextView.setTextColor(mPressedTextColor);
    }

    public void setNormalState() {
        setBackgroundDrawable(mInitialBackgroundDrawable);
        mValueTextView.setTextColor(mValueTextColor);
        setStrokeWidth();
    }

    public String getValue() {
        return mValue;
    }

    public void setValue(String value) {
        mValue = value;
    }


    //================================================================================
    // Checkable implementation
    //================================================================================

    @Override
    public void setChecked(boolean checked) {
        if (mChecked != checked) {
            mChecked = checked;
            if (!mOnCheckedChangeListeners.isEmpty()) {
                for (int i = 0; i < mOnCheckedChangeListeners.size(); i++) {
                    mOnCheckedChangeListeners.get(i).onCheckedChanged(this, mChecked);
                }
            }
            if (mChecked) {
                setCheckedState();
            } else {
                setNormalState();
            }
        }
    }

    @Override
    public boolean isChecked() {
        return mChecked;
    }

    @Override
    public void toggle() {
        setChecked(!mChecked);
    }

    @Override
    public void addOnCheckChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        mOnCheckedChangeListeners.add(onCheckedChangeListener);
    }

    @Override
    public void removeOnCheckChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        mOnCheckedChangeListeners.remove(onCheckedChangeListener);
    }


    //================================================================================
    // Inner classes
    //================================================================================
    private final class TouchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    onTouchDown(event);
                    break;
                case MotionEvent.ACTION_UP:
                    onTouchUp(event);
                    break;
            }
            if (mOnTouchListener != null) {
                mOnTouchListener.onTouch(v, event);
            }
            return true;
        }
    }
}