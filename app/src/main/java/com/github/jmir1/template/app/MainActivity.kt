package com.github.jmir1.template.app

import android.nfc.NfcAdapter
import android.nfc.cardemulation.HostApduService
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.jmir1.template.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NfcAdapter.getDefaultAdapter(this)
            .enableReaderMode(
                this,
                { tag ->
                    val nfcUtil = NFCUtil()
                    val result = nfcUtil.readBarcode(tag)
                    runOnUiThread { binding.textResult.text = result }
                },
                NfcAdapter.FLAG_READER_NFC_V or NfcAdapter.FLAG_READER_SKIP_NDEF_CHECK,
                null,
            )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var counter = 0

        binding.buttonCompute.setOnClickListener {
            counter++
            binding.textResult.text = counter.toString()
        }
    }
}
