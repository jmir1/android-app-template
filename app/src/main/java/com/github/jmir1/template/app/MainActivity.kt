package com.github.jmir1.template.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import app.cash.quickjs.QuickJs
import app.cash.quickjs.QuickJsException
import com.github.jmir1.template.app.databinding.ActivityMainBinding
import com.github.jmir1.template.library.android.ToastUtil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val engine = QuickJs.create()

        binding.buttonCompute.setOnClickListener {
            val message = if (binding.editTextFactorial.text.isNotEmpty()) {
                val input = binding.editTextFactorial.text.toString()
                val result = try {
                    engine.evaluate(
                        """
                            console.log('Hello');
                            globalThis.result = { getValue: () => { return '$input'; } };
                            """.trimIndent()
                    )
                    engine.get("result", TestInterface::class.java).getValue()
                } catch (ex: QuickJsException) {
                    "Error: ${ex.message}"
                }

                binding.textResult.text = result
                binding.textResult.visibility = View.VISIBLE
                getString(R.string.notification_title, result)
            } else {
                getString(R.string.please_enter_a_number)
            }
            ToastUtil.showToast(this, message)
        }

        binding.buttonAppcompose.setOnClickListener {
            val intent = Intent(it.context, ComposeActivity::class.java)
            startActivity(intent)
        }
    }

    private interface TestInterface {
        fun getValue(): String
    }
}
