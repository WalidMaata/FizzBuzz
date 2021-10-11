package com.fizzbuzz.app.presentation.game.result

import android.os.Bundle
import android.view.*
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.fizzbuzz.app.databinding.FragmentResultGameBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ResultGameFragment : Fragment() {

    private val viewModel: ResultViewModel by viewModels()

    private var _binding: FragmentResultGameBinding? = null
    private val binding get() = _binding!!

    private val args: ResultGameFragmentArgs by navArgs()

    private val adapter: ResultAdapter by lazy {
        ResultAdapter(args.fizzBuzz)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.resultList.adapter = adapter
        viewModel.addOrUpdate(args.fizzBuzz)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}