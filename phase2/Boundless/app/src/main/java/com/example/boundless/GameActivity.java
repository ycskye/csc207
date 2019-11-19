package com.example.boundless;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.boundless.games.BusinessContext;
import com.example.boundless.games.GamesEnum;
import com.example.boundless.games.Game;
import com.example.boundless.users.UserAccountManager;
import com.example.boundless.utilities.HandleCustomization;

import java.util.Observable;
import java.util.Observer;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class GameActivity extends Activity implements Observer {

    private Panel panel;
    private GamesEnum currentGame;
    private int level = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("GameActivity", "oh no it's creating again, why don't you just resume, ugh");
        if(savedInstanceState==null)

            Log.d("GameActivity", "no saved instance state");
    }

    @Override
    protected void onStart(){

            super.onStart();


            Log.d("GameActivity", "onStart is running  before resume");
            setupGame();

    }

    /**
     * Sets up the game
     */
    private void setupGame() {
        setCurrentGame();
        HandleCustomization.setGameBackground(this, findViewById(R.id.ConstraintLayout));
        HandleCustomization.startMusic(this);
    }

    /**
     * Sets up the views for the current game.
     */
    private void setCurrentGame() {
        currentGame = (GamesEnum) getIntent().getSerializableExtra(IntentExtras.gameEnum);
        int level = 0;
        if (BusinessContext.needsLevels(currentGame))
            level = (int) getIntent().getSerializableExtra(IntentExtras.levelNumber);
        Log.d("GameActivity","setting current game");
        if (currentGame != null) {
            Log.d("GameActivity","current game is not null");
            setContentView(R.layout.game_page);
            panel = findViewById(R.id.panel);
            panel.chooseGame(currentGame, level);
            Log.d("GameActivity", "Changing to currentGame: " + currentGame);
        } else {
            Log.e("GameActivity", "An error occurred trying to get the currentGame chosen.");
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        Game currentGame = panel.getGame();
        currentGame.addObserver(this);
        if (level < 1)
            currentGame.showInstructions();
    }

    @Override
    protected void onPause() {
        super.onPause();
        HandleCustomization.pauseMusic(this);
    }

    public void pauseButtonPressed(View view) {
        this.onPause();
        Intent intent = new Intent(this, PauseMenuActivity.class);
        intent.putExtra(IntentExtras.gameEnum, currentGame);
        intent.putExtra(IntentExtras.levelNumber,level );
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        panel.resume();
        HandleCustomization.startMusic(this);
        Log.d("GameActivity", "onResume()!!!");
    }

    /**
     * Show an overlay with info from the game
     *
     * @param text The text to show on the overlay
     */
    private void showOverlay(String text, final boolean gameIsOver) {
        panel.pause();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(text).setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (gameIsOver) onBackPressed();
                        else panel.resume();
                    }
                })
                .setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        onBackPressed();
                    }
                });
        builder.create().show();
    }

    @Override
    public void update(Observable observable, final Object o) {
        if (panel.isGameOver() && UserAccountManager.currentUser.getUnlocked(currentGame) == level)
            UserAccountManager.currentUser.addUnlocked(currentGame);
        try {
            runOnUiThread(new Runnable() {
                public void run() {
                    showOverlay((String) o, panel.isGameOver());
                }
            });
        } catch (ClassCastException e) {
            Log.e("GameActivity", "The observer needs a string to show an alert!");
        }
    }

    /**
     * Override hardware back button to go to main activity or level activity
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MenuActivity.class);
        if (BusinessContext.needsLevels(currentGame)) {
            intent = new Intent(this, LevelActivity.class);
            if (BusinessContext.isInstructions(currentGame))
                intent.putExtra(IntentExtras.gameEnum, BusinessContext.getRegularLevel(currentGame));
            else intent.putExtra(IntentExtras.gameEnum, currentGame);
        }
        HandleCustomization.startMusic(this);
        startActivity(intent);
    }
}
