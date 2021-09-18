package scm.cswong274.japaneseapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KataganaZukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KataganaZukFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Button[][] buttons = new  Button[5][5];
    public KataganaZukFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HiraganaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KataganaZukFragment newInstance(String param1, String param2) {
        KataganaZukFragment fragment = new KataganaZukFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_katagana_zuk, container, false);
        // Inflate the layout for this fragment [y,x]
        buttons[0][0] = v.findViewById(R.id.btn1_1);
        buttons[0][1] = v.findViewById(R.id.btn1_2);
        buttons[0][2] = v.findViewById(R.id.btn1_3);
        buttons[0][3] = v.findViewById(R.id.btn1_4);
        buttons[0][4] = v.findViewById(R.id.btn1_5);

        buttons[1][0] = v.findViewById(R.id.btn2_1);
        buttons[1][1] = v.findViewById(R.id.btn2_2);
        buttons[1][2] = v.findViewById(R.id.btn2_3);
        buttons[1][3] = v.findViewById(R.id.btn2_4);
        buttons[1][4] = v.findViewById(R.id.btn2_5);

        buttons[2][0] = v.findViewById(R.id.btn3_1);
        buttons[2][1] = v.findViewById(R.id.btn3_2);
        buttons[2][2] = v.findViewById(R.id.btn3_3);
        buttons[2][3] = v.findViewById(R.id.btn3_4);
        buttons[2][4] = v.findViewById(R.id.btn3_5);

        buttons[3][0] = v.findViewById(R.id.btn4_1);
        buttons[3][1] = v.findViewById(R.id.btn4_2);
        buttons[3][2] = v.findViewById(R.id.btn4_3);
        buttons[3][3] = v.findViewById(R.id.btn4_4);
        buttons[3][4] = v.findViewById(R.id.btn4_5);

        buttons[4][0] = v.findViewById(R.id.btn5_1);
        buttons[4][1] = v.findViewById(R.id.btn5_2);
        buttons[4][2] = v.findViewById(R.id.btn5_3);
        buttons[4][3] = v.findViewById(R.id.btn5_4);
        buttons[4][4] = v.findViewById(R.id.btn5_5);

        for (int i=0;i<buttons.length;i++)//y Size
        {
            for (int k=0;k<buttons[i].length;k++)//x size
            {
                buttons[i][k].setOnClickListener(this);
            }
        }
        return inflater.inflate(R.layout.fragment_katagana_zuk, container, false);
    }

    @Override
    public void onClick(View view) {

    }
}