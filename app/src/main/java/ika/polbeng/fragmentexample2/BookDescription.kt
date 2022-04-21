package ika.polbeng.fragmentexample1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ika.polbeng.fragmentexample2.R
import kotlinx.android.synthetic.main.book_description.*

class BookDescription : Fragment() {
    lateinit var arrbookdesc: Array<String>
    var bookindex = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arrbookdesc = resources.getStringArray(R.array.bookdescriptions)
        bookindex = if(savedInstanceState?.getInt("bookindex") == null) 0
        else { savedInstanceState.getInt("bookindex")}
        return inflater.inflate(R.layout.book_description, container, false)
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("bookindex", bookindex)
    }
    fun changeDescription(index: Int): Unit {
        bookindex = index
        println("BOOK INDEX = $bookindex")
        txtdescription?.setText(arrbookdesc[bookindex])
        println(arrbookdesc[bookindex])
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeDescription(bookindex)
    }
}