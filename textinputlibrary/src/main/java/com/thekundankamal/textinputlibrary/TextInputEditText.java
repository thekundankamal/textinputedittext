package com.thekundankamal.textinputlibrary;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextInputEditText extends RelativeLayout {
    public EditText edData;
    public TextView tvTitle;
    public RelativeLayout rlContainer;

    public TextInputEditText(Context context) {
        super(context);
    }

    public TextInputEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.text_input_layout,this,true);
        edData=view.findViewById(R.id.ed_edit_text);
        tvTitle=view.findViewById(R.id.tv_title);
        rlContainer=view.findViewById(R.id.rl_container);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextInputOption, 0, 0);
        String titleText = typedArray.getString(R.styleable.TextInputOption_titleText);
        String hintText = typedArray.getString(R.styleable.TextInputOption_hintText);
        int titleColor = typedArray.getColor(R.styleable.TextInputOption_titleColor,getResources().getColor(android.R.color.holo_blue_light));
        int hintColor = typedArray.getColor(R.styleable.TextInputOption_hintColor,getResources().getColor(android.R.color.holo_blue_light));
        int textColor = typedArray.getColor(R.styleable.TextInputOption_textColor,getResources().getColor(android.R.color.holo_blue_light));
        float titleTextSize = typedArray.getDimension(R.styleable.TextInputOption_titleTextSize,2f);
        float textSize = typedArray.getDimension(R.styleable.TextInputOption_textSize,1f);
        int maxLength = typedArray.getInt(R.styleable.TextInputOption_maxLength,100);
        final int borderWidth = typedArray.getInt(R.styleable.TextInputOption_borderWidth,3);
        final int borderColor = typedArray.getColor(R.styleable.TextInputOption_borderColor,getResources().getColor(R.color.strokeColor));
        final int borderSelectedColor = typedArray.getColor(R.styleable.TextInputOption_borderSelectedColor,getResources().getColor(R.color.strokeColor));
        typedArray.recycle();

        edData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(TextUtils.isEmpty(edData.getText().toString())){
                    tvTitle.setVisibility(GONE);
                    serBorderColor(borderWidth,borderColor);
                } else {
                    tvTitle.setVisibility(VISIBLE);
                    serBorderSelectedColor(borderWidth,borderSelectedColor);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        //Set the content in attribute
        edData.setHint(hintText);
        tvTitle.setText(titleText);
        tvTitle.setTextColor(titleColor);
        tvTitle.setTextSize(titleTextSize);
        edData.setTextSize(textSize);
        edData.setHintTextColor(hintColor);
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        edData.setFilters(fArray);
        edData.setTextColor(textColor);
    }

    /*
     * This method is calling to
     * change the  border color of EditText
     * */
    public void serBorderSelectedColor(int borderWidth, int borderSelectedColor){
        GradientDrawable drawable = (GradientDrawable)rlContainer.getBackground();
        drawable.setStroke(borderWidth, borderSelectedColor); // set stroke width and stroke color
    }

    /*
     * This method is calling to
     * set border color of EditText
     * */
    public void serBorderColor(int borderWidth, int borderColor){
        GradientDrawable drawable = (GradientDrawable)rlContainer.getBackground();
        drawable.setStroke(borderWidth, borderColor); // set stroke width and stroke color
    }

    //Set title on component
    public void setTitleText(String title){
        tvTitle.setText(title);
    }

    //Set hint text on component
    public void setHintText(String hintText){
        edData.setHint(hintText);
    }

    //Set hint text size of edit text
    public void setText(String text){
        edData.setText(text);
    }

}
