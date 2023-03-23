package com.example.chat

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var binding: ActivityMainBinding? = null
    private val msgList = ArrayList<Msg>()
    private var adapter : MsgAdapter? = null
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding!!.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        binding!!.recycleView.layoutManager = layoutManager
         adapter = MsgAdapter(msgList)
        binding!!.recycleView.adapter = adapter
        binding!!.send.setOnClickListener(this)

    }
    override fun onClick(v : View)
    {
        when(v){
             binding?.send -> {
                 val content = binding!!.inputText.text.toString()
                 if(!content.isEmpty()){
                     val msg = Msg(content , Msg.TYPE_SENT)
                     msgList.add(msg)
                     adapter?.notifyItemInserted(msgList.size-1)
                     binding!!.recycleView.scrollToPosition(msgList.size-1)
                     binding!!.inputText.setText("")
                 }
            }
        }
    }
    private fun initMsg(){
        val msg1 = Msg("Hello guy",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello.Who is that ?",Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom.Nice to talking to you",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}