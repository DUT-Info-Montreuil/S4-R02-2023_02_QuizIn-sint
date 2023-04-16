package Test.fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.ressources;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;

import java.util.ArrayList;

public class ServiceStatsQuestCorrecte implements IServiceQuestionnaire {


    @Override
    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        QuestionDTO questionOcean = new QuestionDTO(1,"Quel est le plus grand océan du monde ?","Océan Pacifique","fr",1);
        QuestionDTO questionDesert = new QuestionDTO(2,"Quel est le plus grand désert du monde ?","Désert de l'Antarctique.","fr",1);
        QuestionDTO questionParis = new QuestionDTO(3,"Quelle est la capitale de la France ?","Paris","fr",2);
        List<StatsQuestDTO> statsQuestions = new ArrayList();
        statsQuestions.add(new StatsQuestDTO(7, 5, 1));
        statsQuestions.add(new StatsQuestDTO(1, 7, 2));
        statsQuestions.add(new StatsQuestDTO(3, 7, 3));
        return new MeilleurQuestionnaireDTO(1,9,questionDesert,questionOcean);
    }


}



