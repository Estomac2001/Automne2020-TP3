package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Objectif Analyser le texte d'un JTextArea, d'en extraire les mots et les nombres et d'effectuer des recherches et des tris.
 * @author Thomas Laporte - 1976489
 * Session A2020
 */

public class ViewTP3 extends JFrame {
    JFrame frame;
    JPanel panNord;
    JPanel panCentre;
    JPanel panEst;
    JPanel panSud;
    JPanel panSudCentre;

    JTextField txfMotRech;
    JTextArea txaTexte;
    JTextArea txaMots;
    JTextArea txaNombres;

    JButton btnRechercher;
    JButton btnQuitter;
    JButton btnExMots;
    JButton btnViderMots;
    JButton btnExNombres;
    JButton btnViderNombres;
    JButton btnTriMots;
    JButton btnTriNombres;
    JButton btnInfoMots;
    JButton btnInfoNombres;

    JCheckBox chbDoublons;
    JRadioButton radCroissant;
    JRadioButton radDecroissant;
    ButtonGroup radCroiDecroi;

    JLabel labMotRech;
    JLabel labMots;
    JLabel labNbMots;
    JLabel labNombres;
    JLabel labNbNombres;

    Dimension dimBtnBox = new Dimension(140,25);

    public ViewTP3() {

        //--------JFrame--------//

        frame = new JFrame("TP3 Thomas Laporte - 1976489");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setSize(1000, 650);
        frame.setMinimumSize(new Dimension(840, 520));
        frame.setLocationRelativeTo(null);

        //--------JPanel Nord--------//

        panNord = new JPanel(new FlowLayout(FlowLayout.LEFT));
        txfMotRech = new JTextField();
        txfMotRech.setPreferredSize(new Dimension(150, 30));
        btnRechercher = new JButton("Rechercher");
        btnRechercher.setPreferredSize(dimBtnBox);
        btnRechercher.addActionListener(e -> btnRechercherAction());
        labMotRech = new JLabel("");
        labMotRech.setPreferredSize(new Dimension(400,30));
        panNord.add(txfMotRech);
        panNord.add(btnRechercher);
        panNord.add(labMotRech);

        //--------JPanel Centre--------//

        panCentre = new JPanel(new GridLayout(1,3));
        txaTexte = new JTextArea(25, 20);
        txaTexte.setLineWrap(true);
        txaTexte.setWrapStyleWord(true);
        txaMots = new JTextArea(25, 20);
        txaMots.setLineWrap(true);
        txaMots.setWrapStyleWord(true);
        txaMots.setEditable(false);
        txaNombres = new JTextArea(25, 20);
        txaNombres.setLineWrap(true);
        txaNombres.setWrapStyleWord(true);
        txaNombres.setEditable(false);
        panCentre.add(new JScrollPane(txaTexte));
        panCentre.add(new JScrollPane(txaMots));
        panCentre.add(new JScrollPane(txaNombres));

        //--------JPanel Sud--------//

        panSud = new JPanel(new BorderLayout());
        panSudCentre = new JPanel(new FlowLayout());
        labMots = new JLabel("Mots: ");
        labMots.setPreferredSize(new Dimension(35, 20));
        labNbMots = new JLabel("0");
        labNbMots.setPreferredSize(new Dimension(70, 20));
        labNbMots.setHorizontalTextPosition(JLabel.LEFT);
        labNombres = new JLabel("Nombres: ");
        labNombres.setPreferredSize(new Dimension(60, 20));
        labNbNombres = new JLabel("0");
        labNbNombres.setPreferredSize(new Dimension(70, 20));
        labNbNombres.setHorizontalTextPosition(JLabel.LEFT);
        btnQuitter = new JButton("Quitter");
        btnQuitter.setPreferredSize(dimBtnBox);
        btnQuitter.addActionListener(e -> btnQuitterAction());
        panSudCentre.add(labMots);
        panSudCentre.add(labNbMots);
        panSudCentre.add(labNombres);
        panSudCentre.add(labNbNombres);
        panSud.add(panSudCentre, BorderLayout.CENTER);
        panSud.add(btnQuitter, BorderLayout.EAST);

        //--------JPanel Est--------//

        panEst = new JPanel();
        panEst.setLayout(new BoxLayout(panEst, BoxLayout.PAGE_AXIS));
        chbDoublons = new JCheckBox("Permettre doublons");
        chbDoublons.setMaximumSize(dimBtnBox);
        chbDoublons.setSelected(true);
        btnExMots = new JButton("Extraire Mots");
        btnExMots.setMaximumSize(dimBtnBox);
        btnExMots.addActionListener(e -> btnExMotsAction());
        btnViderMots = new JButton("Vider Mots");
        btnViderMots.setMaximumSize(dimBtnBox);
        btnViderMots.addActionListener(e -> btnViderMotsAction());
        btnExNombres = new JButton("Extraire Nombres");
        btnExNombres.setMaximumSize(dimBtnBox);
        btnExNombres.addActionListener(e -> btnExNombresAction());
        btnViderNombres = new JButton("Vider Nombres");
        btnViderNombres.setMaximumSize(dimBtnBox);
        btnViderNombres.addActionListener(e -> btnViderNombresAction());
        radCroissant = new JRadioButton("Tri croissant");
        radCroissant.setMaximumSize(dimBtnBox);
        radCroissant.setSelected(true);
        radDecroissant = new JRadioButton("Tri décroissant");
        radDecroissant.setMaximumSize(dimBtnBox);
        radCroiDecroi = new ButtonGroup();
        radCroiDecroi.add(radCroissant);
        radCroiDecroi.add(radDecroissant);
        btnTriMots = new JButton("Trier Mots");
        btnTriMots.setMaximumSize(dimBtnBox);
        btnTriMots.addActionListener(e -> btnTriMotsAction());
        btnTriNombres = new JButton("Trier Nombres");
        btnTriNombres.setMaximumSize(dimBtnBox);
        btnTriNombres.addActionListener(e -> btnTriNombresAction());
        btnInfoMots = new JButton("Info Mots");
        btnInfoMots.setMaximumSize(dimBtnBox);
        btnInfoMots.addActionListener(e -> btnInfoMotsAction());
        btnInfoNombres = new JButton("Info Nombres");
        btnInfoNombres.setMaximumSize(dimBtnBox);
        btnInfoNombres.addActionListener(e -> btnInfoNombresAction());
        panEst.add(Box.createRigidArea(new Dimension(0, 15)));
        panEst.add(chbDoublons);
        panEst.add(btnExMots);
        panEst.add(btnViderMots);
        panEst.add(Box.createRigidArea(new Dimension(0, 35)));
        panEst.add(btnExNombres);
        panEst.add(btnViderNombres);
        panEst.add(Box.createRigidArea(new Dimension(0, 35)));
        panEst.add(radCroissant);
        panEst.add(radDecroissant);
        panEst.add(btnTriMots);
        panEst.add(btnTriNombres);
        panEst.add(Box.createRigidArea(new Dimension(0, 35)));
        panEst.add(btnInfoMots);
        panEst.add(btnInfoNombres);

        frame.add(panNord, BorderLayout.NORTH);
        frame.add(panCentre, BorderLayout.CENTER);
        frame.add(panSud, BorderLayout.SOUTH);
        frame.add(panEst, BorderLayout.EAST);
        frame.setVisible(true);
    }


