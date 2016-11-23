package kr.co.fun25.friday.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.co.fun25.friday.domain.Portfolio;

@Repository("PortfolioDAO")
public interface PortfolioDAO extends JpaRepository<Portfolio, Long> {

}
