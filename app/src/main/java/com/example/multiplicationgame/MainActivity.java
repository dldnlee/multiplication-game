package com.example.multiplicationgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.multiplicationgame.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    Random rand = new Random();
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        newGame();

        binding.answerButton.setOnClickListener(v -> calculate());

        binding.restartButton.setOnClickListener(v -> newGame());
    }

    private void calculate() {
        String empty = binding.answer.getText().toString();

        if (empty.isEmpty()) {
            Toast.makeText(this, "정답을 입력하세요", Toast.LENGTH_SHORT).show();
            return;
        }

        int usrAnswer = Integer.parseInt(empty);

        if (usrAnswer == result) {
            binding.result.setText("정답!");
        } else {
            binding.result.setText(String.format("정답은 %d입니다", result));
        }
    }

    private void newGame() {
        int num1 = rand.nextInt(11) + 1, num2 = rand.nextInt(11) + 1;
        binding.question.setText(String.format("%d x %d =", num1, num2));
        binding.answer.setText("");

        result = num1 * num2;
    }



}