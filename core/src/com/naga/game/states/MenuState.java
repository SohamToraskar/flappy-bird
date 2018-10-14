package com.naga.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.naga.game.ProjectNaga;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Color;

public class MenuState extends State{
    private PlayState mClass;
    public static int maxScore;
    public static int mainScreen;

    private BitmapFont font;

    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        cam.setToOrtho(false, ProjectNaga.WIDTH/2,ProjectNaga.HEIGHT/2);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");

        font = new BitmapFont();
        font.setColor(Color.WHITE);
        mClass = new PlayState(gsm);
        maxScore = mClass.finalScore;




    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));

        }

    }


    @Override
    public void update(float dt) {
        handleInput();


    }

    @Override
    public void render(SpriteBatch sb) {

        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0,0);
        sb.draw(playBtn, cam.position.x - playBtn.getWidth()/2, cam.position.y);
        if (mainScreen == 1) {
            font.draw(sb, "Your score: " + maxScore + "", cam.position.x - playBtn.getWidth() / 2 + 10, cam.position.y + 100);
        }
        font.draw(sb, "16-144     16-141     16-116", 27,  50);
        sb.end();

    }

    @Override
    public void dispose() {
        mainScreen = 1;
        background.dispose();
        playBtn.dispose();
        font.dispose();
        System.out.println("Menu state Disposed");
    }
}
