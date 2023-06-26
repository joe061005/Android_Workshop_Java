package cs.hku.hk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseListActivity extends ListActivity {
    ArrayList<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        ArrayList<String> courseName = intent.getStringArrayListExtra("CourseName");
        ArrayList<String> teachers = intent.getStringArrayListExtra("Teachers");
        for (int i = 0; i < courseName.size(); i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("CourseName", courseName.get(i));
            map.put("Teachers", teachers.get(i));
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(this,
                list,  // array list
                R.layout.course_list_item, // layout file
                new String[]{"CourseName", "Teachers"}, // key in the array list
                new int[]{R.id.coursename, R.id.teachers} ); // id of the textview

        setListAdapter(adapter);


    }
}