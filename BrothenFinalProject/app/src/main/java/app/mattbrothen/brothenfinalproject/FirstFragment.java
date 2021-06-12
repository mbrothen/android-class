package app.mattbrothen.brothenfinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    private Button listActivityButton;
    private Button okButton;
    private EditText editText;
    private TextView textView;
    private Button toastButton;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
        // Add layout button to listActivityButton and set on click
        listActivityButton = view.findViewById(R.id.listActivityButton);
        listActivityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                // Open second activity on click
                Intent intent = new Intent(v.getContext(), ListActivity.class);
                startActivity(intent);


            }
        });

        // Ok Button, get text from input text and add it to the text view on Ok click
        okButton = view.findViewById(R.id.btn_OK);
        editText = view.findViewById(R.id.txt_name);
        textView = view.findViewById(R.id.textview_first);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the value of the edit text field and set it to the text view
                textView.setText(editText.getText());

            }
        });

        // Handle toast button
        toastButton = view.findViewById(R.id.toastButton);
        toastButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "TOAST!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}