package com.example.dialogs

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // simple dialog
        // dialog interface is used to dismiss the dialog, in this case we have the buttons which will dismiss it.
        // index is the item indexes in the array passed in.

        val dialog = AlertDialog.Builder(this)
            .setIcon(R.drawable.ic_baseline_person_add_alt_1_24)
            .setTitle("Add Contact")
            .setMessage("Would you like to add this contact?")
            .setPositiveButton("Yes"){dialoginterface, index -> Toast.makeText(this, "Contact has been added", Toast.LENGTH_SHORT).show() }
            .setNegativeButton("No"){dialoginterface, index -> Toast.makeText(this, "Contact has not been added", Toast.LENGTH_SHORT).show() }
            .create()

        button.setOnClickListener {
            dialog.show()
        }

        // single choice dialog
        // dialog interface is used to dismiss the dialog, in this case we have the buttons which will dismiss it.
        // index is the item indexes in the array passed in.

        val options = arrayOf("Option One","option Two","Option Three")

        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose an Option")
            .setSingleChoiceItems(options,0){dialoginterface, index -> Toast.makeText(this, "You clicked on ${options[index]}", Toast.LENGTH_SHORT).show() }
            .setPositiveButton("Accept") {dialoginterface, index-> Toast.makeText(this, "You Accepted the chosen option", Toast.LENGTH_SHORT).show() }
            .setNegativeButton("Decline") {dialoginterface, index -> Toast.makeText(this, "You Declined the chosen option", Toast.LENGTH_SHORT).show() }
            .create()

        button2.setOnClickListener {
            singleChoiceDialog.show()
        }


        val multipleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose an Option")
            // dialog interface is used to dismiss the dialog, in this case we have the buttons which will dismiss it.
            // index is the item indexes in the array passed in.
            // isChecked is the third required parameter which will hold the info if an item has been checked.
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){dialoginterface, index, isChecked ->

            if (isChecked){
                Toast.makeText(this, "You have checked ${options[index]}", Toast.LENGTH_SHORT).show() }
            }
            .setPositiveButton("Accept") {dialoginterface, index -> Toast.makeText(this, "You Accepted the chosen option", Toast.LENGTH_SHORT).show() }
            .setNegativeButton("Decline") {dialoginterface, index-> Toast.makeText(this, "You Declined the chosen option", Toast.LENGTH_SHORT).show() }
            .create()

        button3.setOnClickListener {
            multipleChoiceDialog.show()
        }





    }


}