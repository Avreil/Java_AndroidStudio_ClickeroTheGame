package com.avreil.clickero;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Buildings extends AppCompatActivity {
    int productionBuildingsCounter = 1;
    private Integer gold;
    private SharedPreferences buildingsSharedPref;
    private SharedPreferences.Editor editor;
    private Building building1,building2;
    private Materials materials;
    private TextView moneyAmount,stoneAmount,woodAmount;
    private TextView productionName1, productionDesc1, productionCounter1, productionPerSecond1, productionCost1;
    //production
    private String prod = "production";
    private TextView[][] production;

/*

TEXT VIEWS
name 0
description 1
counter 2
perSecond 3
cost 4
 */

/*
ID's
Production
0 = wood

 */









    public void setText(){

    }


    public void loadData(Building _building){


}

    public void saveData(Building _building){


        editor.apply();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_buildings);
        Intent intent = getIntent();
        gold = intent.getIntExtra("GoldToActivity", 0);
        buildingsSharedPref = getSharedPreferences("BuildingsUpgradeInfo",0);
        editor = buildingsSharedPref.edit();

            //work classes
        production = new TextView[productionBuildingsCounter][5];
        materials = new Materials();
        building1= new Building("Lumber mill","Produces wood", 10000,0);
        building2 = new Building("Quarry", "Mine Stone", 50000,1);


            //initialize and preset textViews
        initialize();
        initializeTextView(production,prod+"Wood",building1.getId());
        setTextView(production,building1);

            //declare amount list TextView
        moneyAmount.setText(Integer.toString(gold));
        woodAmount.setText(Integer.toString(materials.getWood()));
        stoneAmount.setText(Integer.toString(materials.getStone()));



            //DevReset
        Button resetButton = findViewById(R.id.resetBtn);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gold = 0;
                moneyAmount.setText("0");
            }
        });

        Button BackButton = findViewById(R.id.backBtn);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("GoldBack", gold);
                setResult(RESULT_OK, resultIntent);
                finish(); }
        });





    }//END OF ON CREATE


    private void initialize(){
            //list of materials
        moneyAmount = findViewById(R.id.moneyAmmount);
        woodAmount = findViewById(R.id.woodAmount);
        stoneAmount = findViewById(R.id.stoneAmount);


    }//END OF INITIALIZE

    public void initializeTextView(TextView[][] _inputText, String _string, int _id){

        int ID;
        for (int i=0;i<5;i++){

            ID = getResources().getIdentifier(_string + Integer.toString(i),
                    "id", getPackageName());
            _inputText[_id][i] = findViewById(ID);

        }
    }

    public void setTextView(TextView[][] _inputText, Building _inputBuilding) {

        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    _inputText[_inputBuilding.getId()][i].setText(_inputBuilding.getName());
                    break;
                case 1:
                    _inputText[_inputBuilding.getId()][i].setText(_inputBuilding.getDesc());
                    break;
                case 2:
                    _inputText[_inputBuilding.getId()][i].setText(_inputBuilding.getCounterString());
                    break;
                case 3:
                    _inputText[_inputBuilding.getId()][i].setText(_inputBuilding.getPerSecondString());
                    break;
                case 4:
                    _inputText[_inputBuilding.getId()][i].setText(_inputBuilding.getPriceString());
                    break;
            }
        }
    }



}//END OF CLASS
