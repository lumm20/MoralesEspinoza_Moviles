package mx.itson.moviles.practicaautenticacionmoralesl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignInActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        auth =Firebase.auth

        val email:EditText=findViewById(R.id.etEmail)
        val password:EditText=findViewById(R.id.etPassword)
        val confPass:EditText=findViewById(R.id.etConfirmPassword)
        val errorTv:TextView=findViewById(R.id.tvError)
        val button:Button=findViewById(R.id.btnRegister)

        errorTv.visibility= View.INVISIBLE

        button.setOnClickListener({
            if(email.text.isEmpty() || password.text.isEmpty() || confPass.text.isEmpty()){
                errorTv.text = "Todos los campos deben de ser llenados"
                errorTv.visibility = View.VISIBLE
            }else if(!password.text.toString().equals(confPass.text.toString())){
                errorTv.text = "Las contraseñas no coinciden"
                errorTv.visibility = View.VISIBLE
            }else{
                errorTv.visibility = View.INVISIBLE
                signIn(email.text.toString(),password.text.toString())
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun signIn(email:String,pass:String){
        Log.d("INFO","email: ${email}, password: ${pass}")
        auth.createUserWithEmailAndPassword(email,pass).
                addOnCompleteListener(this){task->
                    if(task.isSuccessful){
                        Log.d("INFO","signInWithEmail:success")
                        val user=auth.currentUser
                        val intent=Intent(this,MainActivity::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                    }else{
                        Log.w("ERROR","signInWithEmail:failure",task.exception)
                        Toast.makeText(
                            baseContext,
                            "El registro fallo",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
    }

}