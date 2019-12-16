package com.example.rgr_v3
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo

import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_days.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment_Days(needed_day: String, baza:FirebaseDatabase) : Fragment() {
    val day = needed_day
    val basa = baza
    var zamet: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_days, container, false)
        val myRef = basa.getReference(day)

        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dayModel = dataSnapshot.getValue(Days::class.java)
                dayModel?.let {
                    text_vt_chis_1.text = it.les_1_chis
                    text_vt_znam_1.text = it.les_1_znam
                    text_vt_chis_2.text = it.les_2_chis
                    text_vt_znam_2.text = it.les_2_znam
                    text_vt_chis_3.text = it.les_3_chis
                    text_vt_znam_3.text = it.les_3_znam
                    text_vt_chis_4.text = it.les_4_chis
                    text_vt_znam_4.text = it.les_4_znam
                    zamet = it.note
                    note.setText(zamet)
                }
                note.setOnEditorActionListener { v, actionId, event ->
                    return@setOnEditorActionListener when (actionId) {
                        EditorInfo.IME_ACTION_SEND -> {
                            basa.getReference("$day/note").setValue(note.getText().toString())

                            true
                        }
                        else -> false
                    }
                }
            }
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }

        })
        // Inflate the layout for this fragment
        return view
    }
    override fun onResume() {
        super.onResume()
        note.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_SEND -> {
                    basa.getReference("$day/note").setValue(note.getText().toString())
                    true
                }
                else -> false

            }
        }
    }
}

