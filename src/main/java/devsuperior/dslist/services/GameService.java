package devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devsuperior.dslist.Entities.Game;
import devsuperior.dslist.dto.GameDTO;
import devsuperior.dslist.dto.GameMinDTO;
import devsuperior.dslist.projections.GameMinProjection;
import devsuperior.dslist.repositories.GameRepository;

@Service

public class GameService {

    // o Spring irá injetar uma instância de GameRepository dentro dessa classe (GameService) 
    @Autowired
    private GameRepository gameRepository;

    // Busca por Id
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    // Busca por todos
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        return dto;
    }
}
