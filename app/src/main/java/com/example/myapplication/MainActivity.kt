package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create object for spinner
        val spinner : Spinner = findViewById(R.id.CourseSelection)

        //create array adapter
        ArrayAdapter.createFromResource(
            this,
            R.array.course_selection,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            //Specify the layout to use when the list of choice appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            //Apply the adapter to the spinner
            spinner.adapter = adapter
        }

    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id:Long){


        val selectionTv: TextView = findViewById(R.id.selectionResults)
        selectionTv.text = parent.getItemAtPosition(pos).toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>){

        val selectionTv : TextView = findViewById(R.id.selectionResults)
        selectionTv.text = "You have not make a course selection"
    }
}