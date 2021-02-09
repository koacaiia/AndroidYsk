package fine.koacaiia.androidysk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Recyclerview extends AppCompatActivity {
    RecyclerView recyclerview;
    RecyclerAdapter adapter;
    ArrayList<RecyclerList> list;
    FirebaseDatabase database;
    DatabaseReference dataRef;
    EditText editPutData;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerview=findViewById(R.id.recyclerview);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerview.setLayoutManager(manager);
        database=FirebaseDatabase.getInstance();
        dataRef=database.getReference("Exercise");
        getPost();


//        for(int i=0;i<20;i++){
//            String a=i+"_Name";
//            String b=i+"_Contents";
//            RecyclerList mList=new RecyclerList(a,b);
//            list.add(mList);
//
//        }
        Log.i("koacaiia","List Size"+list.size());
        adapter=new RecyclerAdapter(list);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        btnSend=findViewById(R.id.btnSend);
        editPutData=findViewById(R.id.editPutData);
        InputMethodManager imm=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        btnSend.setOnClickListener(v->{
            String timeStamp=String.valueOf(System.currentTimeMillis());
        dataRef=database.getReference("Exercise/"+timeStamp );

            String contents=editPutData.getText().toString();
            String contents1="koacaiia";
            RecyclerList list=new RecyclerList("koacaiia",contents);
            Log.i("koacaiia","contents++++"+contents    );
            dataRef.setValue(list);
            editPutData.setText("");
            imm.hideSoftInputFromWindow(editPutData.getWindowToken(),0);
            getPost();
            Toast.makeText(this,"Message Send",Toast.LENGTH_SHORT).show();


        });
    }

    public void getPost(){
        list=new ArrayList<>();
        dataRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                for(DataSnapshot data:snapshot.getChildren()){
                    RecyclerList mList=data.getValue(RecyclerList.class);

                    list.add(mList);
                }
                adapter.notifyDataSetChanged();
                Log.i("koacaiia","List Size1"+list.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
