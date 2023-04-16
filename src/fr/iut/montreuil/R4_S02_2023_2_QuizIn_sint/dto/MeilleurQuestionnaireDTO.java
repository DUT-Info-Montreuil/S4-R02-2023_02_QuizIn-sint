package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto;

public class MeilleurQuestionnaireDTO {
    private int idQuestionnaire;
    private int nbDeFoisJoueQuestionnaire;
    private QuestionDTO questionPireReussite;
    private QuestionDTO  questionMeilleurReussite;

    public MeilleurQuestionnaireDTO(){}

    public MeilleurQuestionnaireDTO(int idQuestionnaire, int nbDeFoisJoueQuestionnaire, QuestionDTO questionPireReussite, QuestionDTO questionMeilleurReussite) {
        this.idQuestionnaire = idQuestionnaire;
        this.nbDeFoisJoueQuestionnaire = nbDeFoisJoueQuestionnaire;
        this.questionPireReussite = questionPireReussite;
        this.questionMeilleurReussite = questionMeilleurReussite;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getNbDeFoisJoueQuestionnaire() {
        return nbDeFoisJoueQuestionnaire;
    }

    public void setNbDeFoisJoueQuestionnaire(int nbDeFoisJoueQuestionnaire) {
        this.nbDeFoisJoueQuestionnaire = nbDeFoisJoueQuestionnaire;
    }

    public QuestionDTO getQuestionPireReussite() {
        return questionPireReussite;
    }

    public void setQuestionPireReussite(QuestionDTO questionPireReussite) {
        this.questionPireReussite = questionPireReussite;
    }

    public QuestionDTO getQuestionMeilleurReussite() {
        return questionMeilleurReussite;
    }

    public void setQuestionMeilleurReussite(QuestionDTO questionMeilleurReussite) {
        this.questionMeilleurReussite = questionMeilleurReussite;
    }

    @Override
    public String toString() {
        return "BestOfQuestionnaireDTO{" +
                "idQuestionnaire=" + idQuestionnaire +
                ", nbDeFoisJoueQuestionnaire=" + nbDeFoisJoueQuestionnaire +
                ", questionPireReussite=" + questionPireReussite +
                ", questionMeilleurReussite=" + questionMeilleurReussite +
                '}';
    }
}