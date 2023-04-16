package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;

public class IServicequestionnaireImpl implements IServiceQuestionnaire {

    @Override
    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        MeilleurQuestionnaireDTO bestOfQuestionnaireDTO = new MeilleurQuestionnaireDTO();
        bestOfQuestionnaireDTO.setIdQuestionnaire(questionnaireDTO.getIdQuestionnaire());
        if (questionnaireDTO.getNbDeFoisJoueQuestionnaire() < 0)
            throw new NombreDeFoisJoueExceptions();
        bestOfQuestionnaireDTO.setNbDeFoisJoueQuestionnaire(questionnaireDTO.getNbDeFoisJoueQuestionnaire());

        QuestionDTO meilleurTaux;
        int i = 0;
        do {
            meilleurTaux = questionnaireDTO.getListeQuestions().get(i);
        } while (meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion() <= 0);

        for (QuestionDTO questionDTO : questionnaireDTO.getListeQuestions()) {
            if (questionDTO.getStatsQuestions() == null)
                throw new PasDeStatsExceptions();
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > bestOfQuestionnaireDTO.getNbDeFoisJoueQuestionnaire())
                throw new NombreDeFoisJoueExceptions();
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > 0 || questionDTO.getStatsQuestions().getNbDeReussiteQuestion() > questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion())
                throw new NombreReponseExceptions();

            if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() >
                    (float) meilleurTaux.getStatsQuestions().getNbDeReussiteQuestion() / meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                meilleurTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() ==
                    (float) meilleurTaux.getStatsQuestions().getNbDeReussiteQuestion() / meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                if (questionDTO.getDifficultes() > meilleurTaux.getDifficultes())
                    meilleurTaux = questionDTO;
                else if (questionDTO.getDifficultes() == meilleurTaux.getDifficultes())
                    if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        meilleurTaux = questionDTO;
                    else if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() == meilleurTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        if (questionDTO.getNumQuestion() < meilleurTaux.getNumQuestion())
                            meilleurTaux = questionDTO;
            }

        }
        QuestionDTO pireTaux;
        pireTaux = questionnaireDTO.getListeQuestions().get(i);

        for (QuestionDTO questionDTO : questionnaireDTO.getListeQuestions()) {
            if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > 0
                    && (float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() <
                    (float) pireTaux.getStatsQuestions().getNbDeReussiteQuestion() / pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                pireTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestions().getNbDeReussiteQuestion() / questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() ==
                    (float) pireTaux.getStatsQuestions().getNbDeReussiteQuestion() / pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion()) {
                if (questionDTO.getDifficultes() < pireTaux.getDifficultes())
                    pireTaux = questionDTO;
                else if (questionDTO.getDifficultes() == pireTaux.getDifficultes())
                    if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() > pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        pireTaux = questionDTO;
                    else if (questionDTO.getStatsQuestions().getNbDeFoisJoueQuestion() == pireTaux.getStatsQuestions().getNbDeFoisJoueQuestion())
                        if (questionDTO.getNumQuestion() < pireTaux.getNumQuestion())
                            pireTaux = questionDTO;
            }
        }

        return bestOfQuestionnaireDTO;
    }
}
