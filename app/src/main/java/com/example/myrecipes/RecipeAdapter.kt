package com.example.myrecipes

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecipeAdapter(private val recipes: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val current = recipes[position]
        //изображения пока нет

        holder.imageView.setImageResource(FoodUtils().resolveFoodImg(current.imageLink))
        //holder.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        holder.typeOfMealsTV.text = current.category.name
        holder.titleForRecipeTV.text = current.title
        holder.recipeRB.rating = current.rating
        holder.caloriesTV.text = current.calories.toString()
        holder.timeToCookTV.text = current.timeToCook.toString()
        holder.countOfPortionsTV.text = current.countServings.toString()
        holder.beLikeAPPCB.isChecked = current.beLike


    }

    override fun getItemCount(): Int {
        return recipes.size
    }


    class RecipeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        internal var imageView: ImageView = v.findViewById(R.id.first_foto_recipe_iv_fragment)
        internal var typeOfMealsTV: TextView = v.findViewById(R.id.type_of_meals_for_card_tv_fragment)
        internal var titleForRecipeTV: TextView = v.findViewById(R.id.title_tv_fragment)
        internal var recipeRB: RatingBar = v.findViewById(R.id.ratingBar_cards_rb)
        internal var caloriesTV: TextView = v.findViewById(R.id.calories_tv)
        internal var timeToCookTV: TextView = v.findViewById(R.id.time_to_cook_tv)
        internal var countOfPortionsTV: TextView = v.findViewById(R.id.count_of_portions_tv)
        internal var beLikeAPPCB: AppCompatCheckBox = v.findViewById(R.id.be_like_appcb)

    }
}


