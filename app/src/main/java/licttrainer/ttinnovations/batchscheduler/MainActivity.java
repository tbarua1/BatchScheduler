package licttrainer.ttinnovations.batchscheduler;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //http://27.147.210.136:8080/bht/GetUniversities

    private String urlcordinator = "http://27.147.210.136:8080/bht/GetAllUniversityCoordinator";
    private String urltrainers = "http://27.147.210.136:8080/bht/GetTrainerList";
    private String urlbatchcode = "http://27.147.210.136:8080/bht/GetBatchCode";
    private String urltoupload="http://27.147.210.136:8080/bht/ScheduleBatch?batch=";
    private String jsonUniversity;
    private ObjectMapper mapper;
    private University[] universities;
    private BatchCode[] batchcode;
    private Trainer[] trainers;
    private EditText date, time, duration;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private int cmYear, cmMonth, cmDay, cmHour, cmMinute,dmHour, dmMinute;
    private Spinner spinnerUnibersity, spinnerTrainer, spinnerBatchCode;
    private Calendar c;
    private Button btn;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerUnibersity = (Spinner) findViewById(R.id.id_university);
        duration= (EditText) findViewById(R.id.durarion);
       // spinnerUnibersity.setFadingEdgeLength(5);
        spinnerTrainer = (Spinner) findViewById(R.id.id_trainer);
        spinnerBatchCode = (Spinner) findViewById(R.id.id_batch_code);
        spinnerBatchCode.setOnItemSelectedListener(this);
        spinnerTrainer.setOnItemSelectedListener(this);
        spinnerUnibersity.setOnItemSelectedListener(this);
        date = (EditText) findViewById(R.id.scheduleddate);

        time = (EditText) findViewById(R.id.scheduledtime);

        btn = (Button) findViewById(R.id.set_schedule);
        if(Build.VERSION.SDK_INT >= 21)
        {
            //this code will be executed on devices running ICS or later
            date.setShowSoftInputOnFocus(false);
            time.setShowSoftInputOnFocus(false);
        }
        c = Calendar.getInstance();
        date.setOnClickListener(this);
        time.setOnClickListener(this);
        duration.setOnClickListener(this);
        btn.setOnClickListener(this);
        addUniversites();
        addTrainers();
        addBatchCode();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void addBatchCode() {
        try {
            /* CustomAdapter customAdapter=new CustomAdapter(getApplicationContext(),countryNames);
        spin.setAdapter(customAdapter);*/

            jsonUniversity = new GetXMLTask().execute(urlbatchcode).get();
            //System.out.println("Data - "+jsonUniversity);
            mapper = new ObjectMapper();
            batchcode = mapper.readValue(jsonUniversity, BatchCode[].class);

           // List<String> list = new ArrayList<String>();
            String temp[]=new String[batchcode.length];
            for (int i = 0; i < batchcode.length; i++) {
               // list.add(batchcode[i].getBatchCode());
                temp[i]=batchcode[i].getBatchCode();
            }
            CustomeAdapter customAdapter=new CustomeAdapter(getApplicationContext(),temp);
           // ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, list);
            spinnerBatchCode.setAdapter(customAdapter);
            System.out.println("Add BatchCode Done");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addTrainers() {
        try {
            System.out.println("trying to retrive Trainers List");
            jsonUniversity = new GetXMLTask().execute(urltrainers).get();
            //System.out.println("Data - "+jsonUniversity);
            mapper = new ObjectMapper();
            trainers = mapper.readValue(jsonUniversity, Trainer[].class);

            /*List<String> list = new ArrayList<String>();
            for (int i = 0; i < trainers.length; i++) {
                list.add(trainers[i].getName());
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_spinner_item, list);*/
            String temp[]=new String[trainers.length];
            for (int i = 0; i < trainers.length; i++) {
                // list.add(batchcode[i].getBatchCode());
                temp[i]=trainers[i].getName();
            }
            CustomeAdapter dataAdapter=new CustomeAdapter(getApplicationContext(),temp);
            spinnerTrainer.setAdapter(dataAdapter);
            System.out.println("Add Trainers Done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    private void addUniversites() {
        try {
            System.out.println("Getting Universities");
            jsonUniversity = new GetXMLTask().execute(urlcordinator).get();
            System.out.println("Data - "+jsonUniversity);
            mapper = new ObjectMapper();
            University[] universities = mapper.readValue(jsonUniversity, University[].class);
          //  List<String> list = new ArrayList<String>();
           /* for (int i = 0; i < universities.length; i++) {
                list.add(universities[i].getName());
            }
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_spinner_item, list);*/
            String temp[]=new String[universities.length];
            for (int i = 0; i < universities.length; i++) {
                // list.add(batchcode[i].getBatchCode());
                temp[i]=universities[i].getName();
            }
            CustomeAdapter dataAdapter=new CustomeAdapter(getApplicationContext(),temp);
            spinnerUnibersity.setAdapter(dataAdapter);
            System.out.println("Add Universities Done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.scheduleddate:

                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
cmMonth=monthOfYear+1;
                                cmDay=dayOfMonth;
                                cmYear=year;
                                date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.scheduledtime:
                mHour = c.get(Calendar.HOUR);
                mMinute = c.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        cmHour=hourOfDay;
                        cmMinute=minute;
                        time.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);

                        /*new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay+":"+minute),mHour,mMinute)
                    }
                });*/
                timePickerDialog.show();
                       /* new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            time.setText(hourOfDay + ":" + minute + ":00");
                }, mYear, mMonth, mDay);
                timePickerDialog.show();*/
                break;
            case R.id.durarion:
                mHour = c.get(Calendar.HOUR);
                mMinute = c.get(Calendar.MINUTE);


                TimePickerDialog timePickerDialog1 = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        dmHour=hourOfDay;
                        dmMinute=minute;
                        duration.setText(hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);

                        /*new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay+":"+minute),mHour,mMinute)
                    }
                });*/
                timePickerDialog1.show();
                       /* new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            time.setText(hourOfDay + ":" + minute + ":00");
                }, mYear, mMonth, mDay);
                timePickerDialog.show();*/
                break;
            case R.id.set_schedule:
                ScheduleBatch scheduleBatch = new ScheduleBatch();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                String dateInString = cmDay+"-"+cmMonth+"-"+cmYear+" "+cmHour+":"+cmMinute+":00";
                Date date = null;
                try {
                    date = sdf.parse(dateInString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(date);
                scheduleBatch.setDate(date);

                String dateInString1 = cmDay+"-"+cmMonth+"-"+cmYear+" "+dmHour+":"+dmMinute+":00";
                Date d = null;
                try {
                    d = sdf.parse(dateInString1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(d);
                scheduleBatch.setTill(d);
                /*scheduleBatch.setDate(new Date(c.getTimeInMillis()));
                scheduleBatch.setTime(c.getTime());*/
                scheduleBatch.setStatus("scheduled");
                //String name =spinnerBatchCode.getId();
                TextView batchcode=(TextView)spinnerBatchCode.getSelectedView();
                TextView university=(TextView)spinnerUnibersity.getSelectedView();
                TextView trainer=(TextView)spinnerTrainer.getSelectedView();

                //System.out.println("name of University - "+t.getText());
                scheduleBatch.setUniversity(university.getText().toString());
                scheduleBatch.setBatchcode(batchcode.getText().toString());
                scheduleBatch.setTrainer(trainer.getText().toString());

                try {
                    String s = mapper.writeValueAsString(scheduleBatch);
                    //System.out.println(urltoupload+""+s+" Data to Upload - "+s);
                    String replace = s.replace(" ", "_");
                    String s1 = new GetXMLTask().execute(urltoupload+""+replace).get();
                    Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_LONG).show();
                    System.out.println("Result - "+s1);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();}
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       // Toast.makeText(getApplicationContext(), position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
