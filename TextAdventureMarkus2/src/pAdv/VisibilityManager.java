package pAdv;

public class VisibilityManager {
Ui ui;
    public VisibilityManager(Ui uiCon){
        ui = uiCon;
    }

    public void showTitleScreen(){
        //StartBildschirm an
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        //Spielbildschrim aus
        ui.mainTextPanel.setVisible(false);
        ui.choiceButtonPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
    }

    public void showGameScreen(){
        //StartBildschirm aus
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        //Spielbildschrim an
        ui.mainTextPanel.setVisible(true);
        ui.choiceButtonPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
    }
}
