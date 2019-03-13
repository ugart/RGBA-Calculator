package com.example.rgbacalculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.InputType
import android.text.SpannableStringBuilder
import android.text.TextWatcher
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    //---------------------------------------- Variáveis de controle da seekbar -------------------------------\\

    val seekbar1ChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            editText1.text = SpannableStringBuilder(p1.toString())
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }

    val seekbar2ChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            editText2.text = SpannableStringBuilder(p1.toString())
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }

    val seekbar3ChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            editText3.text = SpannableStringBuilder(p1.toString())
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }

    val seekbar4ChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            editText4.text = SpannableStringBuilder(p1.toString())
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }

    //---------------------------------------- Começo da manipulação da activity -------------------------------\\

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //associando o layout criado à activity
        button_type.text = "Decimal"
        writingDecNumber()
        writingHexNumber()
        seekingEditTextNumber()

        button_type.setOnClickListener {
            buttonClick()
        }


    }

    fun writingHexNumber() {
        editText_hex.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0.toString().replace("#", "")

                try {
                    if (!p0.isNullOrEmpty()) {
                        color_show_space.setBackgroundColor(Color.parseColor(p0.toString()))
                    }
                } catch (e: Exception) {

                }

            }

        })
    }

    fun writingDecNumber() {

        editText1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (!p0.isNullOrEmpty()) {

                    seekBar.setOnSeekBarChangeListener(null) //anulando o listener da seekbar enquanto escrevo no edittext
                    seekBar.progress = p0.toString().toInt() //recebendo no progress da seekbar o valor digitado no edittext
                    seekBar.setOnSeekBarChangeListener(seekbar1ChangeListener) //ativando o listener da seekbar novamente
                    color_show_space.setBackgroundColor(Color.argb(seekBar4.progress, seekBar.progress, seekBar2.progress, seekBar3.progress))
                }

            }
        })

        editText2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (!p0.isNullOrEmpty()) {

                    seekBar2.setOnSeekBarChangeListener(null)
                    seekBar2.progress = p0.toString().toInt()
                    seekBar2.setOnSeekBarChangeListener(seekbar2ChangeListener)
                    color_show_space.setBackgroundColor(Color.argb(seekBar4.progress, seekBar.progress, seekBar2.progress, seekBar3.progress))
                }

            }
        })

        editText3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (!p0.isNullOrEmpty()) {

                    seekBar3.setOnSeekBarChangeListener(null)
                    seekBar3.progress = p0.toString().toInt()
                    seekBar3.setOnSeekBarChangeListener(seekbar3ChangeListener)
                    color_show_space.setBackgroundColor(Color.argb(seekBar4.progress, seekBar.progress, seekBar2.progress, seekBar3.progress))
                }

            }
        })

        editText4.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if (!p0.isNullOrEmpty()) {

                    seekBar4.setOnSeekBarChangeListener(null)
                    seekBar4.progress = p0.toString().toInt()
                    seekBar4.setOnSeekBarChangeListener(seekbar4ChangeListener)
                    color_show_space.setBackgroundColor(Color.argb(seekBar4.progress, seekBar.progress, seekBar2.progress, seekBar3.progress))
                }

            }
        })
    }

    //---------------------------------------- Associando seekbar com editText -------------------------------\\

    fun seekingEditTextNumber() {

        seekBar.setOnSeekBarChangeListener(seekbar1ChangeListener)

        seekBar2.setOnSeekBarChangeListener(seekbar2ChangeListener)

        seekBar3.setOnSeekBarChangeListener(seekbar3ChangeListener)

        seekBar4.setOnSeekBarChangeListener(seekbar4ChangeListener)
    }

    //---------------------------------------- Convertendo as cores de Decimal para RGBA -------------------------------\\
    fun decimalToRGBA() {
//        Color.argb()
    }

    //---------------------------------------- Convertendo as cores de Hexadecimal para RGBA -------------------------------\\


    //---------------------------------------- Para mostrar as cores na tela -------------------------------\\
    fun showColor() {

    }

    //---------------------------------------- Populando o spinner com os tipos de cores -------------------------------\\
    fun showHide(view: View) {
        view.visibility = if (view.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

    fun buttonClick() {
        if (button_type.text == "Decimal") {
            showHide(constraintLayout_dec)
            showHide(constraintLayout_hex)
            button_type.text = "Hexadecimal"
            button_type.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        } else {
            showHide(constraintLayout_hex)
            showHide(constraintLayout_dec)
            button_type.text = "Decimal"
        }
    }

}
