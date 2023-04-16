package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.entities.dto;

public class StatsDTO {

    private int nbParties, nbQuestions, nbBonnesReponses, dureePartie;
    private double avgReponses, avgTemps;

    public StatsDTO(int nbParties, int nbQuestions, int nbBonnesReponses, int duree, double avgReponses, double avgDuree) {
        this.nbParties = nbParties;
        this.nbQuestions = nbQuestions;
        this.nbBonnesReponses = nbBonnesReponses;
        this.dureePartie = duree;
        this.avgReponses = avgReponses;
        this.avgTemps = avgDuree;
    }

}
