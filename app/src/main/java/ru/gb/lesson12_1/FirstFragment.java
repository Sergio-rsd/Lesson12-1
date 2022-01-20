package ru.gb.lesson12_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {

    private SwitchViewModel viewModel;
    private Button firstSend;
    private EditText firstName;
    private TextView firstResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        viewModel = new ViewModelProvider((MainActivity)requireActivity()).get(SwitchViewModel.class);

        firstSend = view.findViewById(R.id.first_send);
        firstName = view.findViewById(R.id.first_name);
        firstResult = view.findViewById(R.id.first_result);

        firstSend.setOnClickListener(v -> viewModel.firstSay(firstName.getText().toString()));

        viewModel.getFirst().observe(requireActivity(), string -> firstResult.setText(string));
    }


}
