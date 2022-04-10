package com.example.jeckpackcompose

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController


class RecipelistFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply { 
            setContent { 
                Column() {
                    Text(text = "Hello", fontSize = 20.sp)
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(onClick = {findNavController().navigate(R.id.action_recipelistFragment_to_recipeFragment) }) {
                        Text(text = "ClickMe")
                    }
                }
            }
        }
    }


}