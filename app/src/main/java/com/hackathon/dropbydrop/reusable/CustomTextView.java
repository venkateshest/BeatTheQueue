package com.hackathon.dropbydrop.reusable;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.hackathon.dropbydrop.R;
import com.hackathon.dropbydrop.utils.UIUtils;


/**
 * This class is responsible for implementing customized cryptall font
 * 
 * @author Endeavour
 * 
 */
public class CustomTextView extends TextView {
	
	private boolean useDefaultEmoticons;

	/**
	 * Constructor
	 * 
	 * @param context
	 *            The Context the view is running in, through which it can
	 *            access the current theme, resources, etc.
	 * 
	 */
	public CustomTextView(Context context) {
		super(context);
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
	public CustomTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		UIUtils.setCustomFont(this, context, attrs, R.styleable.com_dropByDrop_CustomView,
				R.styleable.com_dropByDrop_CustomView_font);
		useDefaultEmoticons = UIUtils.isVersionKitkatOrAbove();
	}

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
	public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		UIUtils.setCustomFont(this, context, attrs, R.styleable.com_dropByDrop_CustomView,
				R.styleable.com_dropByDrop_CustomView_font);
		useDefaultEmoticons = UIUtils.isVersionKitkatOrAbove();
	}

}