    //--------Action Listener--------//

    /**
     * Action Quitter, demande une confirmation et ferme programme.
     */
    private void btnQuitterAction() {
        int fermeture = JOptionPane.showConfirmDialog(frame, "Voulez-vous vraiment quitter?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (fermeture == JOptionPane.YES_OPTION)
            System.exit(0);
    }

    /**
     * Action Rechercher, fouille dans txaMot à partir de txfMotRech. Inscrit le nombre d'occurence dans labMotRech.
     */
    private void btnRechercherAction(){
        int i = 0; // Indice à partir duquel chercher.
        int j = 0; // Indice renvoyé de l'emplacement du mot cherché.
        int compteur = 0; // Compteur de répétitions.
        boolean trouve = false; // Variable de contrôle.
        String indices = ""; // Chaîne correspondant à tous les indices des mots trouvés.
        String[] tabMots = txaMots.getText().trim().split("\\s");
        String mot = txfMotRech.getText().trim();

        while (!trouve && j < tabMots.length - 1) {
            j = nextIndexOf(tabMots, mot, i);
            if (j != -1) {
                i = j + 1;
                compteur++;
            }
            else
                trouve = true;

            if (compteur == 1 && j != -1)
                indices = indices.concat(j + " ");
            else if (compteur > 1 && j != -1)
                indices = indices.concat("et " + j + " ");
        }

        if (compteur == 0)
            labMotRech.setText(compteur + " mot trouvé");
        else if (compteur == 1)
            labMotRech.setText(compteur + " mot trouvé à l'indice " + indices);
        else
            labMotRech.setText(compteur + " mots trouvés aux indices " + indices);
    }

    /**
     * (Je n'ai pas réussi à séparer les mots qui finissent avec un ')
     * Action d'extraire les mots de txaTexte et de les mettres dans txaMots. Met à jour le labNbMots. Avec doublons ou non.
     */

    private void btnExMotsAction(){
        String[] tabMots; // Tableau de chaînes correspondant à tous les mots extraits de txaTexte.
        String transit; // Chaîne pour vérifier doublons.
        boolean occurences = false; // Vérificateur si doublons.
        int j; // Variable de contrôle.
        int nbLignes; // Nombre de lignes (nombres) dans txaNombres.

        tabMots = txaTexte.getText().trim().split("[^A-Za-zàÀâÂäÄçÇéÉèÈêÊëËîÎïÏôÔùÙûÛ']+");

        if (chbDoublons.isSelected()) {
            for (String elem : tabMots)
                txaMots.append(elem + "\n");
        }

        else{
            txaMots.append(tabMots[0] + "\n");
            for (int i=1; i<tabMots.length; i++){
                transit = tabMots[i];
                j = i - 1;

                while (!occurences && j >= 0) {
                    if (transit.equals(tabMots[j])) {
                        occurences = true;
                    }
                    else
                        j--;
                }
                if (!occurences)
                    txaMots.append(tabMots[i] + "\n");
                occurences = false;
            }
        }

        nbLignes = txaMots.getLineCount();
        labNbMots.setText(String.valueOf(nbLignes-1));

    }

    /**
     * Action de vider le txaMots et de mettre à jour le labNbMots.
     */
    private void btnViderMotsAction(){
        txaMots.setText("");
        labNbMots.setText("0");
    }

    /**
     * Action d'extraire uniquement les nombres de txaTexte et de les mettres dans txaNombres. Met à jour le labNbNombres.
     */
    private void btnExNombresAction(){
        String[] tabTexte; // Tableau de chaînes correspondant à tous les nombres extraits de txaTexte.
        int[] tabNb; // Tableau d'entiers correspondant à tous les nombres extraits de txaTexte.
        String valeurIndice; // Valeur en chaîne à l'endroit qu'indique l'indice dans tabNb.
        int nbLignes; // Nombre de lignes (nombres) dans txaNombres.

        tabTexte = txaTexte.getText().trim().split("[^-\\d]+");
        tabNb = new int[tabTexte.length];

        for (int i=0; i<tabTexte.length; i++) {
            try {
                tabNb[i] = Integer.parseInt(tabTexte[i]);
                valeurIndice = String.valueOf(tabNb[i]);
                txaNombres.append(valeurIndice + "\n");

            } catch (NumberFormatException e) {}
        }

        nbLignes = txaNombres.getLineCount();
        labNbNombres.setText(String.valueOf(nbLignes-1));
    }

    /**
     * Action de vider le txaNombres et de mettre à jour le labNbNombres.
     */
    private void btnViderNombresAction(){
        txaNombres.setText("");
        labNbNombres.setText("0");
    }

    /**
     * Action de trier le txaMots, en ordre croissant ou décroissant, selon le groupe radCroiDecroi. Remet à jour le labNbMots.
     */
    private void btnTriMotsAction(){
        String[] tabTri = txaMots.getText().trim().split("\\s"); // Tableau de chaînes avec tous les mots à trier.
        int nbLignes; // Nombre de lignes (nombres) dans txaMots.

        if (radCroissant.isSelected()){
            txaMots.setText("");
            triSSSUpString(tabTri);

            for (int i=0; i<tabTri.length; i++)
                txaMots.append(tabTri[i] + "\n");
        }

        else {
            txaMots.setText("");
            triSSSDownString(tabTri);

            for (int i=0; i<tabTri.length; i++)
                txaMots.append(tabTri[i] + "\n");
        }

        nbLignes = txaMots.getLineCount();
        labNbMots.setText(String.valueOf(nbLignes-1));
    }

    /**
     * Action de trier le txaNombres, en ordre croissant ou décroissant, selon le groupe radCroiDecroi. Remet à jour le labNbMots.
     */
    private void btnTriNombresAction(){
        String[] tabStPasTri = txaNombres.getText().trim().split("\\s"); // Tableau de chaînes avec tous les nombres à trier.
        int[] tabIntTri = new int[tabStPasTri.length]; // Tableau d'entiers à trier correspondant à tous les nombres extraits de txaNombres.
        int nbLignes; // Nombre de lignes (nombres) dans txaNombres.


        for (int i=0; i<tabStPasTri.length; i++) {
            try {
                tabIntTri[i] = Integer.parseInt(tabStPasTri[i]);
            }catch (NumberFormatException e) {}
        }

        if (radCroissant.isSelected()){
            txaNombres.setText("");
            triSSSUpInt(tabIntTri);

            for (int i=0; i<tabIntTri.length; i++)
                txaNombres.append(tabIntTri[i] + "\n");
        }

        else {
            txaNombres.setText("");
            triSSSDownInt(tabIntTri);

            for (int i=0; i<tabIntTri.length; i++)
                txaNombres.append(tabIntTri[i] + "\n");
        }

        nbLignes = txaNombres.getLineCount();
        labNbNombres.setText(String.valueOf(nbLignes-1));
    }

    /**
     * Action d'afficher les informations sur le txaMots. Plus court et plus long mots.
     */
    private void btnInfoMotsAction(){
        String[] tabInfo = txaMots.getText().trim().split("\\s"); // Tableau de chaînes avec tous les mots de txaMots.
        String info; // Chaîne correspondant à toutes les informations sur le txaMots.
        String motCourt = sShorter(tabInfo); //Chaîne du mot le plus court.
        String motLong = sLonger(tabInfo); //Chaîne du mot le plus long.

        info = "Mot le plus court: " + motCourt + "\n" + "Mot le plus long: " + motLong;
        JOptionPane.showMessageDialog(frame, info, "Info Mots", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Action d'afficher les informations sur le txaNombres. Plus petit et plus grand nombres.
     */
    private void btnInfoNombresAction(){
        String[] tabNombres = txaNombres.getText().trim().split("\\s"); // Tableau de chaînes avec tous les nombres à trier.
        int[] tabInfo = new int[tabNombres.length]; // Tableau d'entiers à trier correspondant à tous les nombres extraits de txaNombres.
        String info; // Chaîne correspondant à toutes les informations sur le txaMots.
        int nbPetit; //Entier le plus petit.
        int nbGrand; //Entier le plus grand.

        for (int i=0; i<tabNombres.length; i++) {
            try {
                tabInfo[i] = Integer.parseInt(tabNombres[i]);
            }catch (NumberFormatException e) {}
        }

        nbPetit = min(tabInfo);
        nbGrand = max(tabInfo);

        info = "Nombre le plus petit: " + nbPetit + "\n" + "Nombre le plus grand: " + nbGrand;
        JOptionPane.showMessageDialog(frame, info, "Info Nombres", JOptionPane.PLAIN_MESSAGE);
    }

    ///--------Méthodes utilitaires--------//

    /**
     * Retourne l'indice d'une chaîne trouvée dans un tableau de chaînes à partir d'un autre indice. -1 si non trouvé.
     * @param tab (Tableau de chaînes à fouiller)
     * @param mot (mot à chercher)
     * @param i (indice à partir duquel chercher)
     * @return le nouvel indice du mot trouvé.
     */
    public static int nextIndexOf(String[] tab, String mot, int i){
        boolean trouve = false; // Variable de contrôle

        while (i < tab.length && !trouve) {
            if (mot.equals(tab[i])) {
               trouve = true;
            }
            else
                i++;
        }

        if ((tab[tab.length - 1] != mot) && (i == tab.length))
            i = -1;

        return i;
    }

    /**
     * Interchanger deux éléments aux indices données (i1 et i2) dans un même tableau d'entier.
     * @param tableau (Tableau donné contanant les éléments à interchanger)
     * @param i1 (Indice premier élément à changer)
     * @param i2 (Indice premier élément à changer)
     */
    public static void interchangerInt(int[] tableau, int i1, int i2){
        int transit = tableau[i1];
        tableau[i1] = tableau[i2];
        tableau[i2] = transit;
    }

    /**
     * Interchanger deux éléments aux indices données (i1 et i2) dans un même tableau de chaînes.
     * @param tableau (Tableau donné contanant les éléments à interchanger)
     * @param i1 (Indice premier élément à changer)
     * @param i2 (Indice premier élément à changer)
     */
    public static void interchangerString(String[] tableau, int i1, int i2){
        String transit = tableau[i1];
        tableau[i1] = tableau[i2];
        tableau[i2] = transit;
    }

    /**
     * Tri SSS en ordre croissant un tableau d'entiers.
     * @param tab (Tableau d'entiers à trier)
     */
    public static void triSSSUpInt(int[] tab){
        int iMin; // Indice du plus petit.

        for (int i=0; i<tab.length-1; i++){
            iMin = i;

            for (int j=i+1; j<tab.length; j++)
                if (tab[j] < tab[iMin])
                    iMin = j;

            if (iMin != i) {
                interchangerInt(tab, iMin, i);
            }
        }
    }

    /**
     * Tri SSS en ordre décroissant un tableau d'entiers.
     * @param tab (Tableau d'entiers à trier)
     */
    public static void triSSSDownInt(int[] tab){
        int iMax; // Indice du plus grand.

        for (int i=0; i<tab.length-1; i++){
            iMax = i;

            for (int j=i+1; j<tab.length; j++)
                if (tab[j] > tab[iMax])
                    iMax = j;

            if (iMax != i) {
                interchangerInt(tab, iMax, i);
            }
        }
    }

    /**
     * Tri SSS en ordre croissant un tableau de chaînes.
     * @param tab (Tableau d'entiers à trier)
     */
    public static void triSSSUpString(String[] tab){
        int iMin; // Indice du plus petit.

        for (int i=0; i<tab.length-1; i++){
            iMin = i;

            for (int j=i+1; j<tab.length; j++)
                if (tab[j].compareTo(tab[iMin]) < 0)
                    iMin = j;

            if (iMin != i) {
                interchangerString(tab, iMin, i);
            }
        }
    }

    /**
     * Tri SSS en ordre décroissant un tableau de chaînes.
     * @param tab (Tableau d'entiers à trier)
     */
    public static void triSSSDownString(String[] tab){
        int iMax; // Indice du plus grand.

        for (int i=0; i<tab.length-1; i++){
            iMax = i;

            for (int j=i+1; j<tab.length; j++)
                if (tab[j].compareTo(tab[iMax]) > 0)
                    iMax = j;

            if (iMax != i) {
                interchangerString(tab, iMax, i);
            }
        }
    }

    /**
     * Retourner l'entier le plus petit dans le tableau.
     * @param tab (Tableau d'entiers provenant de txaNombres)
     * @return l'entier le plus petit
     */
    public static int min(int[] tab){
        int minInt = tab[0]; // Entier le plus petit dans le tableau.

        for (int i=1; i<tab.length; i++){
            if (tab[i] < minInt)
                minInt = tab[i];
        }
        return minInt;
    }

    /**
     * Retourner l'entier le plus grand dans le tableau.
     * @param tab (Tableau d'entiers provenant de txaNombres)
     * @return l'entier le plus grand
     */
    public static int max(int[] tab){
        int maxInt = tab[0]; // Entier le plus grand dans le tableau.

        for (int i=1; i<tab.length; i++){
            if (tab[i] > maxInt)
                maxInt = tab[i];
        }
        return maxInt;
    }

    /**
     * Retourner le mot le plus court dans le tableau.
     * @param tab (Tableau de chaînes provenant de txaMots)
     * @return la chaîne la plus courte
     */
    public static String sShorter(String[] tab){
        String minString = tab[0]; // Chaîne la plus courte du tableau.

        for (int i=1; i<tab.length; i++){
            if (tab[i].length() < minString.length())
                minString = tab[i];
        }
        return minString;
    }

    /**
     * Retourner l'entier le plus grand dans le tableau
     * @param tab (Tableau de chaînes provenant de txaMots)
     * @return la chaîne la plus grande
     */
    public static String sLonger(String[] tab){
        String maxString = tab[0]; // Chaîne la plus longue du tableau.

        for (int i=1; i<tab.length; i++){
            if (tab[i].length() > maxString.length())
                maxString = tab[i];
        }
        return maxString;
    }

    public static void main(String[] args) {
        ViewTP3 v = new ViewTP3();
    }
}
