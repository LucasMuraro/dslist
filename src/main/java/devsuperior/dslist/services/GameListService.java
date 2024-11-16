package devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devsuperior.dslist.Entities.Game;
import devsuperior.dslist.Entities.GameList;
import devsuperior.dslist.dto.GameDTO;
import devsuperior.dslist.dto.GameListDTO;
import devsuperior.dslist.dto.GameMinDTO;
import devsuperior.dslist.repositories.GameListRepository;
import devsuperior.dslist.repositories.GameRepository;

@Service

public class GameListService {

    // o Spring irá injetar uma instância de GameRepository dentro dessa classe (GameService) 
    @Autowired
    private GameListRepository gameListRepository;

    // Busca por todos
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
}
