package edu.whitworth.midterm1;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {//class fragment starts here
        public double dollar = 0;
        public int from = 0;
        public int to = 0;
        ArrayList<Double> USD = new ArrayList<Double>();
        ArrayList<Double> CAD = new ArrayList<Double>();
        ArrayList<Double> AUD = new ArrayList<Double>();
        ArrayList<Double> JMD = new ArrayList<Double>();
        ArrayList<Double> NZD = new ArrayList<Double>();

        public PlaceholderFragment() {

            Currencies();//Run!!
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            initButtons(rootView);
            return rootView;
        }

        private void Currencies() {


            USD.add(1.10);//AUD -- 0
            USD.add(1.12);//CAD -- 1
            USD.add(109.28);//JMD -- 2
            USD.add(1.17);//NZD -- 3
            USD.add(1.00);//USD --4

            CAD.add(0.89);//AUD -- 0
            CAD.add(1.00);//CAD -- 1
            CAD.add(97.49);//JMD -- 2
            CAD.add(1.5);//NZD -- 3
            CAD.add(0.89);//USD --4

            AUD.add(1.00);//AUD -- 0
            AUD.add(1.02);//CAD -- 1
            AUD.add(99.34);//JMD -- 2
            AUD.add(1.06);//NZD -- 3
            AUD.add(0.91);//USD --4

            JMD.add(0.01);//AUD -- 0
            JMD.add(0.01);//CAD -- 1
            JMD.add(1.00);//JMD -- 2
            JMD.add(0.011);//NZD -- 3
            JMD.add(0.092);//USD --4

            NZD.add(0.94);//AUD -- 0
            NZD.add(0.96);//CAD -- 1
            NZD.add(93.28);//JMD -- 2
            NZD.add(1.00);//NZD -- 3
            NZD.add(0.85);//USD --4

        }

        private void initButtons(View v) {

            // FROM SECTION!!!!!!!!!

            Button btn = (Button) v.findViewById(R.id.from_USD_radio);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    from = 4;//USD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());//This is in case nothing is entered into the edit text box
                    } catch (NumberFormatException e) {
                        dollar = 0.00;
                    }

                    tv.setText(Double.toString(dollar * USD.get(to)));
                }
            });

            btn = (Button) v.findViewById(R.id.from_JMD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    from = 2;

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    String test = et.getText().toString();

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(test);
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * JMD.get(to)));

                }
            });

            btn = (Button) v.findViewById(R.id.from_CAD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    from = 1;

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * CAD.get(to)));

                }
            });

            btn = (Button) v.findViewById(R.id.from_NZD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    from = 3;

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * NZD.get(to)));
                }
            });

            btn = (Button) v.findViewById(R.id.from_AUD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    from = 0;

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * AUD.get(to)));
                }
            });

            // To!!!!!!! section


            btn = (Button) v.findViewById(R.id.to_USD_radio);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                to = 4;//USD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * USD.get(from)));

                }
            });

            btn = (Button) v.findViewById(R.id.to_JMD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    to = 2;//JMD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * JMD.get(from)));

                }
            });

            btn = (Button) v.findViewById(R.id.to_CAD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    to = 1;//CAD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * CAD.get(from)));

                }
            });

            btn = (Button) v.findViewById(R.id.to_NZD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    to = 3;//NZD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * NZD.get(from)));
                }
            });

            btn = (Button) v.findViewById(R.id.to_AUD_radio);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    to = 0;//AUD

                    EditText et = (EditText) getActivity().findViewById(R.id.editText);

                    TextView tv = (TextView) getActivity().findViewById(R.id.textView);

                    try {
                        dollar = Double.parseDouble(et.getText().toString());
                    } catch (NumberFormatException e) {
                        dollar = 0;
                    }

                    tv.setText(Double.toString(dollar * AUD.get(from)));
                }
            });

        }
    }

}
