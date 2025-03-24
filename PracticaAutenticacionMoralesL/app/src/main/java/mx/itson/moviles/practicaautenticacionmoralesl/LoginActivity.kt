package mx.itson.moviles.practicaautenticacionmoralesl

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        auth = Firebase.auth

        val email: EditText =findViewById(R.id.etEmail)
        val password: EditText =findViewById(R.id.etPassword)
        val errorTv: TextView =findViewById(R.id.tvError)
        val button: Button =findViewById(R.id.btnRegister)
        val buttonLogin: Button =findViewById(R.id.btnLogin)

        errorTv.visibility = View.INVISIBLE

        button.setOnClickListener({
            val intent=Intent(this,SignInActivity::class.java)
            startActivity(intent)
        })
        buttonLogin.setOnClickListener({
            login(email.text.toString(),password.text.toString())
        })
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun gotoMain(user: FirebaseUser){
        val intent=Intent(this,MainActivity::class.java)
        intent.putExtra("user",user.email)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    fun showError(text:String = "",visible:Boolean){
        val errorTv :TextView=findViewById(R.id.tvError)
        errorTv.text=text
        errorTv.visibility = if(visible) View.VISIBLE else View.INVISIBLE
    }

    public override fun onStart(){
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser!=null){
            gotoMain(currentUser)
        }
    }

    fun login(email:String,pass:String){
        auth.signInWithEmailAndPassword(email,pass).
                addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        val user = auth.currentUser
                        showError(visible = false)
                        gotoMain(user!!)
                    }else{
                        showError("Usuario y/o contraseña equivocados",true)
                    }
                }
    }
}