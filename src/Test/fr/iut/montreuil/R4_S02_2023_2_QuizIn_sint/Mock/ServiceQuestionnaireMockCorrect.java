package Test.fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.Mock;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;

import java.util.ArrayList;

public class ServiceQuestionnaireMockCorrect implements IServiceQuestionnaire {


    @Override
    public MeilleurQuestionnaireDTO meilleurQuestionnaire(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        QuestionDTO q1 = new QuestionDTO(1,"Quelle est le président français","Macron","fr",1);
        QuestionDTO q2 = new QuestionDTO(2,"Quel est le meilleur département de l'iut","INFO","fr",1);
        QuestionDTO q3 = new QuestionDTO(3,"Quelle est le pays le plus cool","Yemen","fr",2);
        List<StatsQuestionsDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestionsDTO(1, 7, 5));
        statsQuestions.add(new StatsQuestionsDTO(2, 7, 1));
        statsQuestions.add(new StatsQuestionsDTO(3, 7, 3));
        return new MeilleurQuestionnaireDTO(1,9,q2,q1);
    }
