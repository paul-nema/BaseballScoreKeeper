package com.example.android.baseballscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Team Class definition.
 */
class Team {
    private int score = 0;  // score of team

    private int outs = 0;   // outs of team

    private boolean atBat = false;  // is this team at bat


    /**
     * Add score to this team.
     */
    public void addScore(int add_score) {
        score += add_score;
    }

    /**
     * Add outs to this team.
     */
    public void addOuts(int add_outs) {
        outs += add_outs;
    }

    /**
     * Get the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the score to this team.
     */
    public void setScore(int set_outs) {
        score = set_outs;
    }

    /**
     * Get the outs.
     */
    public int getOuts() {
        return outs;
    }

    /**
     * Set the outs to this team.
     */
    public void setOuts(int set_outs) {
        outs = set_outs;
    }

    /**
     * Return if at bat or not.
     */
    public boolean isAtBat() {
        return atBat;
    }

    /**
     * Set that this team is at bat or not.
     */
    public void setAtBat(boolean batting) {
        atBat = batting;
    }

    /**
     * Reinitialize the team.
     */
    public void reset() {
        score = 0;
        outs = 0;
        atBat = false;
    }

    /**
     * Change at bat status.
     */
    public void switchAtBat(boolean switchBatting) {
        atBat = !atBat;
    }
}


public class MainActivity extends AppCompatActivity {
    int runsToAddTeamA = 0; // incremental runs for team A
    int runsToAddTeamB = 0; // incremental runs for team B
    int outsTeamA = 0;  // incremental outs for team A
    int outsTeamB = 0;  // incremental outs for team B

    Team teamA = null;  // Pointer to team A
    Team teamB = null;  // Pointer to team B

    /**
     * Initialize the app
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset();
    }

    /**
     * Start a new game.
     */
    public void reset() {
        teamA = new Team();
        teamB = new Team();

        displayScoreForTeamA(teamA.getScore());
        displayOutsForTeamA(teamA.getOuts());
    }

    /**
     * Displays the number of homeruns to add to team A.
     */
    public void displayHomerunsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.text_homeruns_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of homeruns to add to team B.
     */
    public void displayHomerunsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.text_homeruns_team_b);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays score of team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays score of team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the outs for team A.
     */
    public void displayOutsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_outs);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the outs for team B.
     */
    public void displayOutsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_outs);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Displays the number of outs to add to team A.
     */
    public void displayOutsTotalForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.text_outs_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of outs to add to team B.
     */
    public void displayOutsTotalForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.text_outs_team_b);
        scoreView.setText(String.valueOf(score));
    }


    /**
     * Add runs from this inning to team A.
     */
    public void addRunsTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        teamA.addScore(runsToAddTeamA);

        displayScoreForTeamA(teamA.getScore());
    }

    /**
     * Add runs from this inning to team B.
     */
    public void addRunsTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        teamB.addScore(runsToAddTeamB);

        displayScoreForTeamB(teamB.getScore());
    }


    /**
     * Add one to the increament score of team A.
     */
    public void incrementScoreTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        runsToAddTeamA++;

        displayHomerunsForTeamA(runsToAddTeamA);
    }

    /**
     * Minuses one to the increament score of team A.
     */
    public void decrementScoreTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        runsToAddTeamA--;

        if (runsToAddTeamA < 0) {
            runsToAddTeamA++;
        }

        displayHomerunsForTeamA(runsToAddTeamA);
    }

    /**
     * Add one to the increament score of team B.
     */
    public void incrementScoreTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        runsToAddTeamB++;

        displayHomerunsForTeamB(runsToAddTeamB);
    }

    /**
     * Minuses one to the increament score of team B.
     */
    public void decrementScoreTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        runsToAddTeamB--;

        if (runsToAddTeamB < 0) {
            runsToAddTeamB++;
        }

        displayHomerunsForTeamB(runsToAddTeamB);
    }

    /**
     * Add one to the increament outs of team A.
     */
    public void incrementOutsTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        outsTeamA++;

        if (outsTeamA > 4) {
            outsTeamA--;
        }

        displayOutsTotalForTeamA(outsTeamA);
    }

    /**
     * Minuses one to the increament outs of team A.
     */
    public void decrementOutsTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        outsTeamA--;

        if (outsTeamA < 0) {
            outsTeamA++;
        }

        displayOutsTotalForTeamA(outsTeamA);
    }

    /**
     * Add one to the increament outs of team B.
     */
    public void incrementOutsTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        outsTeamB++;

        if (outsTeamB > 4) {
            outsTeamA--;
        }

        displayOutsTotalForTeamB(outsTeamB);
    }

    /**
     * Minuses one to the increament outs of team B.
     */
    public void decrementOutsTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        outsTeamB--;

        if (outsTeamB < 0) {
            outsTeamB++;
        }

        displayOutsTotalForTeamB(outsTeamB);
    }


    /**
     * Add outs from incremental value to team A.
     */
    public void addOutsTeamA(View v) {
        if (!teamA.isAtBat()) {
            return;
        }

        teamA.addOuts(outsTeamA);

        if (teamA.getOuts() > 2) {
            teamA.setAtBat(false);
            teamB.setAtBat(true);

            teamA.setOuts(0);

            outsTeamA = 0;

            runsToAddTeamA = 0;
            displayHomerunsForTeamA(runsToAddTeamA);
        }

        displayOutsForTeamA(teamA.getOuts());
        displayOutsTotalForTeamA(outsTeamA);
    }

    /**
     * Add outs from incremental value to team B.
     */
    public void addOutsTeamB(View v) {
        if (!teamB.isAtBat()) {
            return;
        }

        teamB.addOuts(outsTeamB);

        if (teamB.getOuts() > 2) {
            teamB.setAtBat(false);
            teamA.setAtBat(true);

            teamB.setOuts(0);

            outsTeamB = 0;

            runsToAddTeamB = 0;
            displayHomerunsForTeamB(runsToAddTeamB);
        }

        displayOutsForTeamB(teamB.getOuts());
        displayOutsTotalForTeamB(outsTeamB);
    }


    /**
     * Team A is at bat.
     */
    public void battingTeamA(View v) {
        teamA.setAtBat(true);

        teamB.setOuts(0);
        displayOutsForTeamB(teamB.getOuts());

        outsTeamB = 0;
        displayOutsTotalForTeamB(outsTeamB);

        runsToAddTeamB = 0;
        displayHomerunsForTeamB(runsToAddTeamB);
    }

    /**
     * Team B is at bat.
     */
    public void battingTeamB(View v) {
        teamB.setAtBat(true);

        teamA.setOuts(0);
        displayOutsForTeamA(teamA.getOuts());

        outsTeamA = 0;
        displayOutsTotalForTeamA(outsTeamA);

        runsToAddTeamA = 0;
        displayHomerunsForTeamA(runsToAddTeamA);
    }
}