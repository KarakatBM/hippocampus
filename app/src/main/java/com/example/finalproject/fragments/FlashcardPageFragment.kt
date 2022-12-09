package com.example.finalproject.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.finalproject.R
import com.example.finalproject.databinding.FragmentFlashcardPageBinding

class FlashcardPageFragment : Fragment() {

    private var binding: FragmentFlashcardPageBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = FragmentFlashcardPageBinding.inflate(inflater, container, false)

        // Add OnClick Handler for Add Practice button
        binding!!.practiceButton.setOnClickListener { view: View->
            view.findNavController()
                .navigate(R.id.action_flashcardPageFragment_to_memorizationFragment) }

        // Add OnClick Handler for Add Flashcard button
        binding!!.addFlashcard.setOnClickListener{ view: View->
            view.findNavController()
                .navigate(R.id.action_flashcardPageFragment_to_addFlashcardFragment) }

        return binding!!.root
    }
}