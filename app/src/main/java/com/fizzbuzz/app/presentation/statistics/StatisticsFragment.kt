package com.fizzbuzz.app.presentation.statistics

import android.os.Bundle
import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fizzbuzz.app.databinding.FragmentStatisticsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class StatisticsFragment : Fragment() {

    private val viewModel : StatisticsViewModel by viewModels()

    private var _binding: FragmentStatisticsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatisticsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
    }

    private fun observeData() {
        viewModel.mostFrequentFizzBuzz.observe(viewLifecycleOwner) { fizzBuzz ->
            fizzBuzz?.apply {
                binding.form.isVisible = true
                binding.noStatistics.isVisible = false
                binding.firstInteger.editText?.setText(firstInteger.toString())
                binding.secondInteger.editText?.setText(secondInteger.toString())
                binding.limit.editText?.setText(limit.toString())
                binding.firstString.editText?.setText(firstString)
                binding.secondString.editText?.setText(secondString)
                binding.hitNumber.editText?.setText(count.toString())
            } ?: run {
                binding.form.isVisible = false
                binding.noStatistics.isVisible = true
            }
        }
    }
}