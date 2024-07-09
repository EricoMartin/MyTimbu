package com.basebox.mytimbu

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.basebox.mytimbu.databinding.ActivityMainBinding
import com.basebox.mytimbu.ui.ProductAdapter
import com.basebox.mytimbu.ui.ProductViewModel

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding
    private val binding get() = _binding
    private val viewModel: ProductViewModel by viewModels()

    private val organizationId: String = "67102ab35e7742088683036c5e8a368d"
    private val appId: String = "MZ2HN5PMS725RMD"
    private val apiKey: String = "1acfe466531340f79358fed1c54fe60620240708072804259309"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(_binding.root)

        val recyclerView: RecyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.products.observe(this, Observer { products ->
            recyclerView.adapter = ProductAdapter(products)
            Log.d(TAG, "onCreate: ${listOf(products)}")
        })
        viewModel.error.observe(this, Observer { error ->
            Toast.makeText(this, "Error fetching data: $error", Toast.LENGTH_LONG).show()
            Log.d(TAG, "onCreate Error: $error ")
        })
        Log.d(TAG, "onCreate: ${viewModel.fetchProducts(organizationId, appId, apiKey)}")
        viewModel.fetchProducts(organizationId, appId, apiKey)
    }
}