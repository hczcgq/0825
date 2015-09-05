package com.lawyer.android.date;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import java.util.Calendar;

public class DatePicker extends FrameLayout {

	private Context mContext;
	private NumberPicker mDayPicker;
	private NumberPicker mMonthPicker;
	private NumberPicker mYearPicker;
	private Calendar mCalendar;

	private String[] mMonthDisplay;

	public DatePicker(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mCalendar = Calendar.getInstance();
		initMonthDisplay();
		((LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
				R.layout.date_picker, this, true);
		mYearPicker = (NumberPicker) findViewById(R.id.date_year);
		mMonthPicker = (NumberPicker) findViewById(R.id.date_month);
		mDayPicker = (NumberPicker) findViewById(R.id.date_day);

		mDayPicker.setMinValue(1);
		mDayPicker.setMaxValue(31);
		mDayPicker.setValue(20);
		mDayPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);

		mMonthPicker.setMinValue(0);
		mMonthPicker.setMaxValue(11);
		mMonthPicker.setDisplayedValues(mMonthDisplay);
		mMonthPicker.setValue(mCalendar.get(Calendar.MONTH));

		mYearPicker.setMinValue(1950);
		mYearPicker.setMaxValue(2100);
		mYearPicker.setValue(mCalendar.get(Calendar.YEAR));

		mMonthPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				mCalendar.set(Calendar.MONTH, newVal);
				updateDate();
			}
		});
		mDayPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {

				mCalendar.set(Calendar.DATE, newVal);
				updateDate();
			}
		});
		mYearPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				mCalendar.set(Calendar.YEAR, newVal);
				updateDate();

			}
		});

		updateDate();

	}

	private void initMonthDisplay() {
		mMonthDisplay = new String[12];
		mMonthDisplay[0] = "1";
		mMonthDisplay[1] = "2";
		mMonthDisplay[2] = "3";
		mMonthDisplay[3] = "4";
		mMonthDisplay[4] = "5";
		mMonthDisplay[5] = "6";
		mMonthDisplay[6] = "7";
		mMonthDisplay[7] = "8";
		mMonthDisplay[8] = "9";
		mMonthDisplay[9] = "10";
		mMonthDisplay[10] = "11";
		mMonthDisplay[11] = "12";
	}

	private void updateDate() {
		System.out.println("Month: " + mCalendar.get(Calendar.MONTH) + " Max: "
				+ mCalendar.getActualMaximum(Calendar.DATE));
		mDayPicker.setMinValue(mCalendar.getActualMinimum(Calendar.DATE));
		mDayPicker.setMaxValue(mCalendar.getActualMaximum(Calendar.DATE));
		mDayPicker.setValue(mCalendar.get(Calendar.DATE));
		mMonthPicker.setValue(mCalendar.get(Calendar.MONTH));
		mYearPicker.setValue(mCalendar.get(Calendar.YEAR));
	}

	public DatePicker(Context context) {
		this(context, null);
	}

	public String getDate() {
		String date = mYearPicker.getValue() + "-"
				+ (mMonthPicker.getValue() + 1) + "-" + mDayPicker.getValue();
		return date;

	}

	public int getDay() {
		return mCalendar.get(Calendar.DAY_OF_MONTH);
	}

	public int getMonth() {
		return mCalendar.get(Calendar.MONTH);
	}

	public int getYear() {
		return mCalendar.get(Calendar.YEAR);
	}

	public void setCalendar(Calendar calendar) {
		mCalendar = calendar;
		updateDate();
	}

}
