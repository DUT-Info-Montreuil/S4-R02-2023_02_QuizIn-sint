package Test.fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.ressources;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.QuestionDTO;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.QuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.StatsQuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class ServiceStatsQuestCorrecte implements IServiceQuestionnaire {


    @Override
    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        QuestionDTO question1 = new QuestionDTO(1,"fr", "Quelle est la capitale de l'Espagne", "Madrid" , 1, new StatsQuestionDTO(7, 3));
        QuestionDTO question2 = new QuestionDTO(2, "Qui est le prof de Dev qualité", "Jeremy", "fr", 3,new StatsQuestionDTO(7, 6));
        QuestionDTO question3 = new QuestionDTO(3, "Quelle pays est le plus froid", "Russie", "fr", 2, new StatsQuestionDTO(7, 5));


        return new MeilleurQuestionnaireDTO(1, 9, question1, question2);
    }


}



