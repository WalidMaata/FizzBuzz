package com.fizzbuzz.app.presentation.game.form

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fizzbuzz.app.R
import com.fizzbuzz.app.data.model.FizzBuzz
import com.fizzbuzz.app.databinding.FragmentFormGameBinding
import com.google.android.material.snackbar.Snackbar


class FormGameFragment : Fragment() {

    private var _binding: FragmentFormGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.result.setOnClickListener {
            handleClickSeeResult()
        }
    }

    private fun handleClickSeeResult() {
        binding.apply {
            when {
                isNotValidForm() -> Snackbar.make(binding.root, getString(R.string.fill_all_fields_message), Snackbar.LENGTH_SHORT).show()

                binding.firstInteger.text.toString() == binding.secondInteger.text.toString() -> Snackbar.make(
                    binding.root,
                    getString(R.string.put_different_integer_message),
                    Snackbar.LENGTH_SHORT
                ).show()

                else -> openResultScreen()
            }
        }
    }

    private fun openResultScreen() {
        val fizzBuzz = FizzBuzz(
            binding.firstInteger.text.toString().toInt(),
            binding.secondInteger.text.toString().toInt(),
            binding.limit.text.toString().toInt(),
            binding.firstString.text.toString(),
            binding.secondString.text.toString()
        )

        val action = FormGameFragmentDirections.actionFormGameFragmentToResultGameFragment(fizzBuzz)
        findNavController().navigate(action)
    }

    private fun isNotValidForm(): Boolean {
        binding.apply {
            return firstInteger.text.isNullOrEmpty() or secondInteger.text.isNullOrEmpty() or limit.text.isNullOrEmpty() or firstString.text.isNullOrEmpty() or secondString.text.isNullOrEmpty()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}