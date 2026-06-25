package id.my.labsi.belajarapi.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.my.labsi.belajarapi.api.model.Product
import id.my.labsi.belajarapi.R

class ProductAdapter(private val onClick: (Product) -> Unit) :
    ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductCallBack){

    class ProductViewHolder(itemView: View, val onClick: (Product) -> Unit) :
        RecyclerView.ViewHolder(itemView){

            private val thumbnail: ImageView = itemView.findViewById(R.id.imgv_thumbnail)
            private val title: TextView = itemView.findViewById(R.id.txtv_title)
            private val brand: TextView = itemView.findViewById(R.id.txtv_brand)
            private val price: TextView = itemView.findViewById(R.id.txtv_price)

            private var currentProduct: Product? = null

            init {
                itemView.setOnClickListener {
                    currentProduct?.let {
                        onClick(it)
                    }
                }
            }

        fun bind(product: Product) {
            currentProduct = product

            title.text = product.title ?: "No Title"
            brand.text = product.brand ?: "No Brand"
            price.text = product.price?.toString() ?: "0.0"

            Glide.with(itemView)
                .load(product.thumbnail)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .centerCrop()
                .into(thumbnail)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ProductViewHolder(view, onClick)
    }

    override fun onBindViewHolder(
        holder: ProductViewHolder,
        position: Int
    ) {
        val product = getItem(position)
        holder.bind(product)
    }

}

object ProductCallBack : DiffUtil.ItemCallback<Product>(){
    override fun areItemsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Product,
        newItem: Product
    ): Boolean {
        return oldItem == newItem
    }

}