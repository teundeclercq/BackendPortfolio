package nl.teundeclercq.portofolio.Interface;

import nl.teundeclercq.portofolio.Models.PortfolioItem;

import java.sql.SQLException;
import java.util.List;

public interface IPortfolioItem {
    List<PortfolioItem> getAllPortfolioItems() throws SQLException;
    PortfolioItem getPortfolioItem(Long id) throws SQLException;

}
