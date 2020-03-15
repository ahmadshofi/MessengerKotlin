package com.ahmad.messengerkotlin.message

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ahmad.messengerkotlin.R
import com.ahmad.messengerkotlin.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ChatLogActivity : AppCompatActivity() {

    companion object{
        val TAG = "Chat Log"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        val user = intent.getParcelableExtra<User>(NewMessagesActivity.USER_KEY)
        supportActionBar?.title = user.username


        setupDummyData()

        send_button_chat_log.setOnClickListener {
            Log.d(TAG,"Atttemp to send message...")

            performSendMessages()
        }

    }

    class ChatMessage(val id : String,val text: String,val fromId : String, val toId: String, val timestamp: Long)

    private fun performSendMessages() {
//        val text = edittext_chat_log.text.toString()
//        val fromId = FirebaseAuth.getInstance().uid
//        val usernam = intent.getStringExtra(NewMessagesActivity.USER_KEY)
//        val toId = usernam
//        val reference = FirebaseDatabase.getInstance().getReference("/messages").push()
//
//        val chatMessage = ChatMessage(reference.key,text,)
//        reference.setValue(chatMessage)
//            .addOnSuccessListener {
//                Log.d(TAG,"Saved our chat message: ${reference.key}")
//            }
    }

    private fun setupDummyData() {
        val adapter = GroupAdapter<ViewHolder>()

        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))
        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))
        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))
        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))
        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))
        adapter.add(ChatFromItem("FROM MESSAGEEEESSS"))
        adapter.add(ChatToItem("TO MESSSAGEE\n TOMESSSAAAAGEEE"))

        recyclerview_chat_log.adapter = adapter
    }
}

class ChatFromItem(val text: String): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textview_from_chat_log.text = text
    }
}

class ChatToItem(val text:String): Item<ViewHolder>(){
    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.textview_to_chat_log.text = text
    }
}
