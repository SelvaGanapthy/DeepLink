package com.example.deeplink


import android.Manifest
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
import androidx.core.app.ActivityCompat
import android.content.pm.PackageManager
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var uri: Uri? = null
    val REQUEST_CODE_PERMISSIONS = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        uri = intent.data
//        if (uri != null) {
//            var params: List<String> = uri?.pathSegments as List<String>
//            var id: String = params[params.size - 1]
//            Toast.makeText(this@MainActivity, "" + id, Toast.LENGTH_SHORT).show()
//
//        }
    }

    fun LocationAccess(v:View)
    {
        requestLocationPermission()
    }


    private fun requestLocationPermission() {

        val foreground = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (foreground) {
            val background = ActivityCompat.checkSelfPermission(this, ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

            if (background) {
                handleLocationUpdates()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                    REQUEST_CODE_PERMISSIONS
                )
            }
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                ), REQUEST_CODE_PERMISSIONS
            )
        }
    }


    private fun handleLocationUpdates() {
        //foreground and background
        Toast.makeText(applicationContext, "Start Foreground and Background Location Updates", Toast.LENGTH_SHORT).show()
    }

    private fun handleForegroundLocationUpdates() {
        //handleForeground Location Updates
        Toast.makeText(applicationContext, "Start foreground location updates", Toast.LENGTH_SHORT).show()
    }
}
