package ika.polbeng.fragmentexample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ika.polbeng.fragmentexample1.BookDescription
import ika.polbeng.fragmentexample1.BookTitle
import ika.polbeng.fragmentexample1.Coordinator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Coordinator {
    lateinit var fragBookDescription: BookDescription
    lateinit var fragBookTitle: BookTitle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragBookTitle = BookTitle()
        fragBookDescription = BookDescription()
        val fragTransaction = supportFragmentManager.beginTransaction()
        fragTransaction.add(R.id.fragtop, fragBookTitle)
        fragTransaction.add(R.id.fragbottom, fragBookDescription)
        fragTransaction.commit()
    }
    override fun onBookChanged(index:Int) {
        fragBookDescription.changeDescription(index)

    }

}