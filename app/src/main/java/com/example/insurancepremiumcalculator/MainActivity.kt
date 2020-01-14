package com.example.insurancepremiumcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //spinnerAge.setOnItemClickListener(this)

        buttonCalculate.setOnClickListener {
            calculatePremium()
        }

        buttonReset.setOnClickListener {
            spinnerAge.setSelection(0)
            radioGroupGender.clearCheck()
            checkBoxSmoker.setChecked(false)
        }
    }

    private fun calculatePremium(){
        val agePosition = spinnerAge.selectedItemPosition
        val gender = radioGroupGender.checkedRadioButtonId
        val smoker = checkBoxSmoker.isChecked

        var premium: Int = 0

        if(agePosition == 0){
            premium += 60
        }else if(agePosition == 1){
            premium += 70
            if(gender == R.id.radioButtonMale){
                premium += 50
            }
            if(smoker){
                premium += 100
            }
        }else if(agePosition == 2){
            premium += 90
            if(gender == R.id.radioButtonMale){
                premium += 100
            }
            if(smoker){
                premium += 150
            }
        }else if(agePosition == 3){
            premium += 120
            if(gender == R.id.radioButtonMale){
                premium += 150
            }
            if(smoker){
                premium += 200
            }
        }else if(agePosition == 4){
            premium += 150
            if(gender == R.id.radioButtonMale){
                premium += 200
            }
            if(smoker){
                premium += 250
            }
        }else if(agePosition == 5){
            premium += 150
            if(gender == R.id.radioButtonMale){
                premium += 200
            }
            if(smoker){
                premium += 300
            }
        }

        textViewPremium.setText("RM " + premium.toString())
    }
}
