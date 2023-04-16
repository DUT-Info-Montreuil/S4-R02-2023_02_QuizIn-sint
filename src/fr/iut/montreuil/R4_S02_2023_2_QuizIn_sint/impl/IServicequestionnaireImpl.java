package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.impl;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.QuestionnaireDTO;

public class IServicequestionnaireImpl implements IServiceQuestionnaire {

    @Override
    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        MeilleurQuestionnaireDTO bestOfQuestionnaireDTO = new MeilleurQuestionnaireDTO();
        bestOfQuestionnaireDTO.setIdQuestionnaire(questionnaireDTO.getIdQuestionnaire());
        if (questionnaireDTO.getNbJouerQuestionnaire() < 0)
            throw new NombreDeFoisJoueExceptions();
        bestOfQuestionnaireDTO.setNbDeFoisJoueQuestionnaire(questionnaireDTO.getNbJouerQuestionnaire());

        QuestionDTO meilleurTaux;
        int i = 0;
        do {
            meilleurTaux = questionnaireDTO.getQuestions().get(i);
        } while (meilleurTaux.getStatsQuestion().getNbJouer() <= 0);

        for (QuestionDTO questionDTO : questionnaireDTO.getQuestions()) {
            if (questionDTO.getStatsQuestion() == null)
                throw new PasDeStatsExceptions();
            if (questionDTO.getStatsQuestion().getNbJouer() > bestOfQuestionnaireDTO.getNbDeFoisJoueQuestionnaire())
                throw new NombreDeFoisJoueExceptions();
            if (questionDTO.getStatsQuestion().getNbJouer() > 0 || questionDTO.getStatsQuestion().getNbOK() > questionDTO.getStatsQuestion().getNbJouer())
                throw new NombreReponseExceptions();

            if ((float) questionDTO.getStatsQuestion().getNbOK() / questionDTO.getStatsQuestion().getNbJouer() >
                    (float) meilleurTaux.getStatsQuestion().getNbOK() / meilleurTaux.getStatsQuestion().getNbJouer()) {
                meilleurTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestion().getNbOK() / questionDTO.getStatsQuestion().getNbJouer() ==
                    (float) meilleurTaux.getStatsQuestion().getNbOK() / meilleurTaux.getStatsQuestion().getNbJouer()) {
                if (questionDTO.getDifficulte() > meilleurTaux.getDifficulte())
                    meilleurTaux = questionDTO;
                else if (questionDTO.getDifficulte() == meilleurTaux.getDifficulte())
                    if (questionDTO.getStatsQuestion().getNbJouer() > meilleurTaux.getStatsQuestion().getNbJouer())
                        meilleurTaux = questionDTO;
                    else if (questionDTO.getStatsQuestion().getNbJouer() == meilleurTaux.getStatsQuestion().getNbJouer())
                        if (questionDTO.getNum_question() < meilleurTaux.getNum_question())
                            meilleurTaux = questionDTO;
            }

        }
        QuestionDTO pireTaux;
        pireTaux = questionnaireDTO.getQuestions().get(i);

        for (QuestionDTO questionDTO : questionnaireDTO.getQuestions()) {
            if (questionDTO.getStatsQuestion().getNbJouer() > 0
                    && (float) questionDTO.getStatsQuestion().getNbOK() / questionDTO.getStatsQuestion().getNbJouer() <
                    (float) pireTaux.getStatsQuestion().getNbOK() / pireTaux.getStatsQuestion().getNbJouer()) {
                pireTaux = questionDTO;
            } else if ((float) questionDTO.getStatsQuestion().getNbOK() / questionDTO.getStatsQuestion().getNbJouer() ==
                    (float) pireTaux.getStatsQuestion().getNbOK() / pireTaux.getStatsQuestion().getNbJouer()) {
                if (questionDTO.getDifficulte() < pireTaux.getDifficulte())
                    pireTaux = questionDTO;
                else if (questionDTO.getDifficulte() == pireTaux.getDifficulte())
                    if (questionDTO.getStatsQuestion().getNbJouer() > pireTaux.getStatsQuestion().getNbJouer())
                        pireTaux = questionDTO;
                    else if (questionDTO.getStatsQuestion().getNbJouer() == pireTaux.getStatsQuestion().getNbJouer())
                        if (questionDTO.getNum_question() < pireTaux.getNum_question())
                            pireTaux = questionDTO;
            }
        }

        return bestOfQuestionnaireDTO;
    }



}
