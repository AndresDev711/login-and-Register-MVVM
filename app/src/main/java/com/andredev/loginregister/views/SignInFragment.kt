package com.andredev.loginregister.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andredev.loginregister.databinding.FragmentSignInBinding
import com.andredev.loginregister.viewmodel.AuthViewModel


class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authViewModel = ViewModelProvider(requireActivity()).get(AuthViewModel::class.java)

        authViewModel.userData.observe(requireActivity(), Observer {
            if(it != null){
                Log.d("TAG", "onCreate: ")
                Toast.makeText(requireContext(), "Login exitoso", Toast.LENGTH_SHORT).show()
            }else{
                Log.d("TAG", "error fragemnt ")
            }
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)

        loginUser()
        goToRegisterFragment()
        goToForgotFragment()

        return binding.root
    }

    private fun loginUser() {
        binding.btnLogin.setOnClickListener {
            val email = binding.tiEmail.text.toString()
            val password = binding.tiPassword.text.toString()
            authViewModel.signIn(email, password)
        }
    }

    private fun goToRegisterFragment() {
        binding.btnRegister.setOnClickListener {
        }
    }

    private fun goToForgotFragment() {
        binding.btnForgotPassword.setOnClickListener {
        }
    }

}
