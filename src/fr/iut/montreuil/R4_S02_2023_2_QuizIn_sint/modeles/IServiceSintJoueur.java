package fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.modeles;

import fr.iut.montreuil.R4_S02_2023_2_QuizIn_sint.entities.dto.StatsDTO;

import java.util.Map;

public interface IServiceSintJoueur {

    public abstract Map<String, StatsDTO> recupererStatsJoueur();

}
