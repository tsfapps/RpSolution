package com.rpsolution.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;
import com.rpsolution.R;
import com.rpsolution.activity.DashboardActivity;
import com.rpsolution.utils.ConstantVal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LeaveCalFragment extends Fragment {

    private DashboardActivity mActivity;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MMM yyyy", Locale.getDefault());
    @BindView(R.id.ccv_leave)
    protected CompactCalendarView ccvLeave;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (DashboardActivity) getActivity();
        if (mActivity != null){
            mActivity.setToolbarTitle("Feb 2019");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_leave, container, false);
        ButterKnife.bind(this, view);

        LeaveEvent();
        return view;
    }

    private void LeaveEvent(){
        ccvLeave.setFirstDayOfWeek(Calendar.MONDAY);
        // Add event 1 on Thursday, 28 Feb 2019
        Event ev1 = new Event(Color.RED, 1551339426000L, "Some extra data that I want to store.");
        ccvLeave.addEvent(ev1);

        // Add event 1 on Thursday, 28 Mar 2019
        Event ev2 = new Event(Color.RED, 1553758626000L);
        ccvLeave.addEvent(ev2);

        //Add event 1 on Monday, 25 Feb 2019
        Event ev3 = new Event(Color.RED, 1551037026000L);
        ccvLeave.addEvent(ev3);

        //Add event 1 on Monday, 23 Feb 2019
        Event ev4 = new Event(Color.RED, 1550864226000L);
        ccvLeave.addEvent(ev4);

        ccvLeave.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                List<Event> events = ccvLeave.getEvents(dateClicked);
                Toast.makeText(getContext(), "Leave day", Toast.LENGTH_SHORT).show();
                Log.d(ConstantVal.TAG, "Day was clicked: " + dateClicked + " with events " + events);
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

                if (mActivity != null){
                    mActivity.setToolbarTitle(dateFormat.format(firstDayOfNewMonth));
                }
                Log.d(ConstantVal.TAG, "Month was scrolled to: " + firstDayOfNewMonth);
            }
        });
    }

//    private void setTitle(){
//
//    }

}
