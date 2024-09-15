package com.example.foodattip

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.runtime.LaunchedEffect
import android.Manifest
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.foodattip.ui.theme.FoodAtTipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodAtTipTheme {
                val launcher = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission(),
                    onResult = { isGranted ->
                        if (isGranted) {

                        } else {
                            Toast.makeText(
                                this,
                                "Camera permission is required.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )

                LaunchedEffect(Unit) {
                    launcher.launch(Manifest.permission.CAMERA)
                }
            MainNav()

            }

        }
    }
}


@Composable
fun QRCodeScannerScreen() {
    var scannedCode by remember { mutableStateOf<String?>(null) }

    QRCodeScanner { qrCode ->
        scannedCode = qrCode
        // Handle the scanned QR code here
        Log.d("QRCodeScanner", "Scanned QR Code: $qrCode")
    }

    scannedCode?.let {
        Text(text = "Scanned QR Code: $it", modifier = Modifier.padding(16.dp))
    }
}

