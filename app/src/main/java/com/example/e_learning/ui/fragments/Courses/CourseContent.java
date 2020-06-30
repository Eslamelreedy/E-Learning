package com.example.e_learning.ui.fragments.Courses;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_learning.R;

public class CourseContent extends AppCompatActivity {

    ListView listView;
    String Lectures []  = {"Lecture","Lecture","Lecture","Lecture","Lecture"};
    String Number []  = {"1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        listView = findViewById(R.id.lectures_list_view);


        //a5er step nbasy l values lel adapter
        AdapterForLecture adapter = new AdapterForLecture(this,Lectures,Number);
        listView.setAdapter(adapter);

        // optional b3d el a5era n3ml on click 3l items el gwa l list
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int i, long l) {

                if(i==0) {
                    Toast.makeText(CourseContent.this,"material 1 will upload soon",Toast.LENGTH_LONG).show();
                }
                if(i==1) {
                    Toast.makeText(CourseContent.this,"material 2 will upload soon",Toast.LENGTH_LONG).show();
                }
                if(i==2) {
                    Toast.makeText(CourseContent.this,"material 3 will upload soon",Toast.LENGTH_LONG).show();
                }
                if(i==3) {
                    Toast.makeText(CourseContent.this,"material 4 will upload soon",Toast.LENGTH_LONG).show();
                }
                if(i==4) {
                    Toast.makeText(CourseContent.this,"material 5 will upload soon",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
    class AdapterForLecture extends ArrayAdapter<String> {
        Context context;
        String[] lecture;
        String[] num;
        AdapterForLecture(Context c, String L [] , String N [] ){
            super(c,R.layout.leclist, R.id.TextView1,L);
            this.context=c;
            this.lecture=L;
            this.num = N;

        }
        //tany step
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rows = layoutInflater.inflate(R.layout.leclist,parent,false);
            TextView lecs = rows.findViewById(R.id.TextView1);
            TextView nums= rows.findViewById(R.id.number1);
            lecs.setText(lecture[position]);
            nums.setText(num[position]);
            return rows;
        }
    }
}
