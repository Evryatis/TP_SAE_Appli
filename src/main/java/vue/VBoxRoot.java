package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import modele.Position;

public class VBoxRoot extends VBox implements CanvasConstantes{
    Label nbre_pas = new Label();
    Canvas carte = new Canvas();
    Position positionApprenti;

    public VBoxRoot(){
        Label nbre_pas = new Label("Nombre de pas : 0");
        positionApprenti = new Position(15, 15);

        // le canvas et son contexte graphique
        Canvas canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        GraphicsContext graphicsContext2D = canvasCarte.getGraphicsContext2D();

        graphicsContext2D.setStroke(COULEUR_GRILLE);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARREE){
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARREE){
                graphicsContext2D.strokeRect(i, j, CARREE, CARREE);
            }
        }
        canvasCarte.setOnMouseClicked(event -> {
            int abscisse = (int) event.getX() / CARREE;
            int ordonnee = (int) event.getY() / CARREE;
            Position positionCliquee = new Position(abscisse, ordonnee);
            positionApprenti.deplacementUneCase(positionCliquee);
            System.out.println(positionCliquee.toString());
        });

        graphicsContext2D.setFill(COULEUR_APPRENTI);
        graphicsContext2D.fillOval(positionApprenti.getAbscisse()*CARREE + CARREE/8,
            positionApprenti.getOrdonnee()*CARREE+CARREE/4,
                LARGEUR_OVALE, HAUTEUR_OVALE
        );

        //les numéros de colonne
        int numCol = 1;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARREE; i < LARGEUR_CANVAS; i += CARREE){
            graphicsContext2D.fillText(Integer.toString(numCol), i+CARREE/3, CARREE/2);
            numCol++;
        }

        //les numéros de ligne
        int numLigne = 1;
        graphicsContext2D.setFill(COULEUR_GRILLE);
        for (int i = CARREE; i < HAUTEUR_CANVAS; i += CARREE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARREE/3, i+CARREE/2);
            numLigne++;
        }



        this.getChildren().add(nbre_pas);
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));
    }

}
