package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;


public interface IServiceQuestionnaire {

    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions;
}

