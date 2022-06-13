package com.example.hotornot.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hotornot.Constants
import com.example.hotornot.R
import com.example.hotornot.databinding.FragmentMotivationBinding

class MotivationFragment : Fragment() {

    private lateinit var binding: FragmentMotivationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMotivationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSpan()
        backToLastScreen()
    }

    private fun setSpan() {
        val spannable = SpannableStringBuilder(getString(R.string.who_is_hot))
        spannable.setSpan(
            ForegroundColorSpan(Color.RED),
            Constants.START_SPAN,
            Constants.END_SPAN,
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.txtQuestion.text = spannable
    }

    private fun backToLastScreen() {
        binding.btnIam.setOnClickListener {
            showToastMessage()
            activity?.onBackPressed()
        }
    }

    private fun showToastMessage(){
        Toast.makeText(requireContext(), getString(R.string.cant_run_from_yourself), Toast.LENGTH_SHORT).show()
    }
}