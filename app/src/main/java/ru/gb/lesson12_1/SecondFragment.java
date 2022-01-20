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
import androidx.lifecycle.ViewModelProvider;

public class SecondFragment extends Fragment {

    private SwitchViewModel viewModel;
    private Button secondSend;
    private EditText secondName;
    private TextView secondResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider((MainActivity)requireActivity()).get(SwitchViewModel.class);

        secondSend = view.findViewById(R.id.second_send);
        secondName = view.findViewById(R.id.second_name);
        secondResult = view.findViewById(R.id.second_result);

        secondSend.setOnClickListener(v -> viewModel.secondSay(secondName.getText().toString()));

        viewModel.getSecond().observe(requireActivity(), string -> secondResult.setText(string));

    }


}
