package com.novembergave.apps.tictacnyan;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static final String USER_CLICKED = "userClicked";
    static final String VIEW_ONE = "vOne";
    static final String VIEW_TWO = "vTwo";
    static final String VIEW_THREE = "vThree";
    static final String VIEW_FOUR = "vFour";
    static final String VIEW_FIVE = "vFive";
    static final String VIEW_SIX = "vSix";
    static final String VIEW_SEVEN = "vSeven";
    static final String VIEW_EIGHT = "vEight";
    static final String VIEW_NINE = "vNine";
    static final String OPP_ONE = "oOne";
    static final String OPP_TWO = "oTwo";
    static final String OPP_THREE = "oThree";
    static final String OPP_FOUR = "oFour";
    static final String OPP_FIVE = "oFive";
    static final String OPP_SIX = "oSix";
    static final String OPP_SEVEN = "oSeven";
    static final String OPP_EIGHT = "oEight";
    static final String OPP_NINE = "oNine";
    static final String GAME_STATUS = "gameStatus";
    static final String POSITION_LIST = "viewList";
    static final String GAME_RESULT = "gameResult";
    static final int WIN = 1;
    static final int LOSE = 2;
    static final int DRAW = 3;
    ImageView oneOne;
    ImageView oneTwo;
    ImageView oneThree;
    ImageView twoOne;
    ImageView twoTwo;
    ImageView twoThree;
    ImageView threeOne;
    ImageView threeTwo;
    ImageView threeThree;
    TextView resultTv;
    TextView gameNameTv;
    TextView ngTv;
    Boolean userClicked = false;
    Boolean vOne = false;
    Boolean vTwo = false;
    Boolean vThree = false;
    Boolean vFour = false;
    Boolean vFive = false;
    Boolean vSix = false;
    Boolean vSeven = false;
    Boolean vEight = false;
    Boolean vNine = false;
    Boolean oOne = false;
    Boolean oTwo = false;
    Boolean oThree = false;
    Boolean oFour = false;
    Boolean oFive = false;
    Boolean oSix = false;
    Boolean oSeven = false;
    Boolean oEight = false;
    Boolean oNine = false;
    Boolean gameStatus = true;
    int numberOfViews = 9;
    int whichView;
    int gameResult = 0;
    List<Integer> viewList;
    ArrayList<Integer> loadedList;
    private View.OnClickListener restart = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            resultTv.setVisibility(View.GONE);
            oneOne.setImageDrawable(null);
            oneTwo.setImageDrawable(null);
            oneThree.setImageDrawable(null);
            twoOne.setImageDrawable(null);
            twoTwo.setImageDrawable(null);
            twoThree.setImageDrawable(null);
            threeOne.setImageDrawable(null);
            threeTwo.setImageDrawable(null);
            threeThree.setImageDrawable(null);
            vOne = false;
            vTwo = false;
            vThree = false;
            vFour = false;
            vFive = false;
            vSix = false;
            vSeven = false;
            vEight = false;
            vNine = false;
            oOne = false;
            oTwo = false;
            oThree = false;
            oFour = false;
            oFive = false;
            oSix = false;
            oSeven = false;
            oEight = false;
            oNine = false;
            userClicked = false;
            gameStatus = true;
            viewList.clear();

            Log.e("restart", String.valueOf(viewList.size()));

            createList();

            Log.d("restart", String.valueOf(viewList.size()));

        }
    };
    private View.OnClickListener setNyan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!userClicked) {
                ImageView imageView = (ImageView) view;
                if (imageView.getDrawable() == null) {
                    imageView.setImageResource(R.drawable.nyanone);
                    userClicked = true;
                    switch (view.getId()) {
                        case R.id.one_one:
                            whichView = viewList.indexOf(1);
                            vOne = true;
                            break;
                        case R.id.one_two:
                            whichView = viewList.indexOf(2);
                            vTwo = true;
                            break;
                        case R.id.one_three:
                            whichView = viewList.indexOf(3);
                            vThree = true;
                            break;
                        case R.id.two_one:
                            whichView = viewList.indexOf(4);
                            vFour = true;
                            break;
                        case R.id.two_two:
                            whichView = viewList.indexOf(5);
                            vFive = true;
                            break;
                        case R.id.two_three:
                            whichView = viewList.indexOf(6);
                            vSix = true;
                            break;
                        case R.id.three_one:
                            whichView = viewList.indexOf(7);
                            vSeven = true;
                            break;
                        case R.id.three_two:
                            whichView = viewList.indexOf(8);
                            vEight = true;
                            break;
                        case R.id.three_three:
                            whichView = viewList.indexOf(9);
                            vNine = true;
                            break;
                    }

                    Log.e("whichView value", String.valueOf(whichView));

                    Log.d("before remove whichView", String.valueOf(viewList.size()));

                    viewList.remove(whichView);

                    Log.d("remove whichView", String.valueOf(viewList.size()));

                    checkIfWin();

                    if (resultTv.getVisibility() == View.GONE) {
                        generatePCMoves();
                    }
                }


            }


        }
    };

    private View.OnClickListener openWeb = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url)));
            startActivity(browserIntent);
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(VIEW_ONE, vOne);
        outState.putBoolean(VIEW_TWO, vTwo);
        outState.putBoolean(VIEW_THREE, vThree);
        outState.putBoolean(VIEW_FOUR, vFour);
        outState.putBoolean(VIEW_FIVE, vFive);
        outState.putBoolean(VIEW_SIX, vSix);
        outState.putBoolean(VIEW_SEVEN, vSeven);
        outState.putBoolean(VIEW_EIGHT, vEight);
        outState.putBoolean(VIEW_NINE, vNine);
        outState.putBoolean(OPP_ONE, oOne);
        outState.putBoolean(OPP_TWO, oTwo);
        outState.putBoolean(OPP_THREE, oThree);
        outState.putBoolean(OPP_FOUR, oFour);
        outState.putBoolean(OPP_FIVE, oFive);
        outState.putBoolean(OPP_SIX, oSix);
        outState.putBoolean(OPP_SEVEN, oSeven);
        outState.putBoolean(OPP_EIGHT, oEight);
        outState.putBoolean(OPP_NINE, oNine);
        outState.putBoolean(USER_CLICKED, userClicked);
        outState.putBoolean(GAME_STATUS, gameStatus);
        loadedList = new ArrayList<>(viewList);
        outState.putIntegerArrayList(POSITION_LIST, loadedList);
        Log.e("savedInstanceState", String.valueOf(loadedList.size()));
        outState.putInt(GAME_RESULT, gameResult);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        vOne = savedInstanceState.getBoolean(VIEW_ONE);
        vTwo = savedInstanceState.getBoolean(VIEW_TWO);
        vThree = savedInstanceState.getBoolean(VIEW_THREE);
        vFour = savedInstanceState.getBoolean(VIEW_FOUR);
        vFive = savedInstanceState.getBoolean(VIEW_FIVE);
        vSix = savedInstanceState.getBoolean(VIEW_SIX);
        vSeven = savedInstanceState.getBoolean(VIEW_SEVEN);
        vEight = savedInstanceState.getBoolean(VIEW_EIGHT);
        vNine = savedInstanceState.getBoolean(VIEW_NINE);
        oOne = savedInstanceState.getBoolean(OPP_ONE);
        oTwo = savedInstanceState.getBoolean(OPP_TWO);
        oThree = savedInstanceState.getBoolean(OPP_THREE);
        oFour = savedInstanceState.getBoolean(OPP_FOUR);
        oFive = savedInstanceState.getBoolean(OPP_FIVE);
        oSix = savedInstanceState.getBoolean(OPP_SIX);
        oSeven = savedInstanceState.getBoolean(OPP_SEVEN);
        oEight = savedInstanceState.getBoolean(OPP_EIGHT);
        oNine = savedInstanceState.getBoolean(OPP_NINE);
        gameStatus = savedInstanceState.getBoolean(GAME_STATUS);
        loadedList = savedInstanceState.getIntegerArrayList(POSITION_LIST);
        viewList = new LinkedList<>(loadedList);
        Log.e("restoreState", String.valueOf(viewList.size()));
        gameResult = savedInstanceState.getInt(GAME_RESULT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/fascinate.ttf");

        oneOne = (ImageView) findViewById(R.id.one_one);
        oneTwo = (ImageView) findViewById(R.id.one_two);
        oneThree = (ImageView) findViewById(R.id.one_three);
        twoOne = (ImageView) findViewById(R.id.two_one);
        twoTwo = (ImageView) findViewById(R.id.two_two);
        twoThree = (ImageView) findViewById(R.id.two_three);
        threeOne = (ImageView) findViewById(R.id.three_one);
        threeTwo = (ImageView) findViewById(R.id.three_two);
        threeThree = (ImageView) findViewById(R.id.three_three);
        resultTv = (TextView) findViewById(R.id.result_tv);
        gameNameTv = (TextView) findViewById(R.id.title_tv);
        ngTv = (TextView) findViewById(R.id.novembergave);

        resultTv.setTypeface(custom_font);
        gameNameTv.setTypeface(custom_font);
        ngTv.setTypeface(custom_font);

        gameNameTv.setOnClickListener(openWeb);
        ngTv.setOnClickListener(openWeb);

        oneOne.setOnClickListener(setNyan);
        oneTwo.setOnClickListener(setNyan);
        oneThree.setOnClickListener(setNyan);
        twoOne.setOnClickListener(setNyan);
        twoTwo.setOnClickListener(setNyan);
        twoThree.setOnClickListener(setNyan);
        threeOne.setOnClickListener(setNyan);
        threeTwo.setOnClickListener(setNyan);
        threeThree.setOnClickListener(setNyan);

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
            Log.e("restoring savedInstance", String.valueOf(viewList.size()));
            Log.d("resotring savedInstance", String.valueOf(loadedList.size()));

            if (vOne) {
                oneOne.setImageResource(R.drawable.nyanone);
                Log.e("vOne set", "has been entered");
            } else if (oOne) {
                oneOne.setImageResource(R.drawable.nyantwo);
            }
            if (vTwo) {
                oneTwo.setImageResource(R.drawable.nyanone);
            } else if (oTwo) {
                oneTwo.setImageResource(R.drawable.nyantwo);
            }
            if (vThree) {
                oneThree.setImageResource(R.drawable.nyanone);
            } else if (oThree) {
                oneThree.setImageResource(R.drawable.nyantwo);
            }
            if (vFour) {
                twoOne.setImageResource(R.drawable.nyanone);
            } else if (oFour) {
                twoOne.setImageResource(R.drawable.nyantwo);
            }
            if (vFive) {
                twoTwo.setImageResource(R.drawable.nyanone);
            } else if (oFive) {
                twoTwo.setImageResource(R.drawable.nyantwo);
            }
            if (vSix) {
                twoThree.setImageResource(R.drawable.nyanone);
            } else if (oSix) {
                twoThree.setImageResource(R.drawable.nyantwo);
            }
            if (vSeven) {
                threeOne.setImageResource(R.drawable.nyanone);
            } else if (oSeven) {
                threeOne.setImageResource(R.drawable.nyantwo);
            }
            if (vEight) {
                threeTwo.setImageResource(R.drawable.nyanone);
            } else if (oEight) {
                threeTwo.setImageResource(R.drawable.nyantwo);
            }
            if (vNine) {
                threeThree.setImageResource(R.drawable.nyanone);
            } else if (oNine) {
                threeThree.setImageResource(R.drawable.nyantwo);
            }

            if (!gameStatus) {
                switch (gameResult) {
                    case WIN:
                        win();
                        break;
                    case LOSE:
                        lose();
                        break;
                    case DRAW:
                        draw();
                        break;
                }
            }

        } else {
            createList();
        }
    }

    private void generatePCMoves() {
        if (userClicked && viewList.size() > 0) {
            Collections.shuffle(viewList);
            int gridNumber = viewList.get(1);
            Log.e("gridNumber value", String.valueOf(gridNumber));
            switch (gridNumber) {
                case 1:
                    oneOne.setImageResource(R.drawable.nyantwo);
                    oOne = true;
                    break;
                case 2:
                    oneTwo.setImageResource(R.drawable.nyantwo);
                    oTwo = true;
                    break;
                case 3:
                    oneThree.setImageResource(R.drawable.nyantwo);
                    oThree = true;
                    break;
                case 4:
                    twoOne.setImageResource(R.drawable.nyantwo);
                    oFour = true;
                    break;
                case 5:
                    twoTwo.setImageResource(R.drawable.nyantwo);
                    oFive = true;
                    break;
                case 6:
                    twoThree.setImageResource(R.drawable.nyantwo);
                    oSix = true;
                    break;
                case 7:
                    threeOne.setImageResource(R.drawable.nyantwo);
                    oSeven = true;
                    break;
                case 8:
                    threeTwo.setImageResource(R.drawable.nyantwo);
                    oEight = true;
                    break;
                case 9:
                    threeThree.setImageResource(R.drawable.nyantwo);
                    oNine = true;
                    break;
            }
            viewList.remove(viewList.indexOf(gridNumber));

            Log.d("viewList after nyantwo", String.valueOf(viewList.size()));

            checkIfWin();

            userClicked = false;


        }
    }

    private void checkIfWin() {
        if (vOne && vTwo && vThree) {
            win();
        } else if (vOne && vFive && vNine) {
            win();
        } else if (vThree && vFive && vSeven) {
            win();
        } else if (vOne && vFour && vSeven) {
            win();
        } else if (vTwo && vFive && vEight) {
            win();
        } else if (vThree && vSix && vNine) {
            win();
        } else if (vFour && vFive && vSix) {
            win();
        } else if (vSeven && vEight && vNine) {
            win();
        } else if (viewList.size() == 0) {
            draw();
        }

        if (oOne && oTwo && oThree) {
            lose();
        } else if (oOne && oFive && oNine) {
            lose();
        } else if (oThree && oFive && oSeven) {
            lose();
        } else if (oOne && oFour && oSeven) {
            lose();
        } else if (oTwo && oFive && oEight) {
            lose();
        } else if (oThree && oSix && oNine) {
            lose();
        } else if (oFour && oFive && oSix) {
            lose();
        } else if (oSeven && oEight && oNine) {
            lose();
        }

    }

    private void win() {
        resultTv.setText(getString(R.string.you_win));
        resultTv.setVisibility(View.VISIBLE);
        resultTv.setOnClickListener(restart);
        gameStatus = false;
        gameResult = WIN;
    }

    private void lose() {
        resultTv.setText(getString(R.string.lose));
        resultTv.setVisibility(View.VISIBLE);
        resultTv.setOnClickListener(restart);
        gameStatus = false;
        gameResult = LOSE;
    }

    private void draw() {
        resultTv.setText(getString(R.string.draw));
        resultTv.setVisibility(View.VISIBLE);
        resultTv.setOnClickListener(restart);
        gameStatus = false;
        gameResult = DRAW;
    }

    private void createList() {
        viewList = new LinkedList<>();
        for (int i = 1; i <= numberOfViews; i++) {
            viewList.add(i);
            Log.d("viewList.add value", String.valueOf(viewList.size()));
        }
    }

}
