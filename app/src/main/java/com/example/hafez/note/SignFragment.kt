package com.example.hafez.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hafez.R

class SignFragment : Fragment() {
    private lateinit var signDialog: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sign_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        signDialog = view.findViewById(R.id.goToSign)

        signDialog.setOnClickListener {
            val signDialogFragment = SignDialogFragment()
            signDialogFragment.show(parentFragmentManager, "SignDialogFragment")
        }
    }
}