package com.example.foodapp.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.example.foodapp.R

class RecipesBindingAdapter {

    companion object {
        @BindingAdapter("setNumberOfLikes")
        @JvmStatic
        fun setNumberOfLikes (textView: TextView, likes:Int) {
          textView.text = likes.toString()
        }

        @BindingAdapter("setNumberOfMinutes")
        @JvmStatic
        fun setNumberOfMinutes(textView: TextView, readyInMinutes:Int){
            textView.text = readyInMinutes.toString()
        }

        @BindingAdapter("applyVeganColor")
        @JvmStatic
        fun  applyVeganColor (view:View, vegan:Boolean) {
            if (vegan){
                when(view) {
                    is TextView ->{
                      view.setTextColor(
                          ContextCompat.getColor(  view.context,
                              R.color.green)

                      )
                    }
                    is ImageView ->{
                      view.setColorFilter(
                          ContextCompat.getColor(view.context, R.color.green)
                      )
                    }
                }
            }
        }
        @BindingAdapter("loadImageView")
        @JvmStatic
        fun loadImageView (imageView: ImageView, imageUrl: String) {
            imageView.load(imageUrl){
                crossfade(600)
            }
        }
    }
}