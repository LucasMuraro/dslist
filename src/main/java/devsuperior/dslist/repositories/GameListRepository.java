package devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devsuperior.dslist.Entities.Game;
import devsuperior.dslist.Entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
