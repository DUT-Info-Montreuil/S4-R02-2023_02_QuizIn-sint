package Test.fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.Mock;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.dto.MeilleurQuestionnaireDTO;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreDeFoisJoueExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.NombreReponseExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.exception.PasDeStatsExceptions;
import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles.IServiceQuestionnaire;
import fr.iut.montreuil.R4_S02_2023_2_Quizin.questionnaire_sme.entities.dto.QuestionnaireDTO;

public class ServiceQuestionnaireMockStatsVideIncorrect implements IServiceQuestionnaire {

    @Override
    public MeilleurQuestionnaireDTO recupererLesStats(QuestionnaireDTO questionnaireDTO) throws PasDeStatsExceptions, NombreDeFoisJoueExceptions, NombreReponseExceptions {
        throw new PasDeStatsExceptions();
    }
}
