package dev.sanskar.words

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val words = mutableListOf(
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Rajat",
        "Aman",
        "Aman",
        "Aman",
        "Aman",
        "Aman",
        "Aman",
        "Aman",
        "Anurag",
        "Anurag",
        "Anurag",
        "Anurag",
        "Anurag",
        "Anurag",
        "Saurabh",
        "Saurabh",
        "Saurabh",
        "Saurabh",
        "Saurabh",
        "Nishant"
    )

    val adapter = WordAdapter(words)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = adapter
        val fabAddWord = findViewById<FloatingActionButton>(R.id.fab_add_word)
        fabAddWord.setOnClickListener {
            // Intents
            val intent = Intent(this, AddWordActivity::class.java)
            startActivityForResult(intent, 10)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 10) {
            if (resultCode == RESULT_OK) {
                val text = data?.getStringExtra("WORD")
                words.add(text!!)
                adapter.notifyDataSetChanged()
            }
        }
    }

    /**
     * 1. Layout - Single Item
     * 2. Adapter
     * 3. Layout - RecyclerView in Activity
     */
}

class WordAdapter(val words: List<String>) : RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<TextView>(R.id.textView_word)
    }

    /**
     * Creates a viewholder
     * Inflates the item layout, wraps in into ViewHolder, and returns
     * RecyclerView recycles ViewHolders
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d("RecyclerView", "onCreateViewHolder: ViewHolder created")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_word_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    /**
     * Data attachment
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = words[position]

        Log.d("RecyclerView", "onBindViewHolder for position $position")
    }

    override fun getItemCount(): Int {
        return words.size
    }
}