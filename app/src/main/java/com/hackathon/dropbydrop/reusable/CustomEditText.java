package com.hackathon.dropbydrop.reusable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.utils.UIUtils;

/**
 * This class is responsible for implementing customized edit text
 * 
 * @author Endeavour
 * 
 */
public class CustomEditText extends EditText {

	/**
	 * Constructor
	 * 
	 * @param context
	 *            The Context the view is running in, through which it can
	 *            access the current theme, resources, etc.
	 * @param attrs
	 *            The attributes of the XML tag that is inflating the view.
	 * @param defStyle
	 *            The default style to apply to this view. If 0, no style will
	 *            be applied (beyond what is included in the theme). This may
	 *            either be an attribute resource, whose value will be retrieved
	 *            from the current theme, or an explicit style resource.
	 */
	public CustomEditText(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		UIUtils.setCustomFont(this, context, attrs, R.styleable.com_cryptall_CustomView,
				R.styleable.com_cryptall_CustomView_font);
		// this.setLongClickable(false);
		// this.setTextIsSelectable(false);
		// this.setCustomSelectionActionModeCallback(customCallback);
	}

	/**
	 * Constructor
	 * 
	 * @param context
	 *            The Context the view is running in, through which it can
	 *            access the current theme, resources, etc.
	 * @param attrs
	 *            The attributes of the XML tag that is inflating the view.
	 * 
	 */
	public CustomEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		UIUtils.setCustomFont(this, context, attrs, R.styleable.com_cryptall_CustomView,
				R.styleable.com_cryptall_CustomView_font);
		// this.setLongClickable(false);
		// this.setTextIsSelectable(false);
		// this.setCustomSelectionActionModeCallback(customCallback);

	}

	/**
	 * Constructor
	 * 
	 * @param context
	 *            The Context the view is running in, through which it can
	 *            access the current theme, resources, etc.
	 * 
	 */
	public CustomEditText(Context context) {
		super(context);
		// this.setLongClickable(false);
		// this.setTextIsSelectable(false);
		// this.setCustomSelectionActionModeCallback(customCallback);
	}
}
