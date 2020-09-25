package pAdv;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
    Ui ui = new Ui();
    ChoiceHandler cHandler = new ChoiceHandler();
    VisibilityManager vM = new VisibilityManager(ui);
    Story story = new Story(this, ui,vM);
    public static void main(String[] args){
        new Game();


    }
    public Game(){
        ui.createUI(cHandler);
        story.defaultSetup();
        vM.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(yourChoice){
                case "start":
                    story.gameScreenStart();
                    vM.showGameScreen();
                break;
                case "c1":
                    story.choice1();
                    break;
                case "c2":
                    story.choice2();
                    break;
                case "c3":
                    story.choice3();
                    break;
                case "c4":
                    story.choice4();
                    break;

            }
        }
    }
}
