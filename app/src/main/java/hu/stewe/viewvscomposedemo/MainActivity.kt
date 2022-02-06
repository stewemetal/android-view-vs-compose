package hu.stewemetal.viewvscomposedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hu.stewemetal.viewvscomposedemo.ui.compose.ComposeFragment
import hu.stewemetal.viewvscomposedemo.ui.view.ViewFragment

class MainActivity : AppCompatActivity() {

    // Don't do this in production! Use e.g. a ViewModel instead!
    // This is just a shortcut for a simple demo implementation.
    private var isComposeImplementationShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.contentFrame, ViewFragment())
            .commit()

        findViewById<FloatingActionButton>(R.id.implementationSwitcherFab)
            .apply {
                setOnClickListener {
                    isComposeImplementationShown = !isComposeImplementationShown
                    if(isComposeImplementationShown) {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.contentFrame, ComposeFragment())
                            .commit()
                    } else {
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.contentFrame, ViewFragment())
                            .commit()
                    }
                }
            }
    }
}
