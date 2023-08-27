package com.jacoblipsky.dev.dateroulette

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.jacoblipsky.dev.dateroulette.databinding.ActivityMainBinding
import com.jacoblipsky.dev.dateroulette.services.viewmodels.MainViewModel
import com.jacoblipsky.dev.dateroulette.utils.Util
import com.jacoblipsky.dev.dateroulette.utils.internet.InternetConnectivity
import com.jacoblipsky.dev.dateroulette.utils.internet.WifiReceiver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var wifiReceiver: WifiReceiver
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setUpObservers(this.findViewById(android.R.id.content)/*gets the content view*/)
        wifiReceiver = WifiReceiver()
        setUpView()
    }



    private fun setUpView(){
        
    }



    private fun setUpObservers(view: View){
        val snackBar: Snackbar =
            Snackbar.make(view, "Can't Connect To Web..", Snackbar.LENGTH_INDEFINITE)
                .setAction("GO TO SETTINGS") {
                    this@MainActivity?.let { it1 -> InternetConnectivity.connectToInternet(applicationContext) }
                }
        Util.hasInternet.observe(this) { it ->
            if (!it) {
                snackBar.show()
            } else {
                snackBar.dismiss()
            }
        }


    }

//    private fun setFragment(fragment: Fragment, num:Int, add:Boolean){
//        if(add){
//            viewModel.currentMainFragment = num
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.main_activity_fragment_container,fragment)
//                .addToBackStack(null)
//                .commit()
//        }else{
//            viewModel.currentMainFragment = num
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.main_activity_fragment_container,fragment)
//                .commit()
//        }
//
//    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(wifiReceiver, filter)
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiReceiver)
    }




//    private fun makeErrorDialog(num: Int){
//        val inflater = layoutInflater
//        val dialogView = inflater.inflate(R.layout.error_request_dalog, null)
//        val checkInternetButton = dialogView.findViewById(R.id.checkInternetButton) as Button
//        val yesButton = dialogView.findViewById(R.id.tryAgainButton) as Button
//
//        val alertDialog = AlertDialog.Builder(this@MainActivity)
//        alertDialog.setView(dialogView).setCancelable(true)
//
//        val dialog = alertDialog.create()
//        dialog.show()
//        errorDialogIsShowing = true
//
//        yesButton.setOnClickListener {
//            dialog.dismiss()
//            errorDialogIsShowing = false
//        }
//
//        checkInternetButton.setOnClickListener {
//            this@MainActivity.let { InternetConnectivity.connectToInternet(applicationContext) }
//        }
//    }

}