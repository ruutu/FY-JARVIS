package com.plgpl.jarvis.services


import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class TextToSpeechService(context: Context, private val message: String) : TextToSpeech.OnInitListener {

    private val tts: TextToSpeech = TextToSpeech(context, this)

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {


            val result = tts.setLanguage(Locale.US)

            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS","The Language specified is not supported!")
            }

            reprodueixSo(message)

        } else {
            Log.e("TTS", "Initilization Failed!")
        }
    }

     private fun reprodueixSo(missatge: String){
        tts.speak(missatge, TextToSpeech.QUEUE_FLUSH, null,"")
    }
}
