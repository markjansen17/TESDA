package com.tip.capstone.mlearning.ui.main;

import android.app.Dialog;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.tip.capstone.mlearning.R;
import com.tip.capstone.mlearning.app.Constant;
import com.tip.capstone.mlearning.databinding.ActivityMainBinding;
import com.tip.capstone.mlearning.databinding.DialogSimulationChoiceBinding;
import com.tip.capstone.mlearning.ui.assessment.AssessmentActivity;
import com.tip.capstone.mlearning.ui.grades.detail.GradesDetailActivity;
import com.tip.capstone.mlearning.ui.map.MapsActivity;
import com.tip.capstone.mlearning.ui.simulation.SimulationActivityMicro;
import com.tip.capstone.mlearning.ui.simulation.SimulationActivitySys;
import com.tip.capstone.mlearning.ui.simulation.SimulationActivityVGA;
import com.tip.capstone.mlearning.ui.topics.TopicsListActivity;
import com.tip.capstone.mlearning.ui.videos.VideoListActivity;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.bg_gradient));
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        binding.study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //startActivity(new Intent(MainActivity.this, DifficultyActivity.class));
                Intent intent = new Intent(MainActivity.this, TopicsListActivity.class);
                intent.putExtra(Constant.ID,0);
                startActivity(intent);
            }
        });

        binding.map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        binding.videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VideoListActivity.class));

            }
        });

        binding.results.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GradesDetailActivity.class));
            }
        });

        binding.assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* DialogAssessmentChoiceBinding dialogBinding = DataBindingUtil.inflate(
                        getLayoutInflater(),
                        R.layout.dialog_assessment_choice,
                        null,
                        false);

                dialogBinding.trueorfalse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, AssessmentActivity.class).putExtra("type", 1));
                    }
                });
                dialogBinding.guessthetools.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, AssessmentActivity.class).putExtra("type", 2));
                    }
                });
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(dialogBinding.getRoot());
                dialog.show();*/
                startActivity(new Intent(MainActivity.this, AssessmentActivity.class).putExtra("type", 1));
            }
        });

        binding.simulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogSimulationChoiceBinding dialogBinding = DataBindingUtil.inflate(
                        getLayoutInflater(),
                        R.layout.dialog_simulation_choice,
                        null,
                        false);

                dialogBinding.sys.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, SimulationActivitySys.class));
                    }
                });
                dialogBinding.vga.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, SimulationActivityVGA.class));
                    }
                });

                dialogBinding.micro.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this, SimulationActivityMicro.class));
                    }
                });

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(dialogBinding.getRoot());
                dialog.show();
            }
        });
    }

}
