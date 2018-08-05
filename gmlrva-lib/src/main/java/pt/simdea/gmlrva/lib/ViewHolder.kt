package pt.simdea.gmlrva.lib

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder(@NonNull var itemView: View) : RecyclerView.ViewHolder(itemView)
        , IViewHolder
