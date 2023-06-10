package com.github.jmir1.template.app

import android.nfc.Tag
import android.nfc.TagLostException
import android.nfc.tech.NfcV
import android.util.Log
import java.io.IOException

class NFCUtil {
    // function to read data from an NfcV tag
    fun readBarcode(tag: Tag): String {
        return try {
            val nfcvTag = NfcV.get(tag) ?: throw IOException("Could not get NfcV instance")
            nfcvTag.connect()
            val response = nfcvTag.transceive(
                byteArrayOf(
                    0x02.toByte(),  // FLAGS
                    0x23.toByte(),  // Read multiple blocks
                    0x00.toByte(),  // From block 0
                    0x03.toByte(),  // To block 2 (3 blocks)
                )
            )
            val success = response.firstOrNull() == 0x00.toByte()
            if (!success) return "Error: Command failed."

            val bar = response.slice(BARCODE_START..BARCODE_END).toByteArray()
            Log.i("NFCUtil", "response: ${bar.decodeToString()}, length: ${bar.size}")
            nfcvTag.close()
            bar.decodeToString()
        } catch (_: TagLostException) {
            "Error: Connection to tag was lost"
        } catch (e: IOException) {
            "Error: ${e.message}"
        }
    }
}

private const val BARCODE_START = 4
private const val BARCODE_END = 12
