package com.stn.anonymoussns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {
    // 로그에 TAG 로 사용할 문자열
    val TAG = "MainActivity"

    // 파이어 베이스의 test 키를 가진 데이터의 참조 객체를 가져옴
    val ref = FirebaseDatabase.getInstance().getReference("test")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 값의 변경이 있는 경우의 이벤트 리스너를 추가
        ref.addValueEventListener(object: ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                error.toException().printStackTrace()
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                // test 키를 가진 데이터 스냅샷에서 값을 읽고 문자열로 변경
                val message = snapshot.value.toString()
                // 읽은 문자열을 로깅
                Log.d(TAG, message)
                // Firebase 에서 전달받은 메세지로 제목을 변경
                supportActionBar?.title = message
            }
        })
    }
}
