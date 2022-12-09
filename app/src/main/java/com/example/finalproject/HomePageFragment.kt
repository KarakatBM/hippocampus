package com.example.finalproject



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.finalproject.databinding.FragmentFolderBinding
import com.example.finalproject.databinding.FragmentHomePageBinding

class HomePageFragment : Fragment() {
    private var binding: FragmentHomePageBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
//        val binding: FragmentHomePageBinding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_home_page, container, false)

        binding = FragmentHomePageBinding.inflate(inflater, container, false)

        // Add OnClick Handler for CardViews
        binding!!.cardFlashcards.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_homePageFragment_to_foldersPageFragment)
        }

        binding!!.cardNotes.setOnClickListener { view: View ->
            view.findNavController()
                    .navigate(R.id.action_homePageFragment_to_notesFragment)
            }

        binding!!.cardPomodoro.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(R.id.action_homePageFragment_to_pomodoroFragment)
        }

        return binding!!.root
        }
    }


