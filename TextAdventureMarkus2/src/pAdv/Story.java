package pAdv;

import pAdvI.Item;

public class Story {
    Game game;
    Ui ui;
    VisibilityManager vM;
    Player player = new Player();
    int level = 0;



    public Story(Game gCon, Ui uiCon, VisibilityManager vMCon) {
        game = gCon;
        ui = uiCon;
        vM = vMCon;
    }

    public void defaultSetup() {
        //player.hp = 3;
        ui.hpnumberLabel.setText("" + player.hp);
        ui.punkteNumberLabel.setText(""+ player.punkte);
        player.currentWeapon = new Item("Fist", 1);
        ui.weaponNameLabel.setText("" + player.currentWeapon.name);

    }

    public void gameScreenStart() {

        defaultSetup();
        player.punkte = 0;
        level = 0;
        player.hp = 3;
        ui.hpnumberLabel.setText("" + player.hp);
        ui.mainTextArea.setText("You are standing in front of the Castle of the emperor Markush.  " +
                "He is waiting on the top of the castle to prove your knowledge about him. " +
                "If you manage to answer all questions and defeat him in a final boss fight you will be the new emperor of the land. " +
                "Are you brave enough to defeat him? Lets find out.");
        ui.choice1.setText("Enter the castle");
        ui.choice2.setText("Eat a cookie");
        ui.choice3.setText("Go Home");
        ui.choice4.setVisible(false);
        ui.choice2.setVisible(true);
        ui.choice3.setVisible(true);

    }

    public void gameOverScreen(){
        defaultSetup();
        ui.mainTextArea.setText("Game Over" +
                "");
        player.hp = 0;
        ui.hpnumberLabel.setText("" + player.hp);
        ui.choice2.setVisible(false);
        ui.choice3.setVisible(false);
        ui.choice4.setVisible(false);
        ui.choice1.setText("Restart");
        level = -2;
    }

    public void choice1() {
        defaultSetup();

        if (level == -2) {
            vM.showTitleScreen();
        }
        if (level == 1 || level == 2 || level == 3 || level == 5){
            player.punkte--;
            defaultSetup();
            ui.mainTextArea.setText("Wrong");
            player.hp -= 1;
            ui.hpnumberLabel.setText("" + player.hp);
            if(player.hp == 0){
                gameOverScreen();
            }
        }

        if (level == 0) {
            level = 1;
            ui.mainTextArea.setText("Here comes the first question: \n" +
                    "How old is Markus's cat Snoopy?");
            ui.choice2.setVisible(true);
            ui.choice4.setVisible(true);
            ui.choice1.setText("14");
            ui.choice2.setText("13");
            ui.choice3.setText("10");
            ui.choice4.setText("11");
        }

        if (level == -1) {
            vM.showTitleScreen();
            level = 0;
        }

        if (level == 4) {
            player.punkte++;
            level = 5;
            defaultSetup();
            ui.mainTextArea.setText("You've come a long way. Here is the last question. " +
                    "What's Markus's favorite game?");
            ui.choice1.setText("DayZ");
            ui.choice2.setText("Undertale");
            ui.choice3.setText("CSGO");
            ui.choice4.setText("TBOI");
        }

    }

    public void choice2() {
        if (level == 3 || level == 4){
            player.punkte--;
            defaultSetup();
            ui.mainTextArea.setText("Wrong");
            player.hp -= 1;
            ui.hpnumberLabel.setText("" + player.hp);
            if(player.hp == 0){
                gameOverScreen();
            }
        }
        if (level == 0) {
            defaultSetup();
            ui.mainTextArea.setText("The cookie is pumping you with motivation and you HP increases in 1");
            player.hp = 4;
            ui.hpnumberLabel.setText("" + player.hp);
            ui.choice2.setVisible(false);
        }
        if (level == 2) {
            player.punkte++;
            level = 3;
            defaultSetup();
            ui.mainTextArea.setText("This Question was also answered correctly. The next question: " +
                    "What's Markus favorite drink?");
            ui.choice1.setText("Fanta Grape");
            ui.choice2.setText("Cola");
            ui.choice3.setText("Tea");
            ui.choice4.setText("Water");
        }

        if (level == 1) {
            player.punkte++;
            level = 2;
            defaultSetup();
            ui.mainTextArea.setText("Good job. This Question was answered correctly " +
                    "What is Markus's favorite food in a restaurant?");
            ui.choice1.setText("Döner Teller");
            ui.choice2.setText("Döner");
            ui.choice3.setText("Indian");
            ui.choice4.setText("Italian");
        }

        if (level == 5) {
            player.punkte++;
            level = 6;
            defaultSetup();
            if(player.punkte == 5) {

                ui.mainTextArea.setText("You have made it to the End. I'm very impressed, now are you ready to defeat Markush? " +
                        "For your points you receive"+
                        "What is you first move?");
            }
            ui.choice1.setText("a1");
            ui.choice2.setText("a2");
            ui.choice3.setText("a3");
            ui.choice4.setText("a4");
        }

    }

    public void choice3() {
        defaultSetup();
        if (level == 0) {
            gameOverScreen();
        }

        if (level == 1 || level == 2 || level == 3 || level == 4 || level == 5){
            player.punkte--;
            defaultSetup();
            ui.mainTextArea.setText("Wrong");
            player.hp -= 1;
            ui.hpnumberLabel.setText("" + player.hp);
            if(player.hp == 0){
                gameOverScreen();
            }
        }
    }

    public void choice4() {
        defaultSetup();
        if (level == 1 || level == 2 || level == 4 || level == 5){
            player.punkte--;
            defaultSetup();
            ui.mainTextArea.setText("Wrong");
            player.hp -= 1;
            ui.hpnumberLabel.setText("" + player.hp);
            if(player.hp == 0){
                gameOverScreen();
            }
        }

        if (level == 3) {
            player.punkte++;
            level = 4;
            defaultSetup();
            ui.mainTextArea.setText("You are extremely good, here comes the next question. " +
                    "What does Markus like to do the most?");
            ui.choice1.setText("Free time with Dascha");
            ui.choice2.setText("Eating");
            ui.choice3.setText("Playing videogames");
            ui.choice4.setText("Free time with friends");
        }
    }
}


