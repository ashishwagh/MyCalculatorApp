package com.example.ashis.mycalculatorapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener,GoogleApiClient.OnConnectionFailedListener{

    private static EditText email;
    private static EditText password;
    private static Button login_button;
    private static LoginButton fb_login_button;
    CallbackManager callbackManager;

    private static SignInButton signInButton;
    GoogleApiClient googleApiInClient;
    private static final int REQ_CODE=9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login_activity);

        email = (EditText) findViewById(R.id.emailId);
        password =(EditText) findViewById(R.id.passwordId);
        login_button =(Button) findViewById(R.id.button_login);
        callbackManager = CallbackManager.Factory.create();
        fb_login_button =(LoginButton) findViewById(R.id.fb_login_button);

        signInButton = (SignInButton)findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);
        GoogleSignInOptions signInOptions=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiInClient = new GoogleApiClient.Builder(this).enableAutoManage(this,this).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();


       LoginMethod();
       LoginWithFB();
    }


    /**
     Method for Login with facebook account
      **/

    private void LoginWithFB() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Toast.makeText(LoginActivity.this,"Email and Password are correct.",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(".CalculateActivity");
                startActivity(i);
            }

            @Override
            public void onCancel() {
                Toast.makeText(LoginActivity.this,"Login cancelled.",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                Toast.makeText(LoginActivity.this,"Login Error.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQ_CODE){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }

    }

    /**
     * Method for login using the credentials
     */
    private void LoginMethod() {
       login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("test") && password.getText().toString().equals("123")){
                    Toast.makeText(LoginActivity.this,"Email and Password are correct.",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(".CalculateActivity");
                    startActivity(i);
                }else{
                    Toast.makeText(LoginActivity.this,"Invalid Email and Password.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public void onClick(View view) {
        signIn();
    }

    /**
     * Method for connection handling google sign failure
     * @param connectionResult
     */
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(LoginActivity.this,"Login Failed.",Toast.LENGTH_SHORT).show();
    }

    /**
     * Method for signing in using google account
     */
    private void signIn(){
        Intent intent=Auth.GoogleSignInApi.getSignInIntent(googleApiInClient);
        startActivityForResult(intent,REQ_CODE);
    }

    /**
     * Method for sign out from google account
     */
    private void signOut(){
        Auth.GoogleSignInApi.signOut(googleApiInClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                Toast.makeText(LoginActivity.this,"Sign Out.",Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method for handling the signIn request result
     * @param result
     */
    private void handleResult(GoogleSignInResult result){
        if(result.isSuccess()){
            //GoogleSignInAccount account=result.getSignInAccount();
            Toast.makeText(LoginActivity.this,"Email and Password are correct.",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(".CalculateActivity");
            startActivity(i);
        }
    }
}
