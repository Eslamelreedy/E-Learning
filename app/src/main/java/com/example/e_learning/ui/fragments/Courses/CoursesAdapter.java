package com.example.e_learning.ui.fragments.Courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.e_learning.R;
import com.example.e_learning.pojo.CourseModel;

import java.util.ArrayList;

public class CoursesAdapter extends ArrayAdapter<CourseModel> implements View.OnClickListener{

    private ArrayList<CourseModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtDr;
        TextView txtLvl;
    }

    public CoursesAdapter(ArrayList<CourseModel> data, Context context) {
        super(context, R.layout.rowlist, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        CourseModel dataModel=(CourseModel) object;


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        CourseModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag


        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.rowlist, parent, false);
            viewHolder.txtName =  convertView.findViewById(R.id.coursename);
            viewHolder.txtDr =  convertView.findViewById(R.id.DrName);
            viewHolder.txtLvl = convertView.findViewById(R.id.CourseLvl);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.txtName.setText(dataModel.getCourseName());
        viewHolder.txtDr.setText(dataModel.getDrName());
        viewHolder.txtLvl.setText(dataModel.getCourseLvl());

        return convertView;
    }
}
