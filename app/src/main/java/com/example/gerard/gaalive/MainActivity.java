package com.example.gerard.gaalive;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.gerard.gaalive.adapter.MatchAdapter;
import com.example.gerard.gaalive.viewmodel.MainActivityViewModel;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MatchAdapter.OnMatchSelectedListener {


    private static final String TAG = "MainActivity";
    private static final int RC_SIGN_IN = 9001;
    //@BindView(R.id.match_list)
    //RecyclerView mMatchRecycler;
    private FirebaseFirestore mFirestore;
    private Query mQuery;
    private MatchAdapter mAdapter;


    private MainActivityViewModel mViewModel;
    private static final int LIMIT = 50;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mViewModel= ViewModelProviders.of(this).get(MainActivityViewModel.class);

        // Enable Firestore logging
        FirebaseFirestore.setLoggingEnabled(true);

        // Initialize Firestore and the main RecyclerView

    }




    @Override
    protected void onStart() {
        super.onStart();

        // Start sign in if necessary
        if (shouldStartSignIn()) {
            startSignIn();
            return;
        }
            if (mAdapter != null) {
                mAdapter.startListening();
            }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }

        private boolean shouldStartSignIn() {
            return (!mViewModel.getIsSigningIn() && FirebaseAuth.getInstance().getCurrentUser() == null);
        }
    private void startSignIn() {
        // Sign in with FirebaseUI
        Intent intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(Collections.singletonList(
                        new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build()))
                .setIsSmartLockEnabled(false)
                .build();

        startActivityForResult(intent, RC_SIGN_IN);
        mViewModel.setIsSigningIn(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sign_out:
                AuthUI.getInstance().signOut(this);
                startSignIn();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            mViewModel.setIsSigningIn(false);

            if (resultCode != RESULT_OK && shouldStartSignIn()) {
                startSignIn();
            }
        }
    }

    @Override
    public void onMatchSelected(DocumentSnapshot match) {

        // Go to the details page for the selected restaurant
        Intent intent = new Intent(this, MatchDetailActivity.class);
        intent.putExtra(MatchDetailActivity.KEY_RESTAURANT_ID, match.getId());

        startActivity(intent);

    }
    private void showTodoToast() {
        Toast.makeText(this, "TODO: Implement", Toast.LENGTH_SHORT).show();
    }



}
